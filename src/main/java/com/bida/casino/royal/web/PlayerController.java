package com.bida.casino.royal.web;

import com.bida.casino.royal.domain.dto.AccountDTO;
import com.bida.casino.royal.domain.dto.ResultDTO;
import com.bida.casino.royal.domain.emun.PlayMode;
import com.bida.casino.royal.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/createacc")
    public ResponseEntity<AccountDTO> createAccount(@RequestParam("id") long id) {
        return new ResponseEntity<>(playerService.createPlayer(id), HttpStatus.OK);
    }

    @GetMapping("/play/{Mode}")
    public ResponseEntity<ResultDTO> doBet(@PathVariable("Mode") PlayMode mode,
                                           @RequestParam("id") long id,
                                           @RequestParam("bet") int amountOfMoney,
                                           @RequestParam("number") int number) {
        return new ResponseEntity<>(playerService.doBet(mode, id, amountOfMoney, number), HttpStatus.OK);
    }
}
