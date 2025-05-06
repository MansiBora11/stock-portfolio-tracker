package com.example.portfolio.controller;

import com.example.portfolio.model.Stock;
import com.example.portfolio.model.User;
import com.example.portfolio.repository.UserRepository;
import com.example.portfolio.service.StockPriceService;
import com.example.portfolio.service.StockService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {
    private StockService stockService;
    private UserRepository userRepository;
    private final StockPriceService stockPriceService;

    public StockController(StockService stockService, UserRepository userRepository, StockPriceService stockPriceService){
        this.stockService = stockService;
        this.userRepository = userRepository;
        this.stockPriceService = stockPriceService;
    }

    @GetMapping
    public List<Stock> getSUserStocks(Authentication authentication){
        String username = authentication.getName();
        User user = userRepository.findByUsername(username);
        return stockService.getStocksByUser(user);
    }

    @GetMapping("/price")
    public Double getStockPrice(@RequestParam String symbol){
        return stockPriceService.getStockPrice(symbol);
    }

    @PostMapping
    public Stock addStock(@RequestBody Stock stock, Authentication authentication) {
        String username = authentication.getName();
        User user = userRepository.findByUsername(username);
        return stockService.addStock(user, stock);
    }

    @DeleteMapping("/{id}")
    public String deleteStock(@PathVariable Long id, Authentication authentication){
        String username = authentication.getName();
        User user = userRepository.findByUsername(username);
        stockService.deleteStock(id);
        return "Stock deleted successfully.";
    }
}
