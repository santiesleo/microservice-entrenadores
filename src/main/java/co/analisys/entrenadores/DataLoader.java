package co.analisys.entrenadores;

import co.analisys.entrenadores.model.Entrenador;
import co.analisys.entrenadores.model.EntrenadorId;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {


    @Override
    public void run(String... args) {

        Entrenador entrenador1 = new Entrenador(new EntrenadorId("U001"),
                "Carlos Rodríguez",
                "Yoga");

        Entrenador entrenador2 = new Entrenador(new EntrenadorId("U002"),
                "Ana Martínez",
                "Spinning");

        System.out.println("Datos de prueba cargados exitosamente.");

    }
}