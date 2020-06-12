package com.techstack.drools.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Visa {
    private String passportNumber;

    @Override
    public String toString() {
        return "Visa[passport:" + passportNumber + "]";
    }
}
