package co.analisys.entrenadores.controller;

import co.analisys.entrenadores.dto.EntrenadorDTO;
import co.analisys.entrenadores.service.interfaces.IEntrenadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/entrenadores")
@Tag(name = "Entrenadores", description = "Gestión de entrenadores del gimnasio")
public class EntrenadoresController {
    private final IEntrenadorService entrenadorService;

    public EntrenadoresController(IEntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    @Operation(summary = "Agregar un nuevo entrenador",
            description = "Permite agregar un nuevo entrenador al sistema. " +
                    "Accesible solo para administradores.")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public EntrenadorDTO agregarEntrenador(@RequestBody EntrenadorDTO entrenadorDTO) {
        return entrenadorService.agregarEntrenador(entrenadorDTO);
    }

    @Operation(summary = "Obtener todos los entrenadores",
            description = "Obtiene la lista de todos los entrenadores registrados. " +
                    "Accesible solo para administradores y entrenadores.")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TRAINER')")
    @GetMapping
    public List<EntrenadorDTO> obtenerTodosEntrenadores() {
        return entrenadorService.obtenerTodosEntrenadores();
    }

    @Operation(summary = "Verificar disponibilidad de un entrenador",
            description = "Verifica si un entrenador está disponible. " +
                    "Accesible para administradores, entrenadores y miembros.")
    @GetMapping("/{id}/disponible")
    public boolean verificarDisponibilidad(@PathVariable String id) {
        return entrenadorService.verificarDisponibilidad(id);
    }
}