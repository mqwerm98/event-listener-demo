package com.eventlistener.outbound.controller;

import com.eventlistener.core.account.CurrentAccount;
import com.eventlistener.outbound.service.OutboundService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OutboundController {

    private final OutboundService outboundService;

    @GetMapping("/outbound")
    @ResponseStatus(HttpStatus.OK)
    public void outboundRun(@CurrentAccount Account account) {
        String outboundNumber = "123";
        String accountName = "munzi";
        String stockNumber = "321";
        outboundService.run(outboundNumber, accountName, stockNumber);
    }

}
