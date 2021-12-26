package com.okipeter.stslinterviewtestapi.services;

import com.okipeter.stslinterviewtestapi.dto.patternDto;
import com.okipeter.stslinterviewtestapi.dto.requestDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

public interface KangarooService {

    Boolean checkIfPossible(requestDto req);

    Long numOfJumpRequired(requestDto req);

    ArrayList<patternDto> calculateJumpPattern(requestDto req, Long numOfJumps);


}
