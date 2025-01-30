package org.prueba.modelo.Tipo;

import org.prueba.modelo.Animal;

public class Terrestre extends Animal {
    public Terrestre(String nombre, String onomatopeya) {
        super(nombre, onomatopeya);
    }

    @Override
    public String getTipo() {
        return "Terrestre";
    }
}