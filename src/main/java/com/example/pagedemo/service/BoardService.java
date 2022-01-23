package com.example.pagedemo.service;

import com.example.pagedemo.dto.BoardListDto;
import com.example.pagedemo.entity.Board;
import com.example.pagedemo.repository.BoardQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardQueryRepository boardQueryRepository;

    public ResponseEntity<BoardListDto> getBoardList(Pageable pageable) {

        Page<Board> results = boardQueryRepository.getBoardList(pageable);

        return new ResponseEntity<>(BoardListDto.builder()
                .boardList(results.getContent())
                .totalCount(results.getTotalElements())
                .totalPages((long)results.getTotalPages())
                .build(), HttpStatus.OK);
    }
}
