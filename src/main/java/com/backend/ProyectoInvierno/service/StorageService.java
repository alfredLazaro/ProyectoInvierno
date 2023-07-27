package com.backend.ProyectoInvierno.service;

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

    private final String FOLDER_PATH="/home/mauhv/images/"; //Cambiar a directorio interno

    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        String filePath=FOLDER_PATH+file.getOriginalFilename();

        Picture fileData=pictureRepository.save(new Picture(file.getOriginalFilename(), filePath));

        file.transferTo(new File(filePath));

        if (fileData != null) {
            return "file uploaded successfully : " + filePath;
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
