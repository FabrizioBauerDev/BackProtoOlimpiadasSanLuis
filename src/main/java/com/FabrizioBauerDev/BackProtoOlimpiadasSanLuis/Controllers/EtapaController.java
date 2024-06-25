package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Controllers;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Etapa;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.EtapaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/etapa")
public class EtapaController {

    @Autowired
    private EtapaService etapaService;

    @GetMapping(path = "/getAll")
    public List<Etapa> getAllEtapa(){return etapaService.getAll();}

    @GetMapping(path = "/getById/{id}")
    public Etapa getByIdEtapa(@PathVariable int id){return etapaService.getById(id);}

    @GetMapping(path = "/count")
    public long countEtapas(){
        return etapaService.countEtapa();
    }

}
