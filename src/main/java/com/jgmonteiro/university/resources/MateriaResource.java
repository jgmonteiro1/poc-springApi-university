package com.jgmonteiro.university.resources;

import com.jgmonteiro.university.entities.MateriaEntity;
import com.jgmonteiro.university.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/materias")
public class MateriaResource {

    @Autowired
    private MateriaRepository materiaRepository;

    @GetMapping
    public ResponseEntity<List<MateriaEntity>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(materiaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<MateriaEntity>> getById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(materiaRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity createMateria(@RequestBody MateriaEntity materiaEntity){
        materiaRepository.save(materiaEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(true);
    }

}
