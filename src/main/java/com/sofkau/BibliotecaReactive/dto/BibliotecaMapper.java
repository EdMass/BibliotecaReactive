package com.sofkau.BibliotecaReactive.dto;

import com.sofkau.BibliotecaReactive.collections.Biblioteca;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

@Component
public class BibliotecaMapper {

    public Biblioteca fromDTO(BibliotecaDTO dto) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setId(dto.getId());
        biblioteca.setNombreLibro(dto.getTitulo());
        biblioteca.setGenero(dto.getClasificacion());
        biblioteca.setTipo(dto.getArea());
        biblioteca.setPrestado(dto.isPrestado());
        biblioteca.setFechaPrestamo(dto.getFechaPrestamo());
        return biblioteca;
    }

    public BibliotecaDTO fromCollection(Biblioteca collection) {
        BibliotecaDTO bibliotecaDTO = new BibliotecaDTO();
        bibliotecaDTO.setId(collection.getId());
        bibliotecaDTO.setTitulo(collection.getNombreLibro());
        bibliotecaDTO.setClasificacion(collection.getGenero());
        bibliotecaDTO.setArea(collection.getTipo());
        bibliotecaDTO.setPrestado(collection.isPrestado());
        bibliotecaDTO.setFechaPrestamo(collection.getFechaPrestamo());
        return bibliotecaDTO;
    }

    public List<BibliotecaDTO> fromCollectionList(List<Biblioteca> collection) {
        if (collection == null) {
            return null;
        }
        List<BibliotecaDTO> list = new ArrayList(collection.size());
        Iterator listTracks = collection.iterator();

        while(listTracks.hasNext()) {
            Biblioteca biblioteca = (Biblioteca) listTracks.next();
            list.add(fromCollection(biblioteca));
        }

        return list;
    }

    public Function<BibliotecaDTO, Biblioteca> mapperToDato(String id) {
        return updateDato -> {
            var recurso = new Biblioteca();
            recurso.setId(id);
            recurso.setNombreLibro(updateDato.getTitulo());
            recurso.setGenero(updateDato.getClasificacion());
            recurso.setTipo(updateDato.getArea());
            recurso.setPrestado(updateDato.isPrestado());
            recurso.setFechaPrestamo(updateDato.getFechaPrestamo());
            return recurso;
        };
    }

    public Function<Biblioteca, BibliotecaDTO> mapDatoToDTO() {
        return entity -> new BibliotecaDTO(entity.getId(), entity.getNombreLibro(), entity.getGenero(), entity.getTipo(), entity.isPrestado());
    }
}
