package com.upc.miskyclothes.service;
import com.upc.miskyclothes.entities.Image;
import com.upc.miskyclothes.interfaceservice.ImageService;
import com.upc.miskyclothes.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageRepository imageRepository;
    public Image uploadImage(Image image) {
        return imageRepository.save(image);
    }
    public List<Image> listImage(){
        return imageRepository.findAll();
    }

    public Image deleteImage(Long id){
        Image image = imageRepository.findById(id).orElse(null);
        if(image != null){
            imageRepository.delete(image);
        }
        return image;
    }
    public Image updateImage(Image image)throws Exception{
        imageRepository.findById(image.getId()).
                orElseThrow(()->new Exception("No se encontró la entidad"));
        return imageRepository.save(image);
    }
    public Image getImage(Long id){
        return imageRepository.findImageById(id);
    }
}
