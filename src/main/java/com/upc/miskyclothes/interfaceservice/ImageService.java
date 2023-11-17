package com.upc.miskyclothes.interfaceservice;
import com.upc.miskyclothes.entities.Image;

import java.util.List;

public interface ImageService {
    public Image uploadImage(Image image);
    public List<Image> listImage();
    public Image updateImage(Image image)throws Exception;
    public Image deleteImage(Long id);
    public Image getImage(Long id);
}
