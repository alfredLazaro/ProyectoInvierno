package com.backend.ProyectoInvierno.repository;

import com.backend.ProyectoInvierno.model.Encargado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncargadoRepository extends JpaRepository<Encargado, Long> {
}
