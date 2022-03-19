package com.testatask.forakvelon.testask.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ResponseException {
    private String title;
    private String description;
}