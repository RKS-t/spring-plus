package org.example.expert.domain.todo.repository;

import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoRepositoryQuery {

    @EntityGraph(attributePaths = {"user"})
    @Query("SELECT t FROM Todo t " +
            "WHERE t.weather LIKE CONCAT('%', :weather, '%') " +
            "AND t.modifiedAt BETWEEN :startDate AND :endDate " +
            "ORDER BY t.modifiedAt DESC" )
    Page<Todo> findByWeatherAndModifiedAtBetween(
            @Param("weather") String weather,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate,
            Pageable pageable
    );

    @EntityGraph(attributePaths = {"user"})
    Page<Todo> findByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime modifiedAtAfter, LocalDateTime modifiedAtBefore, Pageable pageable);

}
