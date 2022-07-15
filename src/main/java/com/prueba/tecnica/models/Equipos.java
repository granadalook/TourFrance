package com.prueba.tecnica.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.prueba.tecnica.utils.Serializer;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Entity
@Table(name = "equipos")
public class Equipos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String nombre;
    private String codigo;

    @ManyToOne()
    @JoinColumn(name = "Id_paisEquipos")
    private Pais paisEquipos;

    @OneToMany(mappedBy = "equipos")
    @JsonSerialize(using = Serializer.class)


    private List<Ciclistas> ciclistas;

    public Equipos() {
    }

    public Pais getPaisEquipos() {
        return paisEquipos;
    }

    public void setPaisEquipos(Pais paisEquipos) {
        this.paisEquipos = paisEquipos;
    }

    public List<Ciclistas> getCiclistas() {
        return ciclistas;
    }

    public void setCiclistas(List<Ciclistas> ciclistas) {
        this.ciclistas = ciclistas;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


}
