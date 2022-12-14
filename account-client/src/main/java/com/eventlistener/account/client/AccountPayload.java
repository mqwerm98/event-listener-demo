package com.eventlistener.account.client;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountPayload {

    @Data
    @AllArgsConstructor
    public static class AccountRunDto {
        private String accountName;
    }
}
