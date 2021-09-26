package com.jgmonteiro.university.service;

import com.jgmonteiro.university.dto.MateriaDTO;
import com.jgmonteiro.university.entities.MateriaEntity;

import java.util.List;

public interface MateriaService {

    void update(final MateriaEntity materiaEntity);

    void delete(final Long id);

    void create(final MateriaDTO materiaDTO);

    List<MateriaEntity> getByHoraMinima(int horaMinima);
}
