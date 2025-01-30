package org.prueba.modelo.Tipo;

import org.prueba.modelo.Animal;
import org.prueba.modelo.TipoAnimal;

public class Volador extends Animal {
    public Volador(String nombre, String onomatopeya) {
        super(nombre, onomatopeya);
    }

    @Override
    public String getTipo() {
        return TipoAnimal.VOLADOR.name();
    }
}