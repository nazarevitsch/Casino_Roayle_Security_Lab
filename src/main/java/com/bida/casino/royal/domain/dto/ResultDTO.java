package com.bida.casino.royal.domain.dto;

import lombok.Data;

@Data
public class ResultDTO {

    private AccountDTO account;
    private String message;
    private int realNumber;
}
