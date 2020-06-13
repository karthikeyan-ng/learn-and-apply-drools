package com.techstack.drools.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InvalidPassport {

    private Passport passport;

    @Override
    public String toString() {
        return "Invalid" + passport;
    }

}
