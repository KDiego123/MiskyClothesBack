package com.upc.miskyclothes.interfaceservice;

import com.upc.miskyclothes.entities.Stock;

import java.util.List;

public interface StockService {
    public Stock register(Stock stock);
    public List<Stock>listStock();
    public Stock updateStock(Stock stock) throws Exception;
    public Stock deleteStock(Long id) throws Exception;
}
