package org.example.expert.domain.user.dto.response;

import lombok.Getter;
import org.example.expert.domain.user.entity.User;

import java.util.List;

@Getter
public class UserResponse {

    private final Long id;
    private final String email;

    public UserResponse(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public static UserResponse toDto(User user){
        return new UserResponse(user.getId(), user.getEmail());
    }
}
