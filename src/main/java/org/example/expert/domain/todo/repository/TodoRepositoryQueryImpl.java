package org.example.expert.domain.todo.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.expert.domain.comment.entity.QComment;
import org.example.expert.domain.manager.entity.QManager;
import org.example.expert.domain.todo.dto.response.TodoListResponseDto;
import org.example.expert.domain.todo.entity.QTodo;
import org.example.expert.domain.todo.entity.Todo;
import org.example.expert.domain.user.entity.QUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.expression.spel.ast.Projection;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class TodoRepositoryQueryImpl implements TodoRepositoryQuery{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<Todo> findTodoByIdWithUser(Long todoId) {

        QTodo todo = QTodo.todo;
        QUser user = QUser.user;

        return Optional.ofNullable(jpaQueryFactory.select(todo)
                .from(todo)
                .join(todo.user, user).fetchJoin()
                .where(todo.id.eq(todoId))
                .fetchOne());
    }

    @Override
    public Page<TodoListResponseDto> findTodoByKeyword(String titleKeyword, String nicknameKeyword, Pageable pageable) {

        QTodo todo = QTodo.todo;
        QUser user = QUser.user;
        QManager manager = QManager.manager;
        QComment comment = QComment.comment;

        BooleanBuilder builder = new BooleanBuilder();

        if (titleKeyword != null && !titleKeyword.isBlank()) {
            builder.and(todo.title.contains(titleKeyword));
        }
        if (nicknameKeyword != null && !nicknameKeyword.isBlank()) {
            builder.and(todo.user.nickname.contains(nicknameKeyword));
        }

        List<TodoListResponseDto> todoList = jpaQueryFactory
                .select(Projections.constructor(TodoListResponseDto.class,
                        todo.id,
                        todo.title,
                        comment.count(),
                        manager.count(),
                        todo.user.nickname,
                        todo.createdAt,
                        todo.modifiedAt
                ))
                .from(todo)
                .leftJoin(todo.comments, comment)
                .leftJoin(todo.managers, manager)
                .leftJoin(todo.user, user)
                .where(builder)
                .groupBy(todo.id, todo.user.nickname, todo.title, todo.createdAt, todo.modifiedAt)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(todo.createdAt.desc())
                .fetch();

        Long totalCount = jpaQueryFactory
                .select(todo.countDistinct())
                .from(todo)
                .leftJoin(todo.user, user)
                .where(builder)
                .fetchOne();

        return new PageImpl<>(todoList, pageable, totalCount != null ? totalCount : 0);
    }


}
