package com.example.sparta02hw.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass       //상속했을 때 컬럼으로 인식 해라
@EntityListeners(AuditingEntityListener.class)      //생성, 수정시간 자동 반영해라
public class TimeStamped {

    @CreatedDate    //생성 일자
    private LocalDateTime createAt;

    @LastModifiedDate       //최종 수정 일자
    private LocalDateTime modifiedAt;
}
