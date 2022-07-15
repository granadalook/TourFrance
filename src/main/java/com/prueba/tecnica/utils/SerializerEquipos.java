package com.prueba.tecnica.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.prueba.tecnica.models.Equipos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SerializerEquipos extends StdSerializer<List<Equipos>> {
    private static final long serialVersionUID = -709033919847200488L;

    public SerializerEquipos () {
        this(null);
    }
    public SerializerEquipos (Class<List<Equipos>> t) {
        super(t);
    }

    @Override
    public void serialize(List<Equipos> equi, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        List<String> nombreEquipos = new ArrayList<>();
        equi.forEach(equipos -> nombreEquipos.add(equipos.getNombre()));
        jsonGenerator.writeObject(nombreEquipos);
    }
}
