package com.sofkau.BibliotecaReactive.usecase;

import com.sofkau.BibliotecaReactive.repositories.RepositorioBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class UseCaseBorrarUnLibro implements BorarLibro {
    private final RepositorioBiblioteca repositorio;
    @Autowired
    public UseCaseBorrarUnLibro(RepositorioBiblioteca repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Mono get(String id) {
        if (Objects.isNull(id)) {
            return Mono.empty();
        }
        return repositorio.deleteById(id);
    }
}
