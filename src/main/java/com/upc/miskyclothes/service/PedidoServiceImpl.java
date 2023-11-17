package com.upc.miskyclothes.service;

import com.upc.miskyclothes.entities.Pedido;
import com.upc.miskyclothes.entities.Stock;
import com.upc.miskyclothes.entities.User;
import com.upc.miskyclothes.interfaceservice.PedidoService;

import com.upc.miskyclothes.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    public Pedido register(Pedido pedido){return pedidoRepository.save(pedido);}
    public List<Pedido> listPedido(){return pedidoRepository.findAll();}
    public Pedido updatePedido(Pedido pedido) throws Exception{
        pedidoRepository.findById(pedido.getId()).orElseThrow(()->new Exception("No se encontro"));
        return pedidoRepository.save(pedido);
    }
    public Pedido deletePedido(Long dni) throws Exception{
        Pedido pedido   = pedidoRepository.findById(dni).orElseThrow(()->new Exception("No se pudo encontrar usuario"));
        pedidoRepository.delete(pedido);
        return pedido;
    }

}
