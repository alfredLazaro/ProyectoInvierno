package com.backend.ProyectoInvierno.controller;

import com.backend.ProyectoInvierno.model.*;
import com.backend.ProyectoInvierno.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/inf/alojamiento")
public class AccommodationController {

  @Autowired
  private EstablishmentRepository establishmentRepository;

  @Autowired
  private ResponsibleRepository responsibleRepository;

  @GetMapping("/es/{idEstablecimiento}")
  public List<ResponsiblePerson> todosLosAlojamientos(@PathVariable Long idEstablecimiento) {
    System.out.println(idEstablecimiento);
    Long idEncargado = establishmentRepository.findById(idEstablecimiento).orElse(null).getIdResponsible();
    System.out.println(idEncargado);
    List<Long> ids = Arrays.asList(idEncargado);
    return responsibleRepository.findAllById(ids);
  }

  @GetMapping("/{idEstablecimiento}")
  public ResponseEntity<ResponsiblePerson> unAlojamiento(@PathVariable Long idEstablecimiento) {
    ResponsiblePerson responsiblePerson = responsibleRepository.findForId(idEstablecimiento);
    return ResponseEntity.ok(responsiblePerson);
  }


  @GetMapping()
  public ResponseEntity<List<Establishment>> accommodationList() {
    return ResponseEntity.ok(establishmentRepository.findAllEstablishments());
  }

}
