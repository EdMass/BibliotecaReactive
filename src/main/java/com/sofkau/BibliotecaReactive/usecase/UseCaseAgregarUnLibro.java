package com.sofkau.BibliotecaReactive.usecase;

import com.sofkau.BibliotecaReactive.dto.BibliotecaDTO;
import com.sofkau.BibliotecaReactive.dto.BibliotecaMapper;
import com.sofkau.BibliotecaReactive.repositories.RepositorioBiblioteca;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseAgregarUnLibro implements AgregarLibro {
    private final RepositorioBiblioteca repositorio;
    private final BibliotecaMapper mapper;
    //    @Autowired
    public UseCaseAgregarUnLibro(BibliotecaMapper mapper, RepositorioBiblioteca repositorio) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    @Override
    public Mono<BibliotecaDTO> apply(BibliotecaDTO bibliotecaDTO) {
        return repositorio.save(mapper.mapperToDato(bibliotecaDTO.getId()).apply(bibliotecaDTO)).map(mapper.mapDatoToDTO());
    }
}
