package com.upc.miskyclothes.controller;

import com.upc.miskyclothes.dtos.BoletaDTO;
import com.upc.miskyclothes.entities.Boleta;
import com.upc.miskyclothes.interfaceservice.BoletaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BoletaController {
    @Autowired
    private BoletaService boletaService;
    @PostMapping("/boleta")
    ResponseEntity<BoletaDTO> register(@RequestBody BoletaDTO boletaDTO){
        Boleta boleta;
        BoletaDTO dto;
        try{
            boleta=convertToEntity(boletaDTO);
            boleta=boletaService.register(boleta);
            dto=convertToDto(boleta);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se ha podido encontra");
        }
        return new ResponseEntity<BoletaDTO>(dto,HttpStatus.OK);
    }
    @GetMapping("/boletas")
    public ResponseEntity<List<BoletaDTO>>listBoletas(){
        List<Boleta> list;
        List<BoletaDTO> listDTO=null;
        try{
            list=boletaService.listBoleta();
            listDTO=converToListDto(list);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Lista no disponible");
        }
        return new ResponseEntity<>(listDTO,HttpStatus.OK);
    }
    @PutMapping("/boleta")
    public ResponseEntity<Boleta>updateBoleta(@RequestBody Boleta boleta) {
        Boleta boleta1;
        try {
            boleta1 = boletaService.updateBoleta(boleta);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se puede actualizar");
        }
        return new ResponseEntity<Boleta>(boleta1, HttpStatus.OK);


    }



    private Boleta convertToEntity(BoletaDTO boletaDTO){
        ModelMapper modelMapper=new ModelMapper();
        Boleta post= modelMapper.map(boletaDTO, Boleta.class);
        return post;
    }

    private BoletaDTO convertToDto(Boleta boleta){
        ModelMapper modelMapper=new ModelMapper();
        BoletaDTO boletaDTO =modelMapper.map(boleta,BoletaDTO.class);
        return boletaDTO;
    }

    private List<BoletaDTO> converToListDto(List<Boleta> list){
        return list.stream().map(this::convertToDto).collect(Collectors.toList());
    }
}


