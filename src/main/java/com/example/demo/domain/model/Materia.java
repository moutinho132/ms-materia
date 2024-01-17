package com.example.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class Materia {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Boolean status;
}
