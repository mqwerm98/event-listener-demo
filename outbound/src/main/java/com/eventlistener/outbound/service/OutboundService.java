package com.eventlistener.outbound.service;

import com.eventlistener.account.client.AccountPayload;
import com.eventlistener.stock.client.StockPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OutboundService {

    private final ApplicationEventPublisher publisher;

    public void run(String outboundNumber, String accountName, String stockNumber) {
        log.info("OutboundService run!!! outboundNumber : {}", outboundNumber);
        publisher.publishEvent(new AccountPayload.AccountRunDto(accountName));
        publisher.publishEvent(new StockPayload.StockRunDto(stockNumber, accountName));
    }

}
