package com.jgmonteiro.university.resources;

import com.jgmonteiro.university.entities.MateriaEntity;
import com.jgmonteiro.university.repository.MateriaRepository;
import com.jgmonteiro.university.service.MateriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<Optional<MateriaEntity>> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(materiaRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity createMateria(@RequestBody MateriaEntity materiaEntity) {
        materiaService.create(materiaEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(true);
    }

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

}
