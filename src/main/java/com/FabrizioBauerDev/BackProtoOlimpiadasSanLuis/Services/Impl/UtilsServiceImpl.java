package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.Impl;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.*;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.DTOs.SerieDTO;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Enums.InstanciaSerie;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Repositories.InscripcionRepository;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Repositories.ParticipaRepository;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Repositories.PruebaRepository;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Repositories.SerieRepository;
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

    private List<SerieDTO> generateSeries(long idPrueba, int cantSeries) {
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
            Serie serie = new Serie("Serie " + (i + 1), InstanciaSerie.Serie, prueba);
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
        return generateSeries(idPrueba, cantSeries);
    }

    @Override
    @Transactional
    public List<SerieDTO> generateSeriesByCantAtletas(long idPrueba, int cantidad) {
        int cantInscriptos = inscripcionRepository.countByPruebaId(idPrueba);
        int cantSeries = (int) Math.ceil((double) cantInscriptos / cantidad);
        return generateSeries(idPrueba, cantSeries);
    }

    @Override
    @Transactional
    public List<SerieDTO> generateSeriesByCantSeries(long idPrueba, int cantSeries) {
        return generateSeries(idPrueba, cantSeries);
    }
}
