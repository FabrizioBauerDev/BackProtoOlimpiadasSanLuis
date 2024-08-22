package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.Impl;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.*;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.DTOs.ParticipacionDTO;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Repositories.AtletaRepository;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Repositories.ParticipaRepository;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Repositories.SerieRepository;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.ParticipaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParticipaServiceImpl implements ParticipaService {

    @Autowired
    private ParticipaRepository participaRepository;

    @Autowired
    private AtletaRepository atletaRepository;

    @Autowired
    private SerieRepository serieRepository;

    @Override
    public List<Participa> getAll() {
        return participaRepository.findAll();
    }

    @Override
    public Participa getById(ParticipaId id) {
        return participaRepository.findById(id).orElse(null);
    }

    @Override
    public List<ParticipacionDTO> getAllBySerie(long serieId) {
        List<Participa> participaciones = participaRepository.findBySerieId(serieId);

        return convertToParticipacionDTOList(participaciones);
    }

    @Override
    public List<ParticipacionDTO> getAllByPrueba(long pruebaId) {
        List<Participa> participaciones = participaRepository.findByPruebaId(pruebaId);

        return convertToParticipacionDTOList(participaciones);
    }

    @Override
    public List<Serie> getAllByAtleta(long atletaId) {
        List<Participa> participaciones = participaRepository.findByAtletaId(atletaId);
        return participaciones.stream()
                .map(Participa::getSerie)
                .collect(Collectors.toList());
    }

    @Override
    public Participa createParticipa(Participa participa) {
        return participaRepository.save(participa);
    }

    @Override
    public Participa updateParticipa(ParticipaId id, ParticipacionDTO participa) {
        Participa participacion = participaRepository.findById(id).orElse(null);
        if (participacion == null) {
            participacion.setCondicion(participa.getCondicion());
            participacion.setViento(participa.getViento());
            participacion.setMarca(participa.getMarca());
            participacion.setPuesto(participa.getPuesto());
            participacion.setAndarivel(participa.getAndarivel());
            return participaRepository.save(participacion);
        }
        return null;
    }

    @Override
    @Transactional
    public List<Participa> multipleUpdateParticipa(long serieId, List<ParticipacionDTO> participacionDTO){
        List<Participa> participaciones = new ArrayList<>();
        for(ParticipacionDTO dto : participacionDTO){
            Participa participacion = participaRepository.findById(dto.getId()).orElse(null);;
            if(participacion != null){
                participacion.setCondicion(dto.getCondicion());
                participacion.setViento(dto.getViento());
                participacion.setMarca(dto.getMarca());
                participacion.setPuesto(dto.getPuesto());
                participacion.setAndarivel((dto.getAndarivel()));
                participaciones.add(participacion);
                participaRepository.save(participacion);
            }
        }
        return participaciones;
    }

    @Override
    @Transactional
    public List<ParticipacionDTO> multipleCreateParticipaciones(long serieId, List<Long> atletasId) {
        List<Participa> participaciones = new ArrayList<>();
        Serie serie = serieRepository.findById(serieId).orElse(null);
        for(long atletaId : atletasId){
            Atleta atleta = atletaRepository.findById(atletaId).orElse(null);
            participaciones.add(participaRepository.save(new Participa(new ParticipaId(atletaId,serieId),atleta,serie)));
        }
        return convertToParticipacionDTOList(participaciones);
    }

    @Override
    @Transactional
    public boolean deleteParticipante(ParticipaId id) {
        try {
            participaRepository.deleteById(id);
            return true;
        }catch (EmptyResultDataAccessException e){
            return false;
        }
    }

    @Override
    public long countParticipantes() {
        return participaRepository.count();
    }

    private List<ParticipacionDTO> convertToParticipacionDTOList(List<Participa> participaciones) {
        return participaciones.stream().map(this::convertToParticipacionDTO).collect(Collectors.toList());
    }

    private ParticipacionDTO convertToParticipacionDTO(Participa participa) {
        ParticipacionDTO participacionDTO = new ParticipacionDTO();
        participacionDTO.setId(participa.getId());
        participacionDTO.setAtleta(participa.getAtleta());
        participacionDTO.setCondicion(participa.getCondicion());
        participacionDTO.setViento(participa.getViento());
        participacionDTO.setMarca(participa.getMarca());
        participacionDTO.setPuesto(participa.getPuesto());
        participacionDTO.setAndarivel(participa.getAndarivel());
        participacionDTO.setNombreSerie(participa.getSerie().getNombre());
        return participacionDTO;
    }


}
