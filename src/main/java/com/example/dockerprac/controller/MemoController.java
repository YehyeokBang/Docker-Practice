package com.example.dockerprac.controller;

import com.example.dockerprac.dto.request.RequestMemo;
import com.example.dockerprac.dto.response.ResponseMemo;
import com.example.dockerprac.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("memo")
public class MemoController {

    private final MemoService memoService;

    @GetMapping("list")
    public ResponseEntity<List<ResponseMemo>> getMemoList() {
        return ResponseEntity.ok(memoService.getMemoList());
    }

    @PostMapping("write")
    public ResponseEntity<String> writeMemo(@RequestBody RequestMemo requestMemo) {
        memoService.writeMemo(requestMemo);
        return ResponseEntity.ok("작성 완료");
    }

}