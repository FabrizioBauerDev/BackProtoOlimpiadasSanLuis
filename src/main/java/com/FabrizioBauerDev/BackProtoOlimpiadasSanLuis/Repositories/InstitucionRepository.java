package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Repositories;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Institucion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitucionRepository extends JpaRepository<Institucion, Long> {

}
