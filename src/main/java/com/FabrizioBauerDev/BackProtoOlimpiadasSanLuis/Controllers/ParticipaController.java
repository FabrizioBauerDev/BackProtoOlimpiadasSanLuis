package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Controllers;


import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.*;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.DTOs.ParticipacionDTO;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.ParticipaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/getByIdSerie/{serieId}")
    public List<ParticipacionDTO> getBySerieId(@PathVariable long serieId){
        return participaService.getAllBySerie(serieId);
    }

    @GetMapping(path = "/getByIdPrueba/{pruebaId}")
    public List<ParticipacionDTO> getByPruebaId(@PathVariable long pruebaId){
        return participaService.getAllByPrueba(pruebaId);
    }

    @GetMapping(path = "/getByIdAtleta/{atletaId}")
    public List<Serie> getByAtletaId(@PathVariable long atletaId){
        return participaService.getAllByAtleta(atletaId);
    }

    @GetMapping(path = "/count")
    public long countParticipaciones(){
        return participaService.countParticipantes();
    }

    @PutMapping(path = "/{serieId}/{atletaId}")
    public ResponseEntity<Participa> updateParticipa(@PathVariable long serieId,@PathVariable long atletaId, @RequestBody ParticipacionDTO participaUpdate){
        try {
            ParticipaId id = new ParticipaId(atletaId,serieId);
            //Funcion dde conversion
            Participa participa = participaService.updateParticipa(id,participaUpdate);
            if(participa != null){
                return ResponseEntity.ok(participa);
            }else{
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping(path = "/{serieId}")
    public ResponseEntity<?> multipleUpdateParticipa(@PathVariable long serieId, @RequestBody List<ParticipacionDTO> participaUpdate) {
        try {
            // Intentar actualizar las participaciones
            List<Participa> participaciones = participaService.multipleUpdateParticipa(serieId, participaUpdate);
            // Devolver la lista de participaciones actualizadas
            return ResponseEntity.ok(participaciones);
        } catch (Exception e) {
            // Manejo de cualquier otro error no esperado
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error inesperado: " + e.getMessage());
        }
    }

}
