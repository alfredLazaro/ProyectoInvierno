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

@RestController
@RequestMapping("/inf/alojamiento")
public class AlojamientoController {
  @Autowired
  private UbicacionRepository ubicacionRepository;
  @Autowired
  private AlojamientoRepository alojamientoRepository;
  @Autowired
  private EstablecimientoRepository establecimientoRepository;
  @Autowired
  private ImagenRepository imagenRepository;
  @Autowired
  private EncargadoRepository encargadoRepository;

  @Autowired
  private ServicioEstablecimientoRepository servicioEstablecimientoRepository;
  @Autowired
  private PaqueteEstablecimientoRepository paqueteEstablecimientoRepository;

  //http://localhost:8080/inf/alojamiento/es/2
  @GetMapping("/es/{idEstablecimiento}")
  public Optional<Encargado> todosLosAlojamientos(@PathVariable Long idEstablecimiento) {
    Long idEncargado = establecimientoRepository.findById(idEstablecimiento).orElse(null).getIdEncargado();
    return encargadoRepository.findById(idEncargado);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Establecimiento>> unAlojamiento(@PathVariable Long id) {
    Optional<Establecimiento> alojamiento = establecimientoRepository.findById(id);
    return ResponseEntity.ok(alojamiento);
  }


  @GetMapping("/ubicaciones")
  public ResponseEntity<List<PaqueteEstablecimiento>> ubicaciones() {
    return ResponseEntity.ok(paqueteEstablecimientoRepository.findAll());
  }
}
