package com.backend.ProyectoInvierno.repository;

import com.backend.ProyectoInvierno.model.PaqueteEstablecimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaqueteEstablecimientoRepository extends JpaRepository<PaqueteEstablecimiento, Long> {
}
