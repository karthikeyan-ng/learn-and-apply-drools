package com.techstack.drools.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InvalidFamilyVisaApplication {

    private FamilyVisaApplication familyVisaApplication;

    @Override
    public String toString() {
        return "Invalid:" + familyVisaApplication;
    }

}
