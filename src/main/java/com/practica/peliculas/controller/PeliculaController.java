package com.practica.peliculas.controller;

import com.practica.peliculas.entity.Pelicula;
import com.practica.peliculas.service.PeliculaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    private final PeliculaService service;

    public PeliculaController(PeliculaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pelicula> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Pelicula buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PostMapping
    public Pelicula guardar(
            @RequestBody Pelicula pelicula) {
        return service.guardar(pelicula);
    }

    @PutMapping("/{id}")
    public Pelicula actualizar(
            @PathVariable Long id,
            @RequestBody Pelicula pelicula) {

        pelicula.setId(id);
        return service.guardar(pelicula);
    }

    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable Long id) {
        service.eliminar(id);
    }
}