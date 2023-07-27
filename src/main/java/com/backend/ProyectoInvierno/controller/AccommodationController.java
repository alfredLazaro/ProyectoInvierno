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
public class AccommodationController {
  @Autowired
  private LocationRepository ubicacionRepository;
  @Autowired
  private AccommondationRepository alojamientoRepository;
  @Autowired
  private EstablishmentRepository establecimientoRepository;
  @Autowired
  private PictureRepository imagenRepository;
  @Autowired
  private ResponsibleRepository encargadoRepository;

  @Autowired
  private ServiceEstablishmentRepository servicioEstablecimientoRepository;
  @Autowired
  private ParquetEstablishmentRepository paqueteEstablecimientoRepository;

  //http://localhost:8080/inf/alojamiento/es/2
  @GetMapping("/es/{idEstablecimiento}")
  public Optional<ResponsiblePerson> todosLosAlojamientos(@PathVariable Long idEstablecimiento) {
    Long idEncargado = establecimientoRepository.findById(idEstablecimiento).orElse(null).getIdResponsible();
    return encargadoRepository.findById(idEncargado);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Establishment>> unAlojamiento(@PathVariable Long id) {
    Optional<Establishment> alojamiento = establecimientoRepository.findById(id);
    return ResponseEntity.ok(alojamiento);
  }


  @GetMapping("/ubicaciones")
  public ResponseEntity<List<EstablishmentPackage>> ubicaciones() {
    return ResponseEntity.ok(paqueteEstablecimientoRepository.findAll());
  }
}
