package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Controllers;


import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Prueba;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.PruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/prueba")
public class PruebaController {

    @Autowired
    private PruebaService pruebaService;

    @GetMapping(path = "/getAll")
    public List<Prueba> getALLPruebas(){
        return pruebaService.getAll();
    }

    @GetMapping(path = "/getById/{id}")
    public Prueba getPruebaById(@PathVariable int id){
        return pruebaService.getById(id);
    }

    @GetMapping(path = "/count")
    public long countPruebas(){
        return pruebaService.countPruebas();
    }

}
