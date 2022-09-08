package com.eventlistener.account.event.listener;

import com.eventlistener.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AccountEventListener {

    private final AccountService accountService;

    @EventListener
    public void handle(AccountPayload.AccountRunDto accountRunDto) {
        accountService.run(accountRunDto.getAccountName());
    }

}