package com.backend.ProyectoInvierno.repository;

import com.backend.ProyectoInvierno.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {
    @Query("SELECT p FROM Picture p") /*es importante el las mayusculas da error si ponemos picure*/

    List<Picture> findAllPicture();
}
