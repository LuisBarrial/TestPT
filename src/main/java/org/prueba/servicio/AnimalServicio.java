package org.prueba.servicio;

import org.prueba.modelo.Animal;
import org.prueba.modelo.factory.AnimalFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnimalServicio {
    public String agruparAnimalesPorTipo(List<Animal> animales) {
        return animales.stream()
                .collect(Collectors.groupingBy(Animal::getTipo))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getKey() + ":\n" + entry.getValue().stream()
                        .map(x->x.getNombre()+" hace "+x.getOnomatopeya().trim())
                        .collect(Collectors.joining("\n")))
                .collect(Collectors.joining("\n\n"));
    }

    public boolean LeerArchivo(String ruta, int args){
        List<Animal> animales = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Procesar cada línea
                String[] partes = linea.split("\\|");
                if (partes.length != 3) {
                    System.out.println("Formato incorrecto: " + linea);
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

        } catch (IOException e) {
            if(args==0)  System.out.println("Archivo Animales.txt no encontrado");
            return false;
        }
        if(animales.isEmpty()){
            System.out.println("Error: Archivo Animales.txt Vacio");
            return false;
        }
        String resultado = agruparAnimalesPorTipo(animales);
        System.out.println(resultado);
        return true;

    }
}
