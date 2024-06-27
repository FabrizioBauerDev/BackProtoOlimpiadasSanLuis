package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Controllers;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Atleta;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Inscripcion;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.InscripcionId;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Prueba;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @GetMapping(path = "/getAll")
    public List<Inscripcion> getAllInscripcion(){return inscripcionService.getAll();}

    @GetMapping(path = "/getById/{pruebaId}/{atletaId}")
    public Inscripcion getByInscripcion(@PathVariable long pruebaId,@PathVariable long atletaId){
        InscripcionId id = new InscripcionId(atletaId,pruebaId);
        return inscripcionService.getById(id);
    }

    @GetMapping(path = "/getByIdPrueba/{pruebaId}")
    public List<Atleta> getByPruebaId(@PathVariable long pruebaId){
        return inscripcionService.getAllByPrueba(pruebaId);
    }
    @GetMapping(path = "/getByIdAtleta/{atletaId}")
    public List<Prueba> getByInscripcion(@PathVariable long atletaId){
        return inscripcionService.getAllByAtleta(atletaId);
    }

    @GetMapping(path = "/count")
    public long countInscripciones(){
        return inscripcionService.countInscripciones();
    }
}
