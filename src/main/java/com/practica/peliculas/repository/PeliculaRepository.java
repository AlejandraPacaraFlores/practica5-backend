package com.practica.peliculas.repository;

import com.practica.peliculas.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository
        extends JpaRepository<Pelicula, Long> {
}