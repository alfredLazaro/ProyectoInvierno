package com.backend.ProyectoInvierno.controller;

import com.backend.ProyectoInvierno.model.Picture;
import com.backend.ProyectoInvierno.repository.PictureRepository;
import com.backend.ProyectoInvierno.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/image")
@CrossOrigin(origins = "http://localhost:3000")
public class PictureController {

    @Autowired
    private StorageService storageService;
    @Autowired
    private PictureRepository pictureRepository;
    @PostMapping("/fileSystem")
    public ResponseEntity<?> uploadImageToFileSystem(@RequestParam("images") MultipartFile[] files, @RequestParam("id_establishment") Long id_establishment) throws IOException {
        String message = "";
        for(MultipartFile file : files){
            String uploadImage = storageService.uploadImageToFileSystem(file, id_establishment);
            message += uploadImage + ",";
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(message);
    }

    @GetMapping("/fileSystem/{id}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable Long id) throws IOException {
        byte[] imageData=storageService.downloadImageFromFileSystem(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }

    @GetMapping("/inf/images")
    public List<Picture> getInfImages(){
        List<Picture> lisInfPictur=new ArrayList<>();
        lisInfPictur=pictureRepository.findAllPicture();
        return lisInfPictur;
    }
}
