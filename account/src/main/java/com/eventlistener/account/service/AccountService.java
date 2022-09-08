package com.eventlistener.account.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountService {

    public void run(String accountName) {
        log.info("AccountService run!!! accountName : {}", accountName);
    }

}
