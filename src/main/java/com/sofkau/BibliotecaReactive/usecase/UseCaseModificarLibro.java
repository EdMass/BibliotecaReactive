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
public class UseCaseModificarLibro implements AgregarLibro {
    private final RepositorioBiblioteca repositorio;
    private final BibliotecaMapper mapper;
    @Autowired
    public UseCaseModificarLibro(BibliotecaMapper mapper, RepositorioBiblioteca repositorio) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    @Override
    public Mono<BibliotecaDTO> apply(BibliotecaDTO bibliotecaDTO) {
        String id = bibliotecaDTO.getId();
        if (id == null){
            new RuntimeException("El id es requerido");
        }
        return repositorio.save(mapper.mapperToDato(bibliotecaDTO.getId()).apply(bibliotecaDTO)).map(mapper.mapDatoToDTO());
    }
}
