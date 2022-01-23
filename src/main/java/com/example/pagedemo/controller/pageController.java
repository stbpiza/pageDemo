package com.example.pagedemo.controller;

import com.example.pagedemo.dto.BoardListDto;
import com.example.pagedemo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class pageController {

    private final BoardService boardService;


    @GetMapping("/board")
    public ResponseEntity<BoardListDto> getBoardList(Pageable pageable) {

        return boardService.getBoardList(pageable);
    }

}
