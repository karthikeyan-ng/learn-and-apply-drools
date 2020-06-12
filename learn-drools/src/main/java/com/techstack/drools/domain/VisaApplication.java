package com.techstack.drools.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class VisaApplication {

    private int applicationId;
    private String passportNumber;
    private LocalDate visitStartDate;
    private LocalDate visitEndDate;

    @Builder.Default
    private Validation validation = Validation.UNKNOWN;

    @Override
    public String toString() {
        return "VisaApplication(#" + applicationId + ", pass:" + passportNumber + ")";
    }
}
