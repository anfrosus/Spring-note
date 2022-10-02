package com.example.sparta02hw.entity;

import com.example.sparta02hw.dto.MemberRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private int passWord;

    @Column(nullable = false)
    private String userName;

    public MemberEntity(String userId, int passWord, String userName) {
        this.userId = userId;
        this.passWord = passWord;
        this.userName = userName;
    }

    public MemberEntity(MemberRequestDto memberRequestDto){
        this.userId = memberRequestDto.getUserId();
        this.passWord = memberRequestDto.getPassWord();
        this.userName = memberRequestDto.getUserName();
    }

    public void update (MemberRequestDto memberRequestDto){
        this.userId = memberRequestDto.getUserId();
        this.userName = memberRequestDto.getUserName();
        this.passWord = memberRequestDto.getPassWord();
    }

}
