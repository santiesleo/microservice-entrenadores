package co.analisys.entrenadores.controller;

import co.analisys.entrenadores.dto.EntrenadorDTO;
import co.analisys.entrenadores.service.interfaces.IEntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrenadores")
class EntrenadoresController {
    @Autowired
    private IEntrenadorService entrenadorService;

    @PostMapping
    public EntrenadorDTO agregarEntrenador(@RequestBody EntrenadorDTO entrenadorDTO) {
        return entrenadorService.agregarEntrenador(entrenadorDTO);
    }

    @GetMapping
    public List<EntrenadorDTO> obtenerTodosEntrenadores() {
        return entrenadorService.obtenerTodosEntrenadores();
    }

    @GetMapping("/{id}/disponible")
    public boolean verificarDisponibilidad(@PathVariable String id) {
        return entrenadorService.verificarDisponibilidad(id);
    }
}