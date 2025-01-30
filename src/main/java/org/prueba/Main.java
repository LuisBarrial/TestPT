package org.prueba;

import org.prueba.config.AppConfig;
import org.prueba.modelo.Animal;
import org.prueba.modelo.factory.AnimalFactory;
import org.prueba.servicio.AnimalServicio;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AnimalServicio animalService = context.getBean(AnimalServicio.class);

        String rutaArchivo = "./Animales.txt"; // Ruta del Archivo
        boolean hayArchivo = animalService.LeerArchivo(rutaArchivo, args.length);
        if(hayArchivo){
            new Scanner(System.in).nextLine();
            return;
        }
        if (args.length == 0) {
            System.out.println("Por favor, ingresa los datos de los animales en formato: nombre|tipo|onomatopeya");
            new Scanner(System.in).nextLine();
            return;
        }

        List<Animal> animales = new ArrayList<>();

        for (String arg : args) {
            String[] partes = arg.split("\\|");
            if (partes.length != 3) {
                System.out.println("Formato incorrecto: " + arg);
                continue;
            }

            String nombre = partes[0];
            String tipo = partes[1];
            String onomatopeya = partes[2];

            try {
                // Crear el animal usando la fábrica
                Animal animal = AnimalFactory.crearAnimal(nombre, tipo, onomatopeya);
                animales.add(animal);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        String resultado = animalService.agruparAnimalesPorTipo(animales);
        System.out.println(resultado);
        new Scanner(System.in).nextLine(); 
    }
}