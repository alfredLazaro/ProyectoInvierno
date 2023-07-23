package com.backend.ProyectoInvierno.repository;

import com.backend.ProyectoInvierno.model.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagenRepository extends JpaRepository<Imagen, Long> {
}
