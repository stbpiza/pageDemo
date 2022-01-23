package com.example.pagedemo.repository;

import com.example.pagedemo.entity.Board;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;

import static com.example.pagedemo.entity.QBoard.board;
import static com.example.pagedemo.entity.QUser.user;

@Repository
public class BoardQueryRepository {

    private final EntityManager em;
    private final JPAQueryFactory query;

    public BoardQueryRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    public Page<Board> getBoardList(Pageable pageable) {
        QueryResults<Board> results = query
                .selectFrom(board)
                .leftJoin(board.user, user).fetchJoin()
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(board.boardId.desc())
                .fetchResults();

        List<Board> content = results.getResults();
        Long total = results.getTotal();

        return new PageImpl<>(content, pageable, total);
    }

}
