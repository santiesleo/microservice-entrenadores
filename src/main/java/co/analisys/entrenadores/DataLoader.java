package co.analisys.entrenadores;

import co.analisys.entrenadores.dto.EntrenadorDTO;
import co.analisys.entrenadores.service.interfaces.IEntrenadorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final IEntrenadorService entrenadorService;

    public DataLoader(IEntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    @Override
    public void run(String... args) {

        EntrenadorDTO entrenador1 = new EntrenadorDTO("U001",
                "Carlos Rodríguez",
                "Yoga");

        EntrenadorDTO entrenador2 = new EntrenadorDTO("U002",
                "Ana Martínez",
                "Spinning");

        entrenadorService.agregarEntrenador(entrenador1);
        entrenadorService.agregarEntrenador(entrenador2);

        System.out.println("Datos de prueba cargados exitosamente.");

    }
}