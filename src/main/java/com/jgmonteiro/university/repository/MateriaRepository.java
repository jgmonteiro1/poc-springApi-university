package com.jgmonteiro.university.repository;

import com.jgmonteiro.university.entities.MateriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepository extends JpaRepository<MateriaEntity, Long> {
}
