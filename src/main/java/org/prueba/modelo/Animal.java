package org.prueba.modelo;

public abstract class Animal {
    private String nombre;
    private String onomatopeya;

    public Animal(String nombre, String onomatopeya) {
        this.nombre = nombre;
        this.onomatopeya = onomatopeya;
    }

    public String getNombre() {
        return nombre;
    }

    public String getOnomatopeya() {
        return onomatopeya;
    }

    public abstract String getTipo();
}