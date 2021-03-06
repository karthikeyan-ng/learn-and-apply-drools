package com.techstack.drools.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InvalidVisaApplication {

    private VisaApplication visaApplication;

    @Override
    public String toString() {
        return "Invalid" + visaApplication;
    }

}
