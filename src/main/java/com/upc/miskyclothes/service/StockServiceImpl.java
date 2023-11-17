package com.upc.miskyclothes.service;

import com.upc.miskyclothes.entities.Stock;
import com.upc.miskyclothes.interfaceservice.StockService;
import com.upc.miskyclothes.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockRepository stockRepository;
    public Stock register(Stock stock){return stockRepository.save(stock);}
    public List<Stock> listStock(){return stockRepository.findAll();}
    public Stock updateStock(Stock stock) throws Exception{
        stockRepository.findById(stock.getId()).orElseThrow(()->new Exception("No se encontro"));
        return stockRepository.save(stock);
    }

    public Stock deleteStock(Long id) throws Exception{
        Stock stock=stockRepository.findById(id).orElseThrow(()->new Exception("No se pudo encontrar usuario"));
        stockRepository.delete(stock);
    return stock;}


}
