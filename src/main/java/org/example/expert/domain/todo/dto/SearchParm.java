package org.example.expert.domain.todo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SearchParm {

    private int page = 1;
    private int size = 10;
    private String weather;
    private LocalDate startDate;
    private LocalDate endDate;


}
