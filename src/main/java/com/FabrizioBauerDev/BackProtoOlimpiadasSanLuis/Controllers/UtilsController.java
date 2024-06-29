package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Controllers;



import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Serie;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/utils")
public class UtilsController {

    @Autowired
    private UtilsService utilsService;

    @PostMapping(path = "/generateSeriesByAnd")
    public ResponseEntity<List<Serie>> generateSeriesByAnd(@RequestParam long idPrueba) {
        List<Serie> series = utilsService.generateSeriesByAnd(idPrueba);
        return new ResponseEntity<>(series, HttpStatus.CREATED);
    }

}
