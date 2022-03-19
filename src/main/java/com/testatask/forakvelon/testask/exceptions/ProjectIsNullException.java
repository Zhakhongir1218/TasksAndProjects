package com.testatask.forakvelon.testask.exceptions;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProjectIsNullException extends RuntimeException {
    String title;
    public ProjectIsNullException(String message, String title) {
        super(message);
        this.title = title;
    }
}
