package org.example.expert.domain.log.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.expert.domain.common.entity.Timestamped;

@Entity
@Getter
@Table(name = "log")
public class LogEntity extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;

    @Column
    private Long managerId;

    @Column
    private Long todoId;

    @Column
    private boolean success;

    @Column
    private String errorMessage;

    public LogEntity() {
    }

    public LogEntity(Long userId, Long managerId, Long todoId) {
        this.userId = userId;
        this.managerId = managerId;
        this.todoId = todoId;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
