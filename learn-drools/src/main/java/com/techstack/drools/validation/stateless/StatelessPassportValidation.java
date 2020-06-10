package com.techstack.drools.validation.stateless;

import com.techstack.drools.Common;
import com.techstack.drools.domain.Passport;
import com.techstack.drools.repository.ApplicationRepository;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

import java.util.List;

public class StatelessPassportValidation {

    public static void main(final String[] args) {
        execute(Common.promptForStep(3, args, 1, 6));
    }

    static void execute(int step) {
        System.out.println("Running step " + step);

        List<Passport> passports = ApplicationRepository.getPassports();

        KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();
        StatelessKieSession kieSession = kieContainer.newStatelessKieSession("StatelessPassportValidationStep" + step);
        System.out.println("==== DROOLS SESSION START ==== ");
        kieSession.execute(passports);
        System.out.println("==== DROOLS SESSION END ==== ");

        if (step >= 4) {
            System.out.println("==== PASSPORTS AFTER DROOLS SESSION ==== ");

            passports.forEach(passport -> System.out.println(passport + " validation " + passport.getValidation()));

        }

    }
}
