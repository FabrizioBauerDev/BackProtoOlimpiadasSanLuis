package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.Impl;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.*;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Enums.InstanciaSerie;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Repositories.InscripcionRepository;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Repositories.ParticipaRepository;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Repositories.PruebaRepository;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Repositories.SerieRepository;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.*;
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

    @Override
    @Transactional
    public List<Serie> generateSeriesByAnd(long idPrueba) {
        // Obtener cantidad de andariveles
        Prueba prueba = pruebaRepository.findById(idPrueba).orElse(null);
        int cantAndariveles = prueba.getEtapa().getCantAndariveles();

        // Obtener cantidad de inscriptos en la prueba y ordenarlos por institución
        List<Atleta> inscriptos = inscripcionRepository.findByPruebaId(idPrueba).stream()
                .map(Inscripcion::getAtleta)
                .sorted(Comparator.comparing(atleta -> atleta.getInstitucion().getId())) // Ordenar por institución
                .toList();

        // List<Atleta> inscriptos = inscripcionRepository.findAtletasByPruebaIdOrderedByInstitucion(idPrueba); // Veremos si funca
        int cantInscriptos = inscriptos.size();


        // Calcular la cantidad de series necesarias
        int cantSeries = (int) Math.ceil((double) cantInscriptos / cantAndariveles);

        // Crear las series en la base de datos
        List<Serie> series = new ArrayList<>();

        int i;
        for (i = 0; i < cantSeries; i++) {
            Serie serie = new Serie("Serie " + (i + 1), InstanciaSerie.Serie, prueba);
            series.add(serieRepository.save(serie)); // Almacenar la serie y obtener el ID
        }
        System.out.println(series);
        // Asignar atletas a las series minimizando la repetición de atletas de la misma institución
        List<Participa> participaciones = new ArrayList<>();

        i=0;
        for (Atleta atleta : inscriptos) {
            participaciones.add(new Participa(new ParticipaId(atleta.getId(),series.get( i % cantSeries).getId()),atleta,series.get( i % cantSeries)));
            i++;
        }
        System.out.println(participaciones);
        // Mezclar para que parezca mas aleatorio
        Collections.shuffle(participaciones);
        System.out.println(participaciones);
        // Almacenar las participaciones en la base de datos
        participaRepository.saveAll(participaciones);

        return series;
    }


    @Override
    public List<Serie> generateSeriesByAtleta(long idPrueba, int cantAtletas) {
        return List.of();
    }

    @Override
    public List<Serie> generateSeriesByDivision(long idPrueba, int cantDivision) {
        return List.of();
    }
}
