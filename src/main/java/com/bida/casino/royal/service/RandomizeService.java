package com.bida.casino.royal.service;

import com.bida.casino.royal.domain.emun.PlayMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RandomizeService {

    @Autowired
    private MersenneTwisterRandomizer mersenneTwisterRandomizer;

    public int randomize(PlayMode mode){

        return (int) (Math.random() * 5);
    }
}
