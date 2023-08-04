package com.backend.ProyectoInvierno.controller;

import com.backend.ProyectoInvierno.model.*;
import com.backend.ProyectoInvierno.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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

  @GetMapping("/{idEstablishment}")
  public ResponseEntity<ResponsiblePerson> unAlojamiento(@PathVariable Long idEstablishment) {
    ResponsiblePerson responsiblePerson = responsibleRepository.findForId(idEstablishment);
    Establishment establishment = responsiblePerson.getEstablishments().stream().
            filter(establishmen -> establishmen.getIdEstablishment()== idEstablishment).findFirst().get();
    ResponsiblePerson responsiblePerson1 = new ResponsiblePerson();
    responsiblePerson1.setId(responsiblePerson.getId());
    responsiblePerson1.setName(responsiblePerson.getName());
    List<Establishment> est = new ArrayList<>();
    est.add(establishment);
    responsiblePerson1.setEstablishments(est);

    return ResponseEntity.ok(responsiblePerson1);
  }


  @GetMapping()
  public ResponseEntity<List<Establishment>> accommodationList() {
    return ResponseEntity.ok(establishmentRepository.findAllEstablishments());
  }

}
