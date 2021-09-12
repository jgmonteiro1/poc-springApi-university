package com.jgmonteiro.university.service;

import com.jgmonteiro.university.entities.MateriaEntity;
import com.jgmonteiro.university.repository.MateriaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
            e.getMessage();
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
    public void create(MateriaEntity materiaEntity) {
        materiaRepository.save(materiaEntity);
    }
}
