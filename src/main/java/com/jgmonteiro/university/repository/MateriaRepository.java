package com.jgmonteiro.university.repository;

import com.jgmonteiro.university.entities.MateriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MateriaRepository extends JpaRepository<MateriaEntity, Long> {

    @Query("select m from MateriaEntity m where m.horas >= :horaMinima")
    public List<MateriaEntity> findByHoraMinima(@Param("horaMinima")int horaMinima);
}
