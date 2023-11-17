package com.upc.miskyclothes.interfaceservice;

import com.upc.miskyclothes.entities.Opinion;
import com.upc.miskyclothes.entities.Pedido;

import java.util.List;

public interface OpinionService {

    public Opinion register(Opinion opinion);
    public List<Opinion> listOpinion();
    public Opinion updateOpinion(Opinion pedido) throws Exception;
    public Opinion deleteOpinion(Long id) throws Exception;

}
