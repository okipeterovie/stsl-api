package com.okipeter.stslinterviewtestapi.services;

import com.okipeter.stslinterviewtestapi.dto.patternDto;
import com.okipeter.stslinterviewtestapi.dto.requestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * @author Oki-Peter
 */

@Service
@Transactional
public class KangarooServiceImpl implements KangarooService {

    @Override
    public Boolean checkIfPossible(requestDto req) {
        try {
            if (!((req.getVelocity1() > req.getVelocity2())
                    && (req.getPosition2() > req.getPosition1())
                    && (req.getPosition2() - req.getPosition1()) % (req.getVelocity2() - req.getVelocity1()) == 0)) {
                return false;
            }
            return true;
        }  catch (Exception e){
            throw new IllegalArgumentException("Ran into a problem. Please try again \n" + " Server Error is: " + e.getMessage());
        }
    }

    @Override
    public Long numOfJumpRequired(requestDto req) {

        try {
            Long mod = (req.getPosition2() - req.getPosition1()) / (req.getVelocity2() - req.getVelocity1());
            return Math.abs(mod);
        } catch (Exception e){
            throw new IllegalArgumentException("Ran into a problem. Please try again \n" + " Server Error is: " + e.getMessage());
        }

    }

    @Override
    public ArrayList<patternDto> calculateJumpPattern(requestDto req, Long numOfJumps) {

        try {

            Long position1 = req.getPosition1();

            Long velocity1 = req.getVelocity1();

            Long position2 = req.getPosition2();

            Long velocity2 = req.getVelocity2();

            ArrayList<patternDto> patternDtos = new ArrayList<>();

            for(int i = 0; i <=numOfJumps; i++){


                patternDto patternDto = new patternDto();

                patternDto.setPosition1(position1);
                patternDto.setPosition2(position2);

                position1 = position1 + velocity1;
                position2 = position2 + velocity2;


                patternDtos.add(patternDto);
            }

            return patternDtos;

        } catch (Exception e){
            throw new IllegalArgumentException("Ran into a problem. Please try again \n" + " Server Error is: " + e.getMessage());
        }
    }
}
