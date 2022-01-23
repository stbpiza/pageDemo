package com.example.pagedemo.dto;

import com.example.pagedemo.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class BoardListDto {

    private List<BoardDto> boardDtoList = new ArrayList<>();

    private Long totalPages;

    private Long totalCount;


    @Builder
    public BoardListDto(List<Board> boardList, Long totalPages, Long totalCount) {
        this.boardDtoList = boardList.stream()
                .map(BoardDto::new).collect(Collectors.toList());
        this.totalPages = totalPages;
        this.totalCount = totalCount;
    }

}
