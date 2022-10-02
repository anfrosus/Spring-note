package com.example.sparta02hw.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequestDto {

    private String userId;

    private int passWord;

    private String userName;


}
