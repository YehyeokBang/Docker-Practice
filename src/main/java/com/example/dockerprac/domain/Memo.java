package com.example.dockerprac.domain;

import com.example.dockerprac.dto.response.ResponseMemo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    public ResponseMemo toResponseMemo() {
        return ResponseMemo.builder()
                .id(this.id)
                .title(this.title)
                .content(this.content)
                .build();
    }

}