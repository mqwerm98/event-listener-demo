package com.eventlistener.stock.event.listener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class StockPayload {

    @Data
    @AllArgsConstructor
    public static class StockRunDto {
        private String stockNumber;
        private String accountName;
    }
}
