package com.attornatus.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Builder
public class Problem {


    private Integer status;

    @JsonFormat(pattern = "dd/MM/yyyy[ HH:mm:ss]")
    private LocalDateTime timestamp;

    private String type;
    private String title;
    private String detail;
    private String userMessage;
    private List<Field> fields;

    @Getter
    @Builder
    public static class Field {

        private String name;
        private String userMessage;

    }

}
