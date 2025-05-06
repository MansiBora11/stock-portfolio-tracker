package com.example.portfolio.repository;

import com.example.portfolio.model.Stock;
import com.example.portfolio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {
    List<Stock> findByUser(User user);

}
