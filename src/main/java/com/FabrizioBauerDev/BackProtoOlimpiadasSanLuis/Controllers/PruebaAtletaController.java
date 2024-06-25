package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Controllers;


import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.PruebaAtleta;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.PruebaAtletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/pruebaAtleta")
public class PruebaAtletaController {

    @Autowired
    private PruebaAtletaService pruebaAtletaService;

    @GetMapping(path = "/getAll")
    public List<PruebaAtleta> getAllPruebaAtleta(){return pruebaAtletaService.getAll();}

    @GetMapping(path = "/getById/{id}")
    public PruebaAtleta getByIdPruebaAtleta(@PathVariable int id){return pruebaAtletaService.getById(id);}

    @GetMapping(path = "/count")
    public long countPruebaAtletas(){
        return pruebaAtletaService.countPruebaAtleta();
    }

}
