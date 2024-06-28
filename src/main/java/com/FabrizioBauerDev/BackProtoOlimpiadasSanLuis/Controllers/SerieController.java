package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Controllers;


import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Prueba;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Serie;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.PruebaService;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/serie")
public class SerieController {

    @Autowired
    private SerieService serieService;

    @GetMapping(path = "/getAll")
    public List<Serie> getAllSerie(){return serieService.getAll();}

    @GetMapping(path = "/getById/{id}")
    public Serie getBySerieId(@PathVariable long id){return serieService.getById(id);}

    @GetMapping(path = "/count")
    public long countSeries(){
        return serieService.countSeries();
    }

}
