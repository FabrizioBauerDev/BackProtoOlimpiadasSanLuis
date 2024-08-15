package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Controllers;


import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Participa;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.ParticipaId;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Prueba;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Serie;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.PruebaService;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/serie")
public class SerieController {

    @Autowired
    private SerieService serieService;

    @GetMapping(path = "/getAll")
    public List<Serie> getAllSerie(){return serieService.getAll();}

    @GetMapping(path = "/getById/{id}")
    public Serie getBySerieId(@PathVariable long id){return serieService.getById(id);}

    @GetMapping(path = "/count")
    public long countSeries(){
        return serieService.countSeries();
    }

    @GetMapping("/getAllByPruebaId/{id}")
    public List<Serie> getSeriesByPruebaId(@PathVariable Long id) {
        return serieService.getSeriesByPruebaId(id);
    }

    @PutMapping(path = "/{serieId}")
    public ResponseEntity<Serie> updateSerie(@PathVariable long serieId, @RequestBody Serie serieUpdate){
        try {
            Serie serie = serieService.updateSerie(serieId, serieUpdate);
            if(serie != null){
                return ResponseEntity.ok(serie);
            }else{
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
