package com.example.portfolio.service;

import com.example.portfolio.dto.StockPriceResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockPriceService {
    private final RestTemplate restTemplate = new RestTemplate();

    public Double getStockPrice(String symbol){
        String apiKey = "BivJj9Md6Y03r0tADMkjBlVaHOFul13q";
        String url = "https://financialmodelingprep.com/api/v3/quote/"+symbol+"?apikey="+apiKey;

        try {
            StockPriceResponse[] response = restTemplate.getForObject(url, StockPriceResponse[].class);
            if (response != null && response.length > 0) {
                return response[0].getPrice();
            }
        }catch(Exception e){
            e.printStackTrace();
        }


        return null;
        }
    }

