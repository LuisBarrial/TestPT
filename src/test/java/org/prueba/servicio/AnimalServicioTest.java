package org.prueba.servicio;

import org.junit.jupiter.api.*;
import org.prueba.modelo.Animal;
import org.prueba.modelo.Tipo.Acuatico;
import org.prueba.modelo.Tipo.Terrestre;
import org.prueba.modelo.Tipo.Volador;
import org.prueba.modelo.factory.AnimalFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnimalServicioTest {

    @Test
    void testCrearAnimalValido() {
        String nombre = "Max";
        String tipo = "Terrestre";
        String onomatopeya = "Guau";
        Animal animal = AnimalFactory.crearAnimal(nombre, tipo, onomatopeya);
        assertNotNull(animal);
        assertEquals(nombre, animal.getNombre());
        assertEquals(tipo, animal.getTipo());
        assertEquals(onomatopeya, animal.getOnomatopeya());
    }

    @Test
    void testCrearAnimalTipoInvalido() {
        String nombre = "Max";
        String tipo = "Dragón";
        String onomatopeya = "Rawr";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            AnimalFactory.crearAnimal(nombre, tipo, onomatopeya);
        });

        assertEquals("Tipo de animal no válido: Dragón", exception.getMessage());
    }

    @Test
    void testAgruparAnimalesPorTipo_ListaVacia() {
        AnimalServicio animalService = new AnimalServicio();
        List<Animal> animales = new ArrayList<>();

        String resultado = animalService.agruparAnimalesPorTipo(animales);
        String esperado = ""; // Resultado esperado para una lista vacía

        assertEquals(esperado, resultado);
    }

    @Test
    void testAgruparAnimalesPorTipo_ListaLlena() {
        AnimalServicio animalService = new AnimalServicio();
        List<Animal> animales = Arrays.asList(
                new Terrestre("Perro", "Guau"),
                new Terrestre("Gato", "Miau"),
                new Volador("Águila", "Kiiii"),
                new Acuatico("Delfín", "Iiih")
        );
        String resultado = animalService.agruparAnimalesPorTipo(animales);
        String esperado = "Terrestre:\n" +
                "Perro hace Guau\n" +
                "Gato hace Miau\n" +
                "\n" +
                "Volador:\n" +
                "Águila hace Kiiii\n" +
                "\n" +
                "Acuático:\n" +
                "Delfín hace Iiih";
        assertEquals(esperado, resultado);
    }


}