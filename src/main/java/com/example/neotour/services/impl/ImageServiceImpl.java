//package com.example.neotour.services.impl;
//import com.example.neotour.entities.Image;
//import com.example.neotour.repositories.ImageRepository;
//import com.example.neotour.services.ImageService;
//import com.example.neotour.utils.ImageUtils;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.UUID;
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class ImageServiceImpl implements ImageService {
//
//    private final ImageRepository imageRepository;
//
//    @Override
//    public ResponseEntity<?> get(UUID id) {
//        log.info("fetching image by id: " + id);
//        Image image = imageRepository.findById(id).orElseThrow(() -> new RuntimeException("Image not found"));
//        byte[] imageData = ImageUtils.decompressImage(image.getImageData());
//        return ResponseEntity.ok()
//                .contentType(MediaType.valueOf(image.getType()))
//                .body(imageData);
//    }
//}
