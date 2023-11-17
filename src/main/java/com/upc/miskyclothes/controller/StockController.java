package com.upc.miskyclothes.controller;

import com.upc.miskyclothes.dtos.StockDTO;
import com.upc.miskyclothes.entities.Stock;
import com.upc.miskyclothes.interfaceservice.StockService;
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
public class StockController {
    @Autowired

    private StockService stockService;
    @PostMapping("/stock")
    ResponseEntity<StockDTO> register(@RequestBody StockDTO stockDTO){
        Stock stock;
        StockDTO dto;
        try {
            stock=convertToEntity(stockDTO);
            stock=stockService.register(stock);
            dto=convertToDto(stock);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se ha podido conectar");
        }return  new ResponseEntity<StockDTO>(dto,HttpStatus.OK);
    }

    @GetMapping("/stocks")
    public ResponseEntity<List<StockDTO>>listStocks(){
        List<Stock> list;
        List<StockDTO>listDTO=null;
        try{
            list=stockService.listStock();
            listDTO=convertToListDto(list);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Lista no dispinoble");
        }return new ResponseEntity<>(listDTO,HttpStatus.OK);
    }

    @PutMapping("/stock")
    public ResponseEntity<Stock>updateStock(@RequestBody Stock stock){
        Stock stock1;
        try{
            stock1=stockService.updateStock(stock);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se pudo actulizar");
        }return new ResponseEntity<Stock>(stock1,HttpStatus.OK);
    }

    private Stock convertToEntity(StockDTO stockDTO){
        ModelMapper modelMapper=new ModelMapper();
        Stock post=modelMapper.map(stockDTO,Stock.class);
        return post;
    }

    private StockDTO convertToDto(Stock stock){
        ModelMapper modelMapper=new ModelMapper();
        StockDTO stockDTO=modelMapper.map(stock,StockDTO.class);
        return stockDTO;
    }

    private List<StockDTO> convertToListDto(List<Stock>list){
        return list.stream().map(this::convertToDto).collect(Collectors.toList());
    }

}
