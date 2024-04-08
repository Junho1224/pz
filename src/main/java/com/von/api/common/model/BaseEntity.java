package com.von.api.common.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass
@EntityListeners(value = {})
@Getter
public class BaseEntity {

    @CreatedDate
    @Column(name = "reg_date", updatable = false) //ture가 디폴트
    private LocalDateTime regDate;


    @LastModifiedDate
    @Column(name = "mod_date")
    private LocalDateTime modDate;

}
