package com.anapioficeandfire.api.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BookMediaType {
    HARDCOVER("Hardcover"),
    PDF("PDF");

    private String displayName;

    @Override
    public String toString() {
        return displayName;
    }

    public static BookMediaType fromDisplayName(String displayName) {
        return switch (displayName) {
            case "Hardcover" -> HARDCOVER;
            case "PDF"       -> PDF;
            default          -> null;
        };
    }
}
