package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.Impl;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Institucion;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Repositories.InstitucionRepository;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.InstitucionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitucionServiceImp implements InstitucionService {

    @Autowired
    private InstitucionRepository institucionRepository;

    @Override
    public List<Institucion> getAll(){
        return institucionRepository.findAll();
    }

    @Override
    public Institucion getById(long id){
        return  institucionRepository.findById(id).orElse(null);
    }

    @Override
    public Institucion createInstitucion(Institucion institucion){
        return  institucionRepository.save(institucion);
    }

    @Override
    public Institucion  updateInstitucion(long id, Institucion institucion){
        Institucion institucion1 = institucionRepository.findById(id).orElse(null);
        if(institucion1 != null){
            //Setear las cosas
            return institucionRepository.save(institucion1);
        }
        return null;
    }

    @Override
    @Transactional
    public boolean deleteInstitucion(long id){
        try {
            institucionRepository.deleteById(id);
            return true;
        }catch (EmptyResultDataAccessException e){
            return false;
        }
    }

    @Override
    public long countInstituciones(){
        return institucionRepository.count();
    }
}
