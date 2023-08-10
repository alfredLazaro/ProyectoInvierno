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
import java.util.Optional;

@Service
public class StorageService {
    @Autowired
    private PictureRepository pictureRepository;

    private static String FOLDER_PATH = System.getProperty("user.dir") + "/images/";

    public String uploadImageToFileSystem(MultipartFile file, Long id_establishment) throws IOException {
        String filePath = FOLDER_PATH+file.getOriginalFilename();
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

    public byte[] downloadImageFromFileSystem(Long id) throws IOException {
        Optional<Picture> fileData = pictureRepository.findById(id);
        String filePath=fileData.get().getEstablishment_picture();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }
}
