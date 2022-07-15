package com.prueba.tecnica.models;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.prueba.tecnica.utils.Serializer;
import com.prueba.tecnica.utils.SerializerEquipos;
import lombok.AllArgsConstructor;
import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@Entity
@Table(name = "paises")
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String nombre;
    private String Siglas;

    @OneToMany(mappedBy = "paisCiclistas")
    @JsonSerialize(using = Serializer.class)
    private List<Ciclistas> ciclistas;


    @OneToMany(mappedBy = "paisEquipos")
    @JsonSerialize(using = SerializerEquipos.class)
    private List<Equipos> equipos;

    public Pais() {
    }

    public List<Equipos> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipos> equipos) {
        this.equipos = equipos;
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

    public String getSiglas() {
        return Siglas;
    }

    public void setSiglas(String siglas) {
        Siglas = siglas;
    }
}
