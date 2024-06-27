package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Controllers;


import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.*;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.ParticipaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/participa")
public class ParticipaController {

    @Autowired
    ParticipaService participaService;

    @GetMapping(path = "/getAll")
    public List<Participa> getAllParticipa(){return participaService.getAll();}

    @GetMapping(path = "/getById/{serieId}/{atletaId}")
    public Participa getByInscripcion(@PathVariable long serieId, @PathVariable long atletaId){
        ParticipaId id = new ParticipaId(atletaId,serieId);
        return participaService.getById(id);
    }

    @GetMapping(path = "/getByIdPrueba/{serieId}")
    public List<Atleta> getBySerieId(@PathVariable long serieId){
        return participaService.getAllBySerie(serieId);
    }
    @GetMapping(path = "/getByIdAtleta/{atletaId}")
    public List<Serie> getByAtletaId(@PathVariable long atletaId){
        return participaService.getAllByAtleta(atletaId);
    }

    @GetMapping(path = "/count")
    public long countParticipaciones(){
        return participaService.countParticipantes();
    }

}
