package com.sofkau.BibliotecaReactive.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class Biblioteca {
    @Id
    private String id;
    private String nombreLibro;
    private String genero;
    private String tipo;
    private boolean prestado = false;
    private LocalDate fechaPrestamo = null;

    public Biblioteca() {
    }

    public Biblioteca(String id, String nombreLibro, String genero, String tipo, boolean prestado) {
        this.id = id;
        this.nombreLibro = nombreLibro;
        this.genero = genero;
        this.tipo = tipo;
        this.prestado = prestado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
}
