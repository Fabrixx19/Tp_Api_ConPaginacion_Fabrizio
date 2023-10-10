package com.facu.dummy.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Persona")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Persona extends Base {

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "DNI")
    private int dni;

     @OneToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "fk_domicilio")
     private Domicilio domicilio;

     @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
     @Builder.Default
     @JoinTable(
             name = "persona_libro",
             joinColumns = @JoinColumn(name = "persona_id"),
             inverseJoinColumns = @JoinColumn(name = "libro_id")

     )
     private List<Libro> libros = new ArrayList<Libro>();

    public void AddLibros(Libro libro) {
        libros.add(libro);
    }
}
