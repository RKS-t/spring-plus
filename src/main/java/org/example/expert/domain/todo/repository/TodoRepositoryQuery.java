package org.example.expert.domain.todo.repository;

import org.example.expert.domain.todo.entity.Todo;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface TodoRepositoryQuery {

    Optional<Todo> findTodoByIdWithUser(Long todoId);
}
