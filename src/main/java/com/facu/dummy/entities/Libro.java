package com.facu.dummy.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Libro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Libro extends Base{
    @Column(name = "Titulo")
    public String titulo;
    @Column(name = "Genero")
    public String genero;
    @Column(name = "Paginas")
    public int paginas;
    @Column(name = "Fecha")
    public int fecha;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Builder.Default
    private List<Autor> autores = new ArrayList<Autor>();
    public void AddAutores(Autor autor3) {
        autores.add(autor3);
    }
}
