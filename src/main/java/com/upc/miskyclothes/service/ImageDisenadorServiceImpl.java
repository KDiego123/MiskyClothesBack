package com.upc.miskyclothes.service;
import com.upc.miskyclothes.entities.ImageDisenador;
import com.upc.miskyclothes.interfaceservice.ImageDisenadorService;
import com.upc.miskyclothes.repository.ImageDisenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageDisenadorServiceImpl implements ImageDisenadorService {
@Autowired
ImageDisenadorRepository imageDisenadorRepository;
    public ImageDisenador uploadImageDis(ImageDisenador imageDisenador) {
        return imageDisenadorRepository.save(imageDisenador);
    }
    public List<ImageDisenador> listImageDis() {
        return imageDisenadorRepository.findAll();
    }

    public ImageDisenador deleteImageDis(Long id){
        ImageDisenador imageDisenador= imageDisenadorRepository.findById(id).orElse(null);
        if (imageDisenador!=null){
            imageDisenadorRepository.delete(imageDisenador);
        }
        return imageDisenador;
    }
    public ImageDisenador updateImageDis(ImageDisenador imageDisenador) throws Exception {
        imageDisenadorRepository.findById(imageDisenador.getId()).orElseThrow(()->new Exception("No se encontró"));
        return imageDisenadorRepository.save(imageDisenador);
    }
    public ImageDisenador getImageDis(Long id) {
        return imageDisenadorRepository.findImageById(id);
    }
}
