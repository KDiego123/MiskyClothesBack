package com.upc.miskyclothes.interfaceservice;

import com.upc.miskyclothes.entities.Pedido;
import com.upc.miskyclothes.entities.User;

import java.util.List;

public interface PedidoService {

    public Pedido register(Pedido pedido);
    public List<Pedido> listPedido();
    public Pedido updatePedido(Pedido pedido) throws Exception;
    public Pedido deletePedido(Long id) throws Exception;



}
