package com.bida.casino.royal.service;

import com.bida.casino.royal.domain.emun.PlayMode;
import org.springframework.stereotype.Service;

@Service
public class RandomizeService {

    private MersenneTwisterRandomizer mersenneTwisterRandomizer;
    private MersenneTwisterRandomizer mersenneTwisterRandomizerBetter;
    private LcgRandomizer lcgRandomizer;

    public RandomizeService(){
        mersenneTwisterRandomizer = new MersenneTwisterRandomizer(PlayMode.Mt);
        mersenneTwisterRandomizerBetter = new MersenneTwisterRandomizer(PlayMode.BetterMt);
        lcgRandomizer = new LcgRandomizer();
    }

    public long randomize(PlayMode mode){
        if (mode == PlayMode.Lcg) {
            return lcgRandomizer.getNumber();
        }
        if (mode == PlayMode.Mt) {
            return mersenneTwisterRandomizer.getRandomNumber();
        } else {
            return mersenneTwisterRandomizerBetter.getRandomNumber();
        }
    }
}
