package com.jgmonteiro.university.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jgmonteiro.university.dto.MateriaDTO;
import com.jgmonteiro.university.entities.MateriaEntity;
import com.jgmonteiro.university.exceptions.MateriaException;
import com.jgmonteiro.university.repository.MateriaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaServiceImpl implements MateriaService {

    Logger LOG = LoggerFactory.getLogger(MateriaServiceImpl.class);


    @Autowired
    private MateriaRepository materiaRepository;


    @Override
    public void update(MateriaEntity materiaUpdate) {

        try {
            MateriaEntity materiaEntityAtualizada = materiaRepository.findById(materiaUpdate.getId()).get();
            materiaEntityAtualizada.setName(materiaUpdate.getName());
            materiaEntityAtualizada.setCodigo(materiaUpdate.getCodigo());
            materiaEntityAtualizada.setHoras(materiaUpdate.getHoras());
            materiaEntityAtualizada.setFrequencia(materiaUpdate.getFrequencia());
            materiaRepository.save(materiaEntityAtualizada);
        } catch (Exception e) {
            throw  new MateriaException("Erro ao atualizar", HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public void delete(Long id) {
        try {
            materiaRepository.deleteById(id);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void create(MateriaDTO materiaDTO) {
        ObjectMapper mapper = new ObjectMapper();
        MateriaEntity materiaEntity = mapper.convertValue(materiaDTO, MateriaEntity.class);
        materiaRepository.save(materiaEntity);
    }

    @Override
    public List<MateriaEntity> getByHoraMinima(int horaMinima) {
        List<MateriaEntity> materiaEntityList = materiaRepository.findByHoraMinima(horaMinima);
        return materiaEntityList;
    }
}
