package com.backend.ProyectoInvierno.controller;

import com.backend.ProyectoInvierno.model.*;
import com.backend.ProyectoInvierno.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.backend.ProyectoInvierno.model.Accommodation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/inf/alojamiento")
public class AccommodationController {
  @Autowired
  private AccommondationRepository accommondationRepository;

  @Autowired
  private EstablishmentRepository establishmentRepository;

  @Autowired
  private ResponsibleRepository responsibleRepository;

  @GetMapping("/es/{idEstablishment}")
  public List<ResponsiblePerson> todosLosAlojamientos(@PathVariable Long idEstablishment) {
    System.out.println(idEstablishment);
    Long idResponsible = establishmentRepository.findById(idEstablishment).orElse(null).getIdResponsible();
    System.out.println(idResponsible);
    List<Long> ids = Arrays.asList(idResponsible);
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

  @PostMapping
  public Accommodation createAccommodation(@RequestBody Accommodation accommodation){
    return accommondationRepository.save(accommodation);
  }


  @GetMapping()
  public ResponseEntity<List<Establishment>> accommodationList() {
    return ResponseEntity.ok(establishmentRepository.findAllEstablishments());
  }

}
