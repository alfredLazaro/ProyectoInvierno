package com.backend.ProyectoInvierno.service;

import com.backend.ProyectoInvierno.model.Establishment;
import com.backend.ProyectoInvierno.model.Picture;
import com.backend.ProyectoInvierno.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class StorageService {
    @Autowired
    private PictureRepository pictureRepository;

    private static String FOLDER_PATH_ACCOMMODATION = Paths.get(System.getProperty("user.dir"),"images","accommodation",".").toString() ;
    private static String FOLDER_PATH_RESTAURANT = Paths.get(System.getProperty("user.dir"),"images","restaurant",".").toString() ;

    public String uploadImageAccommodation(MultipartFile file, Long id_establishment) throws IOException {
        return uploadImageToFileSystem(file, id_establishment, FOLDER_PATH_ACCOMMODATION);
    }

    public String uploadImageRestaurant(MultipartFile file, Long id_establishment) throws IOException {
        return uploadImageToFileSystem(file, id_establishment, FOLDER_PATH_RESTAURANT);
    }

    private String uploadImageToFileSystem(MultipartFile file, Long id_establishment, String path) throws IOException {
        checkDirectory(path);

        String filePath = path+file.getOriginalFilename();
        // Crear establecimiento para hacer referencia en BD
        Establishment establishment = new Establishment();
        establishment.setIdEstablishment(id_establishment);

        // Rellenamos datos de Imagen + enlace con Establecimiento y lo registramos en BD
        Picture pictureData = new Picture(file.getOriginalFilename(), filePath);
        pictureData.setEstablishment(establishment);
        pictureData = pictureRepository.save(pictureData);

        file.transferTo(new File(filePath));

        if (pictureData != null) {
            return file.getOriginalFilename();
        }
        return null;
    }

    private void checkDirectory(String path){
        File directory = new File(path);

        if (!directory.exists()) {
            boolean created = directory.mkdirs();

            if (created) {
                System.out.println("Directorio creado en: " + path);
            } else {
                System.out.println("No se pudo crear el directorio en: " + path);
            }
        } else {
            System.out.println("El directorio ya existe en: " + path);
        }
    }

    public byte[] downloadImageFromFileSystem(Long id) throws IOException {
        Optional<Picture> fileData = pictureRepository.findById(id);
        String filePath=fileData.get().getEstablishment_picture();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }
}
