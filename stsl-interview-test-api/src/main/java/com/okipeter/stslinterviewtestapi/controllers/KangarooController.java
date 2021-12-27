package com.okipeter.stslinterviewtestapi.controllers;

import com.okipeter.stslinterviewtestapi.dto.patternDto;
import com.okipeter.stslinterviewtestapi.dto.requestDto;
import com.okipeter.stslinterviewtestapi.dto.responseDto;
import com.okipeter.stslinterviewtestapi.response.JsonResponse;
import com.okipeter.stslinterviewtestapi.services.KangarooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

/**
 * @author Oki-Peter
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class KangarooController {

    @Autowired
    KangarooService kangarooService;

    @PostMapping(path = "/default")
    public ResponseEntity<Object> performOperation(@Valid @RequestBody requestDto requestDto) {

        try {

        responseDto responseDto = new responseDto();

        Boolean check = kangarooService.checkIfPossible(requestDto);

        if(check == false){
            responseDto.setCheck("NO");
            return ResponseEntity.ok(new JsonResponse("See Data Object for Details", responseDto));
        }

        Long numOfJumps = kangarooService.numOfJumpRequired(requestDto);

        ArrayList<patternDto> patternDtos = kangarooService.calculateJumpPattern(requestDto, numOfJumps);

        responseDto.setCheck("YES");
        responseDto.setPatternDtos(patternDtos);

        return ResponseEntity.ok(new JsonResponse("See Data Object for Details", responseDto));

//        return new ResponseEntity<>(new JsonResponse(HttpStatus.OK, "Company Record Not Found: " ), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new JsonResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
