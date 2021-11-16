package com.bida.casino.royal.service;

import com.bida.casino.royal.domain.Account;
import com.bida.casino.royal.domain.dto.AccountDTO;
import com.bida.casino.royal.domain.dto.ResultDTO;
import com.bida.casino.royal.domain.emun.PlayMode;
import com.bida.casino.royal.exception.BadRequestException;
import com.bida.casino.royal.mapper.AccountMapper;
import com.bida.casino.royal.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private RandomizeService randomizeService;

    public AccountDTO createPlayer(long playerId) {
        if (accountRepository.findAccountById(playerId) == null) {
            Account createdAccount = accountRepository.save(new Account(playerId, 1000));
            return accountMapper.entityToDto(createdAccount);
        }
        throw new BadRequestException("Player with id: " + playerId + " is already exist.");
    }

    public ResultDTO doBet(PlayMode mode, long playerId, int amountOfMoney, long number) {
        Account account = accountRepository.findAccountById(playerId);
        if (account == null) {
            throw new BadRequestException("Player with id: " + playerId + " doesn't exist.");
        }
        if (account.getMoney() < amountOfMoney) {
            throw new BadRequestException("Player with id: " + playerId + " doesn't have enough money.\n " +
                    "Money: " + account.getMoney() + ", Bet: " + amountOfMoney);
        }
        long randomizedNumber = randomizeService.randomize(mode);

        ResultDTO result = new ResultDTO();

        if (randomizedNumber == number) {
            account.setMoney(account.getMoney() - amountOfMoney + (amountOfMoney * 1000));
            result.setMessage("You won this time");
        } else {
            account.setMoney(account.getMoney() - amountOfMoney);
            result.setMessage("You lost this time");
        }
        accountRepository.save(account);

        result.setAccount(accountMapper.entityToDto(account));
        result.setRealNumber(randomizedNumber);

        return result;
    }
}
