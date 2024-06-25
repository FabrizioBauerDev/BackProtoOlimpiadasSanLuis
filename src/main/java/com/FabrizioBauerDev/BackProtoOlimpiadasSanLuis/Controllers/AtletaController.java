package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Controllers;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Atleta;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.AtletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/atleta")
public class AtletaController {

    @Autowired
    private AtletaService atletaService;

    @GetMapping(path = "/getAll")
    public List<Atleta> getAllAtleta(){return atletaService.getAll();}

    @GetMapping(path = "/getById/{id}")
    public Atleta getByAtleta(@PathVariable int id){return atletaService.getById(id);}

    @GetMapping(path = "/count")
    public long countAtletas(){
        return atletaService.countAtletas();
    }

}
