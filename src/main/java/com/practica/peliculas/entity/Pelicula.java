package com.practica.peliculas.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pelicula")
@Data
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String director;

    private Integer anioLanzamiento;

    private String genero;

    @Column(length = 500)
    private String sinopsis;
}