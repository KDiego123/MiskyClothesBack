package com.upc.miskyclothes.controller;

import com.upc.miskyclothes.dtos.DisenadorDTO;
import com.upc.miskyclothes.dtos.PoloDTO;
import com.upc.miskyclothes.entities.Disenador;
import com.upc.miskyclothes.entities.Polo;
import com.upc.miskyclothes.interfaceservice.DisenadorService;

import com.upc.miskyclothes.interfaceservice.ImageDisenadorService;
import com.upc.miskyclothes.interfaceservice.ImageService;
import com.upc.miskyclothes.repository.DisenadorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/disenadores")
public class DisenadorController {
    @Autowired
    private DisenadorRepository disenadorRepository;
    private DisenadorService disenadorService;
    @Autowired
    private ImageDisenadorService imageDisenadorService;

    @PostMapping("/registrar/{imagedisenadorId}")
    ResponseEntity<DisenadorDTO> register(@RequestBody DisenadorDTO disenadorDTO, @PathVariable(value="imagedisenadorId")Long imagedisenadorId){
        Disenador disenador;
        DisenadorDTO dto;
        try{
            disenador=convertToEntity(disenadorDTO);
            disenador.setImagedisenador(imageDisenadorService.getImageDis(imagedisenadorId));
            disenador=disenadorService.register(disenador);
            dto=convertToDto(disenador);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"tu polo no se registro HUAKO");
        }
        return new ResponseEntity<DisenadorDTO>(dto,HttpStatus.OK);
    }

    @GetMapping("/mostrar")
    public ResponseEntity<List<DisenadorDTO>> listDisenador() {
        List<Disenador> list;
        List<DisenadorDTO> listDTO=null;
        try{
            list=disenadorService.listDisenador();
            listDTO=convertToListDto(list);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Lista no disponible");
        }
        return new ResponseEntity<>(listDTO,HttpStatus.OK);
    }

    @GetMapping("/mostrarid/{prefijo}")
    public List<Disenador> listByName(@PathVariable(value = "prefijo")String prefijo){
        return disenadorService.listByName(prefijo);
    }

    @GetMapping("/mayor-calificacion")
    public ResponseEntity<List<Disenador>> obtenerDisenadorConMayorCalificacion() {
        List<Disenador> disenadores = disenadorRepository.encontrarDisenadorConMayorCalificacion();

        //Disenador diseñadorConMayorCalificacion = diseñadores.
           return new ResponseEntity<>(disenadores, HttpStatus.OK);
    }
    private Disenador convertToEntity(DisenadorDTO disenadorDTO){
        ModelMapper modelMapper=new ModelMapper();
        Disenador post= modelMapper.map(disenadorDTO,Disenador.class);
        return post;
    }

    private DisenadorDTO convertToDto(Disenador disenador){
        ModelMapper modelMapper=new ModelMapper();
        DisenadorDTO disenadorDTO= modelMapper.map(disenador,DisenadorDTO.class);
        return disenadorDTO;
    }


    private List<DisenadorDTO> convertToListDto(List<Disenador> list){
        return list.stream().map(this::convertToDto).collect(Collectors.toList());
    }

}
