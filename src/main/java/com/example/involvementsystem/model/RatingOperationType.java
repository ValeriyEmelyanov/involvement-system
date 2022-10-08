package com.example.involvementsystem.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum RatingOperationType {
    DEBIT("Пополнение"),
    CREDIT("Снятие"),
    RESET("Сброс");
    private final String name;

    @Override
    public String toString() {
        return name;
    }
}
