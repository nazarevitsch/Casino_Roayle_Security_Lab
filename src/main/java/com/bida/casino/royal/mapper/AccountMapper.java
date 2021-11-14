package com.bida.casino.royal.mapper;

import com.bida.casino.royal.domain.Account;
import com.bida.casino.royal.domain.dto.AccountDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    private final ModelMapper modelMapper;

    public AccountMapper() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public AccountDTO entityToDto(Account account) {
        return modelMapper.map(account, AccountDTO.class);
    }
}
