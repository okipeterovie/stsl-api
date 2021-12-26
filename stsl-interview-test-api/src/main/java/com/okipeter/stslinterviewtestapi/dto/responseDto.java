package com.okipeter.stslinterviewtestapi.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class responseDto {

    String check;

    ArrayList<patternDto> patternDtos;
}
