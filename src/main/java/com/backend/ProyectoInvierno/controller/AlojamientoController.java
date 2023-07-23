package com.backend.ProyectoInvierno.controller;

import com.backend.ProyectoInvierno.model.*;
import com.backend.ProyectoInvierno.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/inf/alojamiento")
public class AlojamientoController {
  @Autowired
  private AlojamientoRepository alojamientoRepository;
  @Autowired
  private EstablecimientoRepository establecimientoRepository;
  @Autowired
  private ImagenRepository imagenRepository;
  @Autowired
  private EncargadoRepository encargadoRepository;
  @Autowired
  private UbicacionRepository ubicacionRepository;
  @Autowired
  private ServicioEstablecimientoRepository servicioEstablecimientoRepository;
  @Autowired
  private PaqueteEstablecimientoRepository paqueteEstablecimientoRepository;

  @GetMapping
  public List<Establecimiento> todosLosAlojamientos() {
    return establecimientoRepository.findAll()
            .stream()
            .peek(establecimiento -> {
              Ubicacion ubicacion = ubicacionRepository.findById(establecimiento.getIdEstablecimiento())
                      .orElse(null);
              establecimiento.setUbicacion(ubicacion);
            })
            .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Alojamiento>> unAlojamiento(@PathVariable Long id) {
    Optional<Alojamiento> alojamiento = alojamientoRepository.findById(id);
    return ResponseEntity.ok(alojamiento);
  }


  @GetMapping("/ubicaciones")
  public ResponseEntity<List<Alojamiento>> ubicaciones() {
    return ResponseEntity.ok(alojamientoRepository.findAll());
  }
}
