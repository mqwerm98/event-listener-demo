package com.eventlistener.stock.service;

import com.eventlistener.account.event.listener.AccountPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class StockService {

    private final ApplicationEventPublisher publisher;

    public void run(String stockNumber, String accountName) {
        log.info("StockService run!!! stockNumber : {}", stockNumber);
        publisher.publishEvent(new AccountPayload.AccountRunDto(accountName));
    }

}
