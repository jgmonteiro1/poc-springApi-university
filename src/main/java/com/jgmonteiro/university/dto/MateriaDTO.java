package com.jgmonteiro.university.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class MateriaDTO {

    private Long id;

    @NotBlank(message = "Nome inválido, o nome não pode ser vazio")
    private String name;

    @Min(value = 34, message = "Carga horária inválida, o valor da carga horária deve ser pelo menos 34 horas")
    @Max(value = 120, message = "Carga horária inválida, o valor da carga horária deve ser no máximo 120 horas")
    private Integer horas;

    @NotBlank(message = "Código inválido, o código não pode ser vazio")
    private String codigo;

    @Max(value = 3, message = "Frequência inválida, o limite máximo é de 3x ao ano")
    private Integer frequencia;
}
