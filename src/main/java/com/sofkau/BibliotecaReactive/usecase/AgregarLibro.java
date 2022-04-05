package com.sofkau.BibliotecaReactive.usecase;

import com.sofkau.BibliotecaReactive.dto.BibliotecaDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface AgregarLibro {
    public Mono<BibliotecaDTO> apply(BibliotecaDTO bibliotecaDTO);
}

