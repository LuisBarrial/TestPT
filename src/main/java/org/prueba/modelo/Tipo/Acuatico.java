package org.prueba.modelo.Tipo;

import org.prueba.modelo.Animal;
import org.prueba.modelo.TipoAnimal;

public class Acuatico extends Animal {
    public Acuatico(String nombre, String onomatopeya) {
        super(nombre, onomatopeya);
    }

    @Override
    public String getTipo() {
        return TipoAnimal.ACUATICO.name();
    }
}