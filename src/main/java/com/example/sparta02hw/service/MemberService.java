package com.example.sparta02hw.service;

import com.example.sparta02hw.dto.MemberRequestDto;
import com.example.sparta02hw.entity.MemberEntity;
import com.example.sparta02hw.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long create(MemberRequestDto memberRequestDto){
        memberRepository.save(new MemberEntity(memberRequestDto.getUserId(), memberRequestDto.getPassWord(), memberRequestDto.getUserName()));
        return memberRepository.count();
    }

    @Transactional
    public Long update(Long id, MemberRequestDto memberRequestDto) {
        MemberEntity member1 = memberRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        member1.update(memberRequestDto);
        return member1.getId();
    }

    @Transactional
    public List<MemberEntity> readAll(){
        return  new ArrayList<MemberEntity>(memberRepository.findAll());
    }

    @Transactional
    public Long deleteById(Long id){
        memberRepository.deleteById(id);
        return (id);
    }


//    @Transactional
//    public MemberEntity findById(Long id) {
//        MemberEntity memberEntity = memberRepository.findById(id).orElseThrow(
//                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
//        );
//        return memberEntity;
//    }
}
