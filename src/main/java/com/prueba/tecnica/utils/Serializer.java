package com.prueba.tecnica.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.prueba.tecnica.models.Ciclistas;
import com.prueba.tecnica.models.Pais;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Serializer extends StdSerializer<List<Ciclistas>> {


    private static final long serialVersionUID = -709033919847200488L;

    public Serializer() {
        this(null);
    }
    public Serializer(Class<List<Ciclistas>> t) {
        super(t);
    }

    @Override
    public void serialize(List<Ciclistas> cicli, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        List<String> nombreCiclistas = new ArrayList<>();
        cicli.forEach(ciclistas -> nombreCiclistas.add(ciclistas.getNombre()));
        jsonGenerator.writeObject(nombreCiclistas);
    }
}
