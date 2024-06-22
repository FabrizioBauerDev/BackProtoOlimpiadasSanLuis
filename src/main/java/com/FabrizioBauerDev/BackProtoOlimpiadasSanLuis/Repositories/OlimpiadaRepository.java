package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Repositories;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Olimpiada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OlimpiadaRepository extends JpaRepository<Olimpiada,Integer> {
}
