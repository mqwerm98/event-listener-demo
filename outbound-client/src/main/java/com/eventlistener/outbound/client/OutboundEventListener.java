package com.eventlistener.outbound.client;

import com.eventlistener.outbound.service.OutboundService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OutboundEventListener {

    private final OutboundService outboundService;

    @EventListener
    public void handle(OutboundPayload.OutboundRunDto outboundRunDto) {
        outboundService.run(outboundRunDto.getOutboundNumber(), outboundRunDto.getAccountName(), outboundRunDto.getStockNumber());

    }
}