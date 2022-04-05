package com.sofkau.BibliotecaReactive.usecase;

import com.sofkau.BibliotecaReactive.dto.BibliotecaDTO;
import com.sofkau.BibliotecaReactive.dto.BibliotecaMapper;
import com.sofkau.BibliotecaReactive.repositories.RepositorioBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseObtenerPorId implements ObtenerPorId {

    private final RepositorioBiblioteca repositorio;
    private final BibliotecaMapper mapper;
    @Autowired
    public UseCaseObtenerPorId(BibliotecaMapper mapper, RepositorioBiblioteca repositorio) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    @Override
    public Mono<BibliotecaDTO> get(String id) {
        return repositorio.findById(id).map(mapper.mapDatoToDTO());
    }
}
