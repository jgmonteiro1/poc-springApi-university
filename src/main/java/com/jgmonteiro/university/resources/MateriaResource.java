package com.jgmonteiro.university.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/materias")
public class MateriaResource {

    @GetMapping("/")
    public ResponseEntity<String> getTest(){
        return ResponseEntity.status(HttpStatus.OK).body("Teste");
    }

}
