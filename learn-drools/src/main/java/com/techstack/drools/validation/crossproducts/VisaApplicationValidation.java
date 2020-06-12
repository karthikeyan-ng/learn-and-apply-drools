package com.techstack.drools.validation.crossproducts;

import com.techstack.drools.Common;
import com.techstack.drools.domain.Passport;
import com.techstack.drools.domain.VisaApplication;
import com.techstack.drools.repository.ApplicationRepository;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.List;

public class VisaApplicationValidation {

    public static void main(final String[] args) {
        execute(Common.promptForStep(5, args, 1, 3));
    }

    static void execute(int step) {
        System.out.println("Running step " + step);
        KieContainer kieClasspathContainer = KieServices.Factory.get().getKieClasspathContainer();
        KieSession ksession = kieClasspathContainer.newKieSession("VisaApplicationStep" + step);

        List<Passport> passports = ApplicationRepository.getPassports();
        passports.forEach(ksession::insert);

        List<VisaApplication> visaApplications = ApplicationRepository.getVisaApplications();
        visaApplications.forEach(ksession::insert);

        System.out.println("==== DROOLS SESSION START ==== ");
        ksession.fireAllRules();
        ksession.dispose();
        System.out.println("==== DROOLS SESSION END ==== ");

        System.out.println("==== PASSPORTS AFTER DROOLS SESSION === ");
        passports.forEach(passport -> System.out.println(passport + " verdict: " + passport.getValidation()));

        System.out.println("==== APPLICATIONS STATE AFTER DROOLS SESSION === ");
        visaApplications.forEach(visaApplication ->
                System.out.println(visaApplication + " verdict: " + visaApplication.getValidation())
        );

    }
}
