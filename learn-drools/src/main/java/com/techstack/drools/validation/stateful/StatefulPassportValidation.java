package com.techstack.drools.validation.stateful;

import com.techstack.drools.Common;
import com.techstack.drools.domain.Passport;
import com.techstack.drools.repository.ApplicationRepository;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.List;

public class StatefulPassportValidation {

    public static void main(final String[] args) {
        execute(Common.promptForStep(4, args, 1, 2));
    }

    static void execute(int step) {
        System.out.println("Running step " + step);
        KieContainer kieClasspathContainer = KieServices.Factory.get().getKieClasspathContainer();

        //Step1: For stateful sessions, we have to create a newKieSession
        KieSession ksession = kieClasspathContainer.newKieSession("StatefulPassportValidationStep" + step);

        List<Passport> passports = ApplicationRepository.getPassports();

        //Step2: You have to insert all your domain objects in to KieSession
        passports.forEach(ksession::insert);

        System.out.println("==== DROOLS SESSION START ==== ");
        ksession.fireAllRules();

        //Step3: Don't forget to call dispose() to cleanup the session
        ksession.dispose();
        System.out.println("==== DROOLS SESSION END ==== ");

        System.out.println("==== PASSPORTS AFTER DROOLS SESSION === ");
        passports.forEach(passport -> {
            System.out.println(passport + " verdict: " + passport.getValidation() + ", cause: " + passport.getCause());
        });


    }
}
