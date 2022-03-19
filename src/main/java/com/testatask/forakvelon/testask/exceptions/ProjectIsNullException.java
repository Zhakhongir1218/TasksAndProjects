package com.testatask.forakvelon.testask.exceptions;

public class ProjectIsNullException extends Throwable {
    String title;
    public ProjectIsNullException(String message, String title) {
        super(message);
        this.title = title;
    }
}
