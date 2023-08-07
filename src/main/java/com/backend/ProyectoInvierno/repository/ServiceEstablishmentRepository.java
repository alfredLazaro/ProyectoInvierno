package com.backend.ProyectoInvierno.repository;

import com.backend.ProyectoInvierno.model.EstablishmentService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceEstablishmentRepository extends JpaRepository<EstablishmentService, Long> {
}
