package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Controllers;


import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Atleta;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Participa;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Prueba;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Serie;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Enums.InstanciaSerie;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.InscripcionService;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.ParticipaService;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.PruebaService;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/utils")
public class UtilsController {

    @Autowired
    private SerieService serieService;

    @Autowired
    private PruebaService pruebaService;

    @Autowired
    private InscripcionService inscripcionService;

    @Autowired
    private ParticipaService participaService;

//    // Para las pruebas de pista con andarivel
//    @PostMapping(path = "/generateSeriesAuto/{idPrueba}")
//    public List<Serie> generateSeriesAuto(@PathVariable long idPrueba){
//        // Obtener cantAndariveles (Prueba.Etapa.cantAndariveles)
//        int cantAndariveles, cantInscriptos, cantSeries;
//        Atleta atleta = new Atleta();
//        Prueba prueba = pruebaService.getById(idPrueba);
//        cantAndariveles = prueba.getEtapa().getCantAndariveles();
//
//        // Contar cantidadInscritos en prueba
//        List<Atleta> inscriptos = inscripcionService.getAllByPrueba(idPrueba);
//        cantInscriptos = inscriptos.size();
//
//        // Techo de dividir cantidadInscritos en cantAndariveles
//        cantSeries = (int) Math.ceil(cantInscriptos / cantAndariveles);
//
//        // genero n series
//        ArrayList<Serie> series = new ArrayList<>();
//        for(int i=0; i<cantSeries; i++){
//            series.add(new Serie("Serie "+i, InstanciaSerie.Serie, prueba));
//        }
//
//        //CREAR LAS SERIES PARA OBTENER LOS IDs
//
//        /*
//        -Recorrer todos los inscriptos
//        -Recorrer por cada serie las inscripciones
//        -Decidir donde enviarlo
//        */
//        // genero m participaciones
//        ArrayList<Participa> participaciones = new ArrayList<>();
//        for(int i=0; i<cantInscriptos; i++){
//            atleta = inscriptos.get(i);
//            for(int j=0; j<cantSeries; j++){
//            }
//        }
//
//        return series;
//    }
//
//    // Despues
//    @GetMapping(path = "/generateSeriesMan/{id}/{cant}")
//    public long generateSeriesMan(){
//        return 0;
//    }

}
