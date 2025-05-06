package org.example.expert.domain.todo.dto.response;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoListResponseDto {

    private final Long todoId;
    private final String title;
    private final Long commentCount;
    private final Long managerCount;
    private final String nickname;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public TodoListResponseDto(
            Long todoId,
            String title,
            Long commentCount,
            Long managerCount,
            String nickname,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt) {
        this.todoId = todoId;
        this.title = title;
        this.commentCount = commentCount;
        this.managerCount = managerCount;
        this.nickname = nickname;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
