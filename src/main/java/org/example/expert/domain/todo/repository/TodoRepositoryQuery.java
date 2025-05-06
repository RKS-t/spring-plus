package org.example.expert.domain.todo.repository;

import org.example.expert.domain.todo.dto.response.TodoListResponseDto;
import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface TodoRepositoryQuery {

    Optional<Todo> findTodoByIdWithUser(Long todoId);

    Page<TodoListResponseDto> findTodoByKeyword(String titleKeyword, String nicknameKeyword, Pageable pageable);
}
