package org.prueba.modelo.Tipo;

import org.prueba.modelo.Animal;
import org.prueba.modelo.TipoAnimal;

public class Terrestre extends Animal {
    public Terrestre(String nombre, String onomatopeya) {
        super(nombre, onomatopeya);
    }

    @Override
    public String getTipo() {
        return TipoAnimal.TERRESTRE.name();
    }
}