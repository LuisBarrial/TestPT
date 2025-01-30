package org.prueba.config;

import org.prueba.modelo.Animal;
import org.prueba.modelo.Tipo.Acuatico;
import org.prueba.modelo.Tipo.Terrestre;
import org.prueba.modelo.Tipo.Volador;
import org.prueba.servicio.AnimalServicio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public AnimalServicio animalService() {
        return new AnimalServicio();
    }
}