package com.techstack.drools.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class GroupLeader {

    @Getter
    private Passport passport;
    private FamilyVisaApplication familyVisaApplication;

    @Override
    public String toString() {
        return "Visa Application #"+ familyVisaApplication.getApplicationId() + " group leader is " + passport.getName();
    }
}
