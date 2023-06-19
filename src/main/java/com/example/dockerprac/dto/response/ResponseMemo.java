package com.example.dockerprac.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseMemo {

    private Long id;

    private String title;

    private String content;

}