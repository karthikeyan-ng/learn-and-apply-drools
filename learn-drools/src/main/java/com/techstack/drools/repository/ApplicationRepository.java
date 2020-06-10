package com.techstack.drools.repository;

import com.techstack.drools.domain.FamilyVisaApplication;
import com.techstack.drools.domain.Passport;
import com.techstack.drools.domain.VisaApplication;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class ApplicationRepository {

    public static final String SARAH_PASSPORT_NUMBER = "CA-SARAH-1";
    public static final String SIMON_PASSPORT_NUMBER = "CA-SIMON-2";
    public static final String EMILY_PASSPORT_NUMBER = "AU-EMILY-3";
    public static final String JAMES_PASSPORT_NUMBER = "AU-JAMES-4";

    public static List<Passport> getPassports() {
        Passport sarahMurphy = Passport.builder()
                .passportNumber(SARAH_PASSPORT_NUMBER)
                .name("Sarah Murphy")
                .unusedVisaPages(1)
                .expiresOn(LocalDate.of(2017, Month.DECEMBER, 17))
                .age(50)
                .build();

        Passport simonMurphy = Passport.builder()
                .passportNumber(SIMON_PASSPORT_NUMBER)
                .name("Simon Murphy")
                .unusedVisaPages(0)
                .expiresOn(LocalDate.of(2045, Month.MAY, 11))
                .age(12)
                .build();

        Passport emilyBrown = Passport.builder()
                .passportNumber(EMILY_PASSPORT_NUMBER)
                .name("Emily Brown")
                .unusedVisaPages(20)
                .expiresOn(LocalDate.of(2047, Month.NOVEMBER, 25))
                .age(16)
                .build();

        Passport jamesBrown = Passport.builder()
                .passportNumber(JAMES_PASSPORT_NUMBER)
                .name("James Brown")
                .unusedVisaPages(10)
                .expiresOn(LocalDate.of(2045, Month.APRIL, 10))
                .age(17)
                .build();

        return List.of(sarahMurphy, simonMurphy, emilyBrown, jamesBrown);
    }

}
