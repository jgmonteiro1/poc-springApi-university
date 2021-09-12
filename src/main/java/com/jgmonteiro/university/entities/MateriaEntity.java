package com.jgmonteiro.university.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "tb_materia")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MateriaEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @JsonInclude(Include.NON_NULL)
    @Column(name = "id")
    private Long id;

    @JsonInclude(Include.NON_EMPTY)
    @Column(name = "nome")
    private String name;

    @Column(name = "hrs")
    private Integer horas;

    @JsonInclude(Include.NON_EMPTY)
    @Column(name = "cod")
    private String codigo;

    @JsonInclude(Include.NON_EMPTY)
    @Column(name = "freq")
    private Integer frequencia;



}
