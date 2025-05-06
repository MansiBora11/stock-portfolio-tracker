package com.example.portfolio.service;

import com.example.portfolio.model.Stock;
import com.example.portfolio.model.User;
import com.example.portfolio.repository.StockRepository;
import com.example.portfolio.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
public class StockService {
    private final StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository){
        this.stockRepository = stockRepository;
    }
    public Stock addStock(User user, Stock stock){
        stock.setUser(user);
        return stockRepository.save(stock);
    }

    public List<Stock> getStocksByUser(User user){
        return stockRepository.findByUser(user);
    }

    public void deleteStock(Long stockId) {
        stockRepository.deleteById(stockId);
    }
}


