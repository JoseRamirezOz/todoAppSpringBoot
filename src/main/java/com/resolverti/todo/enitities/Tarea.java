package com.resolverti.todo.enitities;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TAREA")
public @Data class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    @Column(name = "ID")
    private int id;

    @JsonProperty
    @Column(name = "TITULO")
    private String titulo;

    @JsonProperty
    @Column(name = "DESCRIPCION")
    private String descripcion;

    @JsonProperty
    @Column(name = "COMPLETADO")
    private boolean completado;
}
