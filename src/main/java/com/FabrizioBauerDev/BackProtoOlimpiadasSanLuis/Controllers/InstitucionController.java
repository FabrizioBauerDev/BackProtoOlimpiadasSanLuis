package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Controllers;


import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Institucion;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.InstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/institucion")
public class InstitucionController {

    @Autowired
    private InstitucionService institucionService;

    @GetMapping(path = "/getAll")
    public List<Institucion> getAllInstitucion(){return institucionService.getAll();}

    @GetMapping(path = "/getById/{id}")
    public Institucion getByInstitucion(@PathVariable long id){return institucionService.getById(id);}

    @GetMapping(path = "/count")
    public long countInstituciones(){
        return institucionService.countInstituciones();
    }

}
