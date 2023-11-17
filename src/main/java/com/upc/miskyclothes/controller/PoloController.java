package com.upc.miskyclothes.controller;

import com.upc.miskyclothes.dtos.PedidoDTO;
import com.upc.miskyclothes.dtos.PoloDTO;
import com.upc.miskyclothes.entities.Polo;
import com.upc.miskyclothes.interfaceservice.ImageService;
import com.upc.miskyclothes.interfaceservice.PoloService;
import com.upc.miskyclothes.repository.PoloRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/polos")
public class PoloController {
    @Autowired
    private PoloService poloService;
    private PoloRepository poloRepository;
    @Autowired
    private ImageService imageService;
    @PostMapping("/registrar/{imageId}")
    ResponseEntity<PoloDTO> register(@RequestBody PoloDTO poloDTO, @PathVariable(value="imageId")Long imageId){
        Polo polo;
        PoloDTO dto;
        try{
            polo=convertToEntity(poloDTO);
            polo.setImage(imageService.getImage(imageId));
            polo=poloService.register(polo);
            dto=convertToDto(polo);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se ha podido registrar");
        }
        return new ResponseEntity<PoloDTO>(dto,HttpStatus.OK);
    }
    @GetMapping("/mostrar")
    public ResponseEntity<List<PoloDTO>>listPolos(){
        List<Polo> list;
        List<PoloDTO> listDTO=null;
        try{
            list=poloService.listPolos();
            listDTO=convertToListDto(list);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Lista no disponible");
        }
        return new ResponseEntity<>(listDTO,HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Polo>updatePolo(@RequestBody Polo polo){
        Polo polo1;
        try{
            polo1=poloService.updatePolo(polo);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede actualizar");
        }
        return new ResponseEntity<Polo>(polo1,HttpStatus.OK);

}

    @GetMapping("/mostrarid/{prefijo}")
    public List<Polo> listByName(@PathVariable(value = "prefijo")String prefijo){
        return poloService.listByName(prefijo);
}

@DeleteMapping("/eliminarporid/{id}")
Polo delete(@PathVariable(value = "id")Long id){
        Polo polo;
        try {
            polo=poloService.deletePolo(id);

        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede eliminar");
        }
        return polo;
        }

    @GetMapping("/buscar-por-modelo")
    public ResponseEntity<List<Polo>> buscarPorModelo(@RequestParam String modelo) {
        List<Polo> polos = poloRepository.findByModelo(modelo);
        return ResponseEntity.ok(polos);
    }

    @GetMapping("/buscar-por-talla")
    public ResponseEntity<List<Polo>> buscarPorTalla(@RequestParam String talla) {
        List<Polo> polos = poloRepository.findByTalla(talla);
        return ResponseEntity.ok(polos);
    }

    @GetMapping("/buscar-por-color")
    public ResponseEntity<List<Polo>> buscarPorColor(@RequestParam String color) {
        List<Polo> polos = poloRepository.findByColor(color);
        return ResponseEntity.ok(polos);
    }

    @GetMapping("/buscar-por-precio")
    public ResponseEntity<List<Polo>> buscarPorPrecio(@RequestParam long precio) {
        List<Polo> polos = poloRepository.findByPrecio(precio);
        return ResponseEntity.ok(polos);
    }


        private Polo convertToEntity(PoloDTO poloDTO){
            ModelMapper modelMapper=new ModelMapper();
            Polo post= modelMapper.map(poloDTO,Polo.class);
            return post;
        }

        private PoloDTO convertToDto(Polo polo){
        ModelMapper modelMapper=new ModelMapper();
        PoloDTO poloDTO= modelMapper.map(polo,PoloDTO.class);
        return poloDTO;
        }

        private List<PoloDTO> convertToListDto(List<Polo> list){
        return list.stream().map(this::convertToDto).collect(Collectors.toList());
        }


    @GetMapping("/searchByPrice")
    public List<Polo> findByPriceRange(@RequestParam long minPrice, @RequestParam long maxPrice) {
        return poloService.findByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/favoritos")
    public List<Polo> listarFavoritos() {
        return poloService.findFavoritos();
    }

}
