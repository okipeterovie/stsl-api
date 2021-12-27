package com.okipeter.stslinterviewtestapi.dto;

import lombok.Data;

import java.util.ArrayList;

/**
 * @author Oki-Peter
 */

@Data
public class responseDto {

    String check;

    ArrayList<patternDto> patternDtos;
}
