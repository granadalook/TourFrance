package com.prueba.tecnica.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Entity
@Table(name = "ciclistas")
public class Ciclistas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(unique = true, nullable = false)
    private Long id;
    private String nombre;

    private String numero;


   // @JsonBackReference
    @ManyToOne(
//            targetEntity = Pais.class,
//            fetch = FetchType.LAZY,
//            optional = false
    )
    @JoinColumn(name = "Id_paisCiclistas")
    private Pais paisCiclistas;
     //@JsonBackReference
    @ManyToOne(
//            targetEntity = Pais.class,
//            fetch = FetchType.LAZY,
//            optional = false
    )
    @JoinColumn(name = "Id_equipo")
    private Equipos equipos;
    public Ciclistas() {
    }

    public Pais getPaisCiclistas() {
        return paisCiclistas;
    }

    public void setPaisCiclistas(Pais paisCiclistas) {
        this.paisCiclistas = paisCiclistas;
    }

    public Equipos getEquipos() {
        return equipos;
    }

    public void setEquipos(Equipos equipos) {
        this.equipos = equipos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }


}
