package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Controllers;



import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Serie;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.DTOs.SerieDTO;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(path = "/api/utils")
public class UtilsController {

    @Autowired
    private UtilsService utilsService;

    @PostMapping(path = "/generateSeriesByAnd")
    public ResponseEntity<List<SerieDTO>> generateSeriesByAnd(@RequestParam long idPrueba) {
        List<SerieDTO> series = utilsService.generateSeriesByAnd(idPrueba);
        return new ResponseEntity<>(series, HttpStatus.CREATED);
    }

    @PostMapping(path = "/generateSeriesByCantAtletas")
    public ResponseEntity<List<SerieDTO>> generateSeriesByCantAtletas(
            @RequestParam long idPrueba,
            @RequestBody Map<String, Integer> requestBody) {
        // Extraer la cantidad del cuerpo de la solicitud
        int cantidad = requestBody.get("cant");
        // Llamar al servicio con idPrueba y cantidad
        List<SerieDTO> series = utilsService.generateSeriesByCantAtletas(idPrueba, cantidad);
        // Retornar la respuesta
        return new ResponseEntity<>(series, HttpStatus.CREATED);
    }

    @PostMapping(path = "/generateSeriesByCantSeries")
    public ResponseEntity<List<SerieDTO>> generateSeriesByCantSeries(
            @RequestParam long idPrueba,
            @RequestBody Map<String, Integer> requestBody) {
        // Extraer la cantidad del cuerpo de la solicitud
        int cantidad = requestBody.get("cant");
        // Llamar al servicio con idPrueba y cantidad
        List<SerieDTO> series = utilsService.generateSeriesByCantSeries(idPrueba, cantidad);
        // Retornar la respuesta
        return new ResponseEntity<>(series, HttpStatus.CREATED);
    }

}
