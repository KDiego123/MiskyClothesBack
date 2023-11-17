package com.upc.miskyclothes.controller;


import com.upc.miskyclothes.dtos.PedidoDTO;
import com.upc.miskyclothes.entities.Pedido;
import com.upc.miskyclothes.interfaceservice.PedidoService;
import com.upc.miskyclothes.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    @Autowired
    private PedidoRepository pedidoRepository;
    @PostMapping("/registrar")
    public ResponseEntity<Pedido> registrarPedido(@RequestBody Pedido pedido) {
        Pedido nuevoPedido = pedidoRepository.save(pedido);
        return ResponseEntity.ok(nuevoPedido);
    }

    @DeleteMapping("/{pedidoId}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Long pedidoId) {
        pedidoRepository.deleteById(pedidoId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{pedidoId}/ver-tiempo-espera")
    public ResponseEntity<Integer> verTiempoEspera(@PathVariable Long pedidoId) {
        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new EntityNotFoundException("Pedido no encontrado"));
        Integer tiempoEspera = pedido.getTiempo_aprox();
        return ResponseEntity.ok(tiempoEspera);
    }


}
