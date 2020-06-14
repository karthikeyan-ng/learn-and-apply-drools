package com.techstack.drools.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
public class FamilyVisaApplication {

    private int applicationId;
    private List<String> passportNumbers = new ArrayList<>();
    private LocalDate visitStartDate;
    private LocalDate visitEndDate;

    private Boolean validationPassed = null;

    public static String join(Collection<String> collection) {
        return collection
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));
    }

    @Override
    public String toString() {
        return String.format("FamilyVisaApplication[#%d, %s]", applicationId, join(passportNumbers));
    }
}
