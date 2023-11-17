package com.upc.miskyclothes.controller;
import com.upc.miskyclothes.entities.ImageDisenador;
import org.modelmapper.ModelMapper;
import com.upc.miskyclothes.dtos.ImageDisenadorDTO;
import com.upc.miskyclothes.interfaceservice.ImageDisenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ImageDisenadorController {
    @Autowired
    ImageDisenadorService imageDisenadorService;

    @PostMapping("/imagedisenador/upload")
    public <Mono> ResponseEntity<ImageDisenadorDTO> uploadImageDis(@RequestParam("file") MultipartFile file) {
        try {
            if (file != null) {
                ImageDisenador imageDisenador = new ImageDisenador();
                imageDisenador.setFilename(file.getOriginalFilename());
                imageDisenador.setImageData(file.getBytes());
                imageDisenador = imageDisenadorService.uploadImageDis(imageDisenador);
                ImageDisenadorDTO dto = convertToDTO(imageDisenador);
                return new ResponseEntity<>(dto, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/imagedisenador/list")
    public <Flux>ResponseEntity<List<ImageDisenadorDTO>> getAllImages() {
        return new ResponseEntity<>(convertToListDTO(imageDisenadorService.listImageDis()), HttpStatus.OK);
    }
    @DeleteMapping("/imagedisenador/{id}")
    public <Mono>ResponseEntity<Void> deleteImageDis(@PathVariable Long id) {
        imageDisenadorService.deleteImageDis(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    private ImageDisenadorDTO convertToDTO(ImageDisenador imageDisenador){
        ModelMapper modelMapper =new ModelMapper();
        return modelMapper.map(imageDisenador, ImageDisenadorDTO.class);
    }

    private List<ImageDisenadorDTO> convertToListDTO(List<ImageDisenador> list){
        return list.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
}