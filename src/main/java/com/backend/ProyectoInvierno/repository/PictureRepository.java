package com.backend.ProyectoInvierno.repository;

import com.backend.ProyectoInvierno.dto.PictureDTO;
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

    /*@Query("SELECT pic.id_picture AS picture_id,pic.picture_name,pic.establicment_picture AS picture_path,e.id_Restaurant,e.name AS restaurant_name FROM Picture pic JOIN Restaurant r on pic.id_picture=r.id_Restaurant")
    List<PictureDTO> findAllPicWithRestaurant();*/
    /*@Query("SELECT pic.id_picture AS picture_id, pic.picture_name, pic.establishment_picture AS picture_path, r.id_Restaurant AS restaurant_id, r.name AS restaurant_name FROM Picture pic JOIN pic.establishment e JOIN e.restaurant r")
    List<PictureDTO> findAllPicWithRestaurant();*/
    /*@Query("SELECT pic.id_picture AS picture_id, pic.picture_name, pic.establishment_picture AS picture_path, r.id_Restaurant AS restaurant_id, r.name AS restaurant_name FROM Picture pic JOIN pic.establishment e JOIN e.restaurant r")
    List<PictureDTO> findAllPicWithRestaurant();*/
    @Query("SELECT NEW com.backend.ProyectoInvierno.dto.PictureDTO(pic.id_picture, pic.picture_name, pic.establishment_picture, r.id,r.name) FROM Picture pic JOIN Restaurant r ON pic.establishment.id=r.id")
    List<PictureDTO> findPicturesDto();

    /*@Query("SELECT NEW com.backend.ProyectoInvierno.dto.PictureDTO(pic.id_picture, pic.picture_name, pic.establishment_picture, r.id_Restaurant, r.name) " +
            "FROM Picture pic JOIN pic.establishment e JOIN e.restaurant r")
    List<PictureDTO> findAllPicturesDTOWithRestaurant();*/

    @Query("SELECT pic FROM Picture pic JOIN Restaurant e ON pic.establishment.id = e.id")
    List<Picture> findAllPicturesWithRestaurant();

    @Query("SELECT pic FROM Picture pic JOIN Establishment e ON pic.establishment.id = e.id WHERE e.id = :restaurantId")
    List<Picture> findPicturesByRestaurantId(Long restaurantId);

}
