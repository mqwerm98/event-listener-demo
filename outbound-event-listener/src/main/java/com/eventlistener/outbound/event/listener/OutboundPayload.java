package com.eventlistener.outbound.event.listener;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OutboundPayload {

    @Data
    @AllArgsConstructor
    public static class OutboundRunDto {
        private String outboundNumber;
        private String accountName;
        private String stockNumber;
    }
}
