package com.jgmonteiro.university.service;

import com.jgmonteiro.university.entities.MateriaEntity;

public interface MateriaService {

    public void update(final MateriaEntity materiaEntity);

    public void delete(final Long id);

    public void create(final MateriaEntity materiaEntity);
}
