package com.sofkau.BibliotecaReactive.usecase;

import com.sofkau.BibliotecaReactive.dto.BibliotecaDTO;
import com.sofkau.BibliotecaReactive.dto.BibliotecaMapper;
import com.sofkau.BibliotecaReactive.repositories.RepositorioBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@Validated
public class UseCaseObtenerTodos implements Supplier<Flux<BibliotecaDTO>> {
    private final RepositorioBiblioteca repositorio;
    private final BibliotecaMapper mapper;
    @Autowired
    public UseCaseObtenerTodos(BibliotecaMapper mapper, RepositorioBiblioteca repositorio) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    @Override
    public Flux<BibliotecaDTO> get() {
        return repositorio.findAll().map(mapper.mapDatoToDTO());
    }
}
