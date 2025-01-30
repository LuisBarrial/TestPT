package org.prueba.modelo.factory;

import org.prueba.modelo.Animal;
import org.prueba.modelo.Tipo.Acuatico;
import org.prueba.modelo.Tipo.Terrestre;
import org.prueba.modelo.Tipo.Volador;

public class AnimalFactory {
    public static Animal crearAnimal(String nombre, String tipo, String onomatopeya) {
        switch (tipo.toLowerCase()) {
            case "terrestre":
                return new Terrestre(nombre, onomatopeya);
            case "volador":
                return new Volador(nombre, onomatopeya);
            case "acuatico":
                return new Acuatico(nombre, onomatopeya);
            default:
                throw new IllegalArgumentException("Tipo de animal no válido: " + tipo);
        }
    }
}
