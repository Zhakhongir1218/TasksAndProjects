package com.testatask.forakvelon.testask.exceptions;

public class TaskIsNullExeption extends Throwable {
    String title;
    public TaskIsNullExeption(String message, String title) {
        super(message);
        this.title = title;
    }
}
