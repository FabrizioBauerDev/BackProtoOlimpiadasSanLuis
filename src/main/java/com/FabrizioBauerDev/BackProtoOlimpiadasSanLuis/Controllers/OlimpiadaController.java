package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Controllers;


import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Olimpiada;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.OlimpiadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/olimpiada")
public class OlimpiadaController {
    @Autowired
    private OlimpiadaService olimpiadaService;

    @GetMapping
    public List<Olimpiada> listarOlimpiadas(){
        return olimpiadaService.getAll();
    }
}

