package com.example.dockerprac.service;

import com.example.dockerprac.dao.MemoRepository;
import com.example.dockerprac.domain.Memo;
import com.example.dockerprac.dto.request.RequestMemo;
import com.example.dockerprac.dto.response.ResponseMemo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional(readOnly = true)
    public List<ResponseMemo> getMemoList() {
        return memoRepository.findAll().stream()
                .map(Memo::toResponseMemo)
                .toList();
    }

    @Transactional
    public void writeMemo(RequestMemo requestMemo) {
        memoRepository.save(Memo.builder()
                .title(requestMemo.getTitle())
                .content(requestMemo.getContent())
                .build());
    }

}