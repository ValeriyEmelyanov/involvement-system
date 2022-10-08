package com.example.involvementsystem.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TaskStatus {

    DRAFT("Черновик"),
    PLAN("План"),
    PROCESSING("Выполняется"),
    DONE("Выполнено"),
    CANCELLED("Отменено");
    private final String name;

    @Override
    public String toString() {
        return name;
    }
}
