package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.Impl;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.*;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.DTOs.SerieDTO;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Enums.*;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.POJO.ExcelData;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.POJO.ParticipacionesExcel;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.POJO.RequestBodyExcel;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Repositories.*;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.UtilsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UtilsServiceImpl implements UtilsService {

    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private PruebaRepository pruebaRepository;

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Autowired
    private ParticipaRepository participaRepository;

    @Autowired
    private InstitucionRepository institucionRepository;

    @Autowired
    private AtletaRepository atletaRepository;

    private List<SerieDTO> generateSeries(long idPrueba, int cantSeries, boolean finales) {
        // Obtener la prueba
        Prueba prueba = pruebaRepository.findById(idPrueba).orElse(null);

        // Obtener cantidad de inscriptos en la prueba y ordenarlos por institución
        List<Atleta> inscriptos = inscripcionRepository.findByPruebaId(idPrueba).stream()
                .map(Inscripcion::getAtleta)
                .sorted(Comparator.comparing(atleta -> atleta.getInstitucion().getId())) // Ordenar por institución
                .toList();

        // Crear las series en la base de datos
        List<Serie> series = new ArrayList<>();
        for (int i = 0; i < cantSeries; i++) {
            Serie serie;
            if (finales){
                serie = new Serie("Final " + (char) ('A' + i), InstanciaSerie.Final, prueba);
            }
            else{
                serie = new Serie("Serie " + (i + 1), InstanciaSerie.Serie, prueba);
            }
            series.add(serieRepository.save(serie)); // Almacenar la serie y obtener el ID
        }

        // Asignar atletas a las series minimizando la repetición de atletas de la misma institución
        List<Participa> participaciones = new ArrayList<>();
        for (int i = 0; i < inscriptos.size(); i++) {
            participaciones.add(new Participa(
                    new ParticipaId(inscriptos.get(i).getId(), series.get(i % cantSeries).getId()),
                    inscriptos.get(i),
                    series.get(i % cantSeries)
            ));
        }

        // Mezclar para que parezca más aleatorio
        Collections.shuffle(participaciones);

        // Almacenar las participaciones en la base de datos
        participaRepository.saveAll(participaciones);

        // Retornar SeriesDTO
        return series.stream().map(serie -> {
            SerieDTO serieDTO = new SerieDTO();
            serieDTO.setNombre(serie.getNombre());
            serieDTO.setInstancia(serie.getInstancia());
            serieDTO.setPruebaId(serie.getPrueba().getId());
            return serieDTO;
        }).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<SerieDTO> generateSeriesByAnd(long idPrueba) {
        Prueba prueba = pruebaRepository.findById(idPrueba).orElse(null);
        int cantAndariveles = prueba.getEtapa().getCantAndariveles();
        int cantInscriptos = inscripcionRepository.countByPruebaId(idPrueba);
        int cantSeries = (int) Math.ceil((double) cantInscriptos / cantAndariveles);
        return generateSeries(idPrueba, cantSeries, false);
    }

    @Override
    @Transactional
    public List<SerieDTO> generateSeriesByCantAtletas(long idPrueba, int cantidad) {
        int cantInscriptos = inscripcionRepository.countByPruebaId(idPrueba);
        int cantSeries = (int) Math.ceil((double) cantInscriptos / cantidad);
        return generateSeries(idPrueba, cantSeries, false);
    }

    @Override
    @Transactional
    public List<SerieDTO> generateSeriesByCantSeries(long idPrueba, int cantSeries) {
        return generateSeries(idPrueba, cantSeries, false);
    }

    @Override
    @Transactional
    public List<SerieDTO> generateSeriesByCantFinales(long idPrueba, int cantidad) {
        return generateSeries(idPrueba, cantidad, true);
    }

    @Override
    @Transactional
    public void uploadByExcel(long olimpiadaId, long etapaId, RequestBodyExcel requestBody) {
        try {
            // Validar datos de entrada
            if (requestBody == null || requestBody.getExcelData().isEmpty()) {
                throw new IllegalArgumentException("El JSON enviado no contiene datos o está vacío.");
            }

            // Crear institución
            Institucion institucion = new Institucion(requestBody.getInstitucion(), Regiones.valueOf(requestBody.getRegion()), 0);
            institucion = institucionRepository.save(institucion);

            // Obtener lista de pruebas de la etapa
            List<Prueba> pruebas = pruebaRepository.findPruebasByEtapaId(etapaId);
            if (pruebas.isEmpty()) {
                throw new IllegalArgumentException("No se encontraron pruebas para la etapa proporcionada.");
            }

            // Mapa para atletas
            Map<Long, Atleta> atletaMap = new HashMap<>();
            for (ExcelData excelData : requestBody.getExcelData()) {
                for (ParticipacionesExcel p : excelData.getAtletas()) {
                    // Validar existencia de prueba
                    Prueba pruebaEncontrada = pruebas.stream()
                            .filter(prueba -> prueba.getCategoria().equals(Categorias.valueOf(excelData.getCategoria())) &&
                                    prueba.getSexo().equals(Sexo.valueOf(excelData.getSexo())) &&
                                    prueba.getNombre().equals(NombrePrueba.getPrueba(p.getPrueba())))
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException("No se encontró la prueba para la categoría, sexo o nombre especificado."));

                    // Cargar atletas en un mapa donde su clave sea el DNI
                    if (!atletaMap.containsKey(p.getDni())) {
                        Atleta atleta = new Atleta(p.getNombre(), p.getApellido(), p.getDni(), Sexo.valueOf(excelData.getSexo()), p.getF_nacimiento(), institucion);
                        atleta = atletaRepository.save(atleta);
                        atletaMap.put(p.getDni(), atleta);
                    }

                    // Cargar inscripciones
                    Atleta a = atletaMap.get(p.getDni());
                    InscripcionId idIncripcion = new InscripcionId(a.getId(), pruebaEncontrada.getId());
                    Inscripcion inscripcion = new Inscripcion(idIncripcion, a, pruebaEncontrada);
                    inscripcionRepository.save(inscripcion);
                }
            }
        } catch (Exception e) {
            // Manejar excepciones específicas si es necesario o lanzar una excepción general
            throw new RuntimeException("Error al procesar el JSON del Excel: " + e.getMessage(), e);
        }
    }

}
