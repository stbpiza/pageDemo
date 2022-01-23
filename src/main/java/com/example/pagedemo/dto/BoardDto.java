package com.example.pagedemo.dto;

import com.example.pagedemo.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BoardDto {

    private Long boardId;

    private String title;

    private Long views;

    private LocalDateTime createTime;

    private Long userId;

    private String nickname;

    public BoardDto(Board board) {
        this.boardId = board.getBoardId();
        this.title = board.getTitle();
        this.views = board.getViews();
        this.createTime = board.getCreateTime();
        this.userId = board.getUser().getUserId();
        this.nickname = board.getUser().getNickname();
    }
}
