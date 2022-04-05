package com.sofkau.BibliotecaReactive.usecase;

import com.sofkau.BibliotecaReactive.collections.Biblioteca;
import com.sofkau.BibliotecaReactive.repositories.RepositorioBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@Validated
public class UseCasePrestarLibro implements DisponibilidadLibro {
    private final RepositorioBiblioteca repositorio;
    @Autowired
    public UseCasePrestarLibro(RepositorioBiblioteca repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Mono<String> apply(String id) {
        Mono<Biblioteca> recursoMono = repositorio.findById(id);
        return recursoMono.flatMap(recurso -> {
            if (!recurso.isPrestado()) {
                recurso.setFechaPrestamo(LocalDate.now());
                recurso.setPrestado(true);
                return repositorio.save(recurso)
                        .thenReturn("Ha sido prestado");
            }
            return Mono.just("No disponible");
        });
    }
}
