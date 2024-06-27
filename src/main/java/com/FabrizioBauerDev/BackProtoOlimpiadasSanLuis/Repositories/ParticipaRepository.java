package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Repositories;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Participa;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.ParticipaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ParticipaRepository extends JpaRepository<Participa, ParticipaId> {
    @Query("SELECT i FROM Participa i WHERE i.serie.id = :serieId")
    List<Participa> findBySerieId(@Param("serieId") Long serieId);

    @Query("SELECT i FROM Participa i WHERE i.atleta.id = :atletaId")
    List<Participa> findByAtletaId(@Param("atletaId") Long atletaId);
}
