package com.anapioficeandfire.api.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    private String abbreviation;

    @Override
    public String toString() {
        return abbreviation;
    }
}
