package org.prueba.modelo.factory;

import org.prueba.modelo.Animal;
import org.prueba.modelo.Tipo.Acuatico;
import org.prueba.modelo.Tipo.Terrestre;
import org.prueba.modelo.Tipo.Volador;

public class AnimalFactory {
    public static Animal crearAnimal(String nombre, String tipo, String onomatopeya) {
        switch (tipo.toUpperCase()) {
            case "TERRESTRE":
                return new Terrestre(nombre, onomatopeya);
            case "VOLADOR":
                return new Volador(nombre, onomatopeya);
            case "ACUATICO":
                return new Acuatico(nombre, onomatopeya);
            default:
                throw new IllegalArgumentException("Tipo de animal no válido: " + tipo);
        }
    }
}
