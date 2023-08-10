package com.backend.ProyectoInvierno.repository;

import com.backend.ProyectoInvierno.model.EstablishmentPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParquetEstablishmentRepository extends JpaRepository<EstablishmentPackage, Long> {
}
