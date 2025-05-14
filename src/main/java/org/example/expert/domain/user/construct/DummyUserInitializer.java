package org.example.expert.domain.user.construct;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.expert.domain.user.entity.User;
import org.example.expert.domain.user.enums.UserRole;
import org.example.expert.domain.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DummyUserInitializer {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

//    @PostConstruct
//    public void init() {
//        Instant start = Instant.now();
//        int batchSize = 1000000;
//        List<User> batch = new ArrayList<>();
//
//        String encodedPassword = passwordEncoder.encode("password");
//
//        for (int i = 1; i <= 1000000; i++) {
//            batch.add(new User("user" + i + "@test.com", encodedPassword, UserRole.USER, "nick" + i));
//
//            if (i % batchSize == 0) {
//                userRepository.saveAll(batch);
//                userRepository.flush();
//                batch.clear();
//                System.out.println(i + " users inserted.");
//            }
//        }
//        Instant end = Instant.now();
//        System.out.println("전체 소요 시간: " + Duration.between(start, end).toSeconds() + "초");
//    }
}