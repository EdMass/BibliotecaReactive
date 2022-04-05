package com.sofkau.BibliotecaReactive.repositories;

import com.sofkau.BibliotecaReactive.collections.Biblioteca;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioBiblioteca extends ReactiveMongoRepository<Biblioteca, String> {
}

