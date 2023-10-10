package com.facu.dummy.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Domicilio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Domicilio extends Base{
    @Column(name = "Calle")
    public String calle;
    @Column(name = "Numero")
    public int numero;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_localidad")
    private Localidad localidad;

}
