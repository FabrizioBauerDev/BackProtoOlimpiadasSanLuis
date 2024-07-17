package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Controllers;


import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Etapa;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Olimpiada;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.DTOs.OlimpiadaEtapa;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.EtapaService;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.OlimpiadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/olimpiada")
public class OlimpiadaController {

    @Autowired
    private OlimpiadaService olimpiadaService;

    @Autowired
    private EtapaService etapaService;

    @GetMapping(path = "/getAll")
    public List<Olimpiada> getAllOlimpiadas(){
        return olimpiadaService.getAll();
    }

    @GetMapping(path = "/getById/{id}")
    public Olimpiada getByIdOlimpiada(@PathVariable long id){return olimpiadaService.getById(id);}
    
    @GetMapping(path = "/count")
    public long countOlimpiadas(){
        return olimpiadaService.countOlimpiadas();
    }

    @GetMapping(path = "/getEtapaByIdOlimpiada/{id}")
    public OlimpiadaEtapa getEtapaByIdOlimpiada(@PathVariable long id){
        OlimpiadaEtapa oe = new OlimpiadaEtapa();
        oe.setOlimpiada(olimpiadaService.getById(id));
        oe.setEtapas(etapaService.getAllEtapasIdOlimpiada(id));
        return oe;
    }
}

