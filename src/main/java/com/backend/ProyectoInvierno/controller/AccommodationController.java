package com.backend.ProyectoInvierno.controller;

import com.backend.ProyectoInvierno.model.*;
import com.backend.ProyectoInvierno.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.backend.ProyectoInvierno.model.Accommodation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/inf/alojamiento")
public class AccommodationController {
  @Autowired
  private LocationRepository ubicacionRepository;
  @Autowired
  private AccommondationRepository accommondationRepository;
  @Autowired
  private EstablishmentRepository establecimientoRepository;
  @Autowired
  private PictureRepository imagenRepository;
  @Autowired
  private ResponsibleRepository encargadoRepository;

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
    // hace algo raro, pasa que findForId, busca todos los objetos con id iguales que este en el resposiblePerson
    // osea que mismo id de establecimiento y responsible person... medio raro pero asi es...
    ResponsiblePerson responsiblePerson = responsibleRepository.findForId(idEstablishment);
    Establishment establishment = responsiblePerson.getEstablishments().stream().
            filter(establishmen -> establishmen.getIdEstablishment() == idEstablishment).findFirst().get();
    ResponsiblePerson responsiblePerson1 = new ResponsiblePerson();
    responsiblePerson1.setId(responsiblePerson.getId());
    responsiblePerson1.setName(responsiblePerson.getName());
    List<Establishment> est = new ArrayList<>();
    est.add(establishment);
    responsiblePerson1.setEstablishments(est);

    return ResponseEntity.ok(responsiblePerson1);
  }

  @PostMapping
  public Accommodation createAccomodation(@RequestBody Accommodation accommodation) {
    return accommondationRepository.save(accommodation);
  }


  @GetMapping()
  public ResponseEntity<List<Establishment>> accommodationList() {
    return ResponseEntity.ok(establishmentRepository.findAllEstablishments());
  }

  @GetMapping("/all")
  public ResponseEntity<List<Accommodation>> allAccommodationList() {
    return ResponseEntity.ok((accommondationRepository.findAllAccommondations()));
  }

}
