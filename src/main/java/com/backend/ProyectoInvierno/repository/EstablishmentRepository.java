package com.backend.ProyectoInvierno.repository;

import com.backend.ProyectoInvierno.model.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {

}
