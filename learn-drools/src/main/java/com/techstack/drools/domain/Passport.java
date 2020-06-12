package com.techstack.drools.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class Passport {
    private String passportNumber;
    private String name;
    private LocalDate expiresOn;
    private int unusedVisaPages;
    private int age;

    @Builder.Default
    private Validation validation = Validation.UNKNOWN;

    private String cause = "";

    //------ Reusable Business Methods -----

    public boolean isExpired() {
        return expiresOn.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return String.format("Passport[no:%s, name:%s]", passportNumber, name);
    }
}
