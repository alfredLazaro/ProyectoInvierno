package com.backend.ProyectoInvierno.repository;

import com.backend.ProyectoInvierno.model.Accommodation;
import com.backend.ProyectoInvierno.model.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommondationRepository extends JpaRepository<Accommodation, Long> {
  @Query("SELECT acc FROM Accommodation acc")
  List<Accommodation> findAllAccommondations();
}
