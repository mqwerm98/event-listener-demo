package com.eventlistener.stock.event.listener;

import com.eventlistener.stock.service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class StockEventListener {
    private final StockService stockService;

    @EventListener
    public void handle(StockPayload.StockRunDto stockRunDto) {
        stockService.run(stockRunDto.getStockNumber(), stockRunDto.getAccountName());
    }

}