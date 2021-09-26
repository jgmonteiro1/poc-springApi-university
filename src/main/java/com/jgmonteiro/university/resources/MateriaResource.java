package com.jgmonteiro.university.resources;

import com.jgmonteiro.university.dto.MateriaDTO;
import com.jgmonteiro.university.entities.MateriaEntity;
import com.jgmonteiro.university.repository.MateriaRepository;
import com.jgmonteiro.university.service.MateriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/materias")
public class MateriaResource {


    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private MateriaServiceImpl materiaService;

    @GetMapping
    public ResponseEntity<List<MateriaEntity>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(materiaRepository.findAll());
    }

    @Cacheable(value = "materia", key = "#id")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<MateriaEntity>> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(materiaRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity createMateria(@Valid @RequestBody MateriaDTO materiaDTO) {
        materiaService.create(materiaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(true);
    }

    @CacheEvict(value = "materia", key = "#materia.id")
    @PutMapping
    public ResponseEntity updateMateria(@RequestBody MateriaEntity materiaEntity) {
        materiaService.update(materiaEntity);
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMateria(@PathVariable Long id) {
        materiaService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @GetMapping("/horaMinima/{horaMinima}")
    public ResponseEntity<List<MateriaEntity>> getMateriaByHoraMinima(@PathVariable("horaMinima") int horaMinima){
        final List<MateriaEntity> materiaEntityList = materiaService.getByHoraMinima(horaMinima);
        return ResponseEntity.status(HttpStatus.OK).body(materiaEntityList);
    }

}
