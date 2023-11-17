package com.upc.miskyclothes.interfaceservice;
import com.upc.miskyclothes.entities.Image;
import com.upc.miskyclothes.entities.ImageDisenador;

import java.util.List;
public interface ImageDisenadorService {
    public ImageDisenador uploadImageDis(ImageDisenador imageDisenador);
    public List<ImageDisenador> listImageDis();
    public ImageDisenador updateImageDis(ImageDisenador imageDisenador)throws Exception;
    public ImageDisenador deleteImageDis(Long id);
    public ImageDisenador getImageDis(Long id);
}
