package com.example.sparta02hw.controller;

import com.example.sparta02hw.dto.MemberRequestDto;
import com.example.sparta02hw.entity.MemberEntity;
import com.example.sparta02hw.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor    //반드시 필요한 생성자 생성
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/api/members")
    public List<MemberEntity> getMemberAll() {
        return memberService.readAll();
    }
    @PostMapping("/api/members")
    public Long createMember(@RequestBody MemberRequestDto memberRequestDto){
        return memberService.create(memberRequestDto);
    }

    @PutMapping("/api/members/{id}")        //아이디와 내용 입력받아서 수정하기
    public Long updateMember(@PathVariable Long id, @RequestBody MemberRequestDto memberRequestDto){
        return memberService.update(id, memberRequestDto);
    }


    @DeleteMapping("/api/members/{id}")     //아이디 입력받아 삭제하기
    public Long deleteMember(@PathVariable Long id) {
        return memberService.deleteById(id);
    }

}
