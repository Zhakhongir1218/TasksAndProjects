package com.testatask.forakvelon.testask.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskIsNullExeption extends RuntimeException {
    String title;
    public TaskIsNullExeption(String message, String title) {
        super(message);
        this.title = title;
    }
}
