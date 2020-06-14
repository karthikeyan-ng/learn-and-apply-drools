package com.techstack.drools.validation.group;

import com.techstack.drools.Common;
import com.techstack.drools.domain.FamilyVisaApplication;
import com.techstack.drools.domain.GroupLeader;
import com.techstack.drools.domain.InvalidFamilyVisaApplication;
import com.techstack.drools.domain.Passport;
import com.techstack.drools.domain.Visa;
import com.techstack.drools.repository.ApplicationRepository;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

import java.util.Collection;
import java.util.List;

public class FamilyVisaApplicationValidation {

    public static void main(final String[] args) {
        execute(Common.promptForStep(8, args, 1, 5));
    }

    static void execute(int step) {
        System.out.println("Running step " + step);
        KieSession ksession = KieServices.Factory.get().getKieClasspathContainer().newKieSession("FamilyVisaApplicationStep" + step);

        List<Passport> passports = ApplicationRepository.getPassports();
        passports.forEach(ksession::insert);

        if (step == 3) {
            if (Common.promptForYesNoQuestion("Do you want to make everyone 3 years younger?")) {
                System.out.println("Making everyone 3 years younger");
                passports.forEach(passport -> passport.setAge(passport.getAge()-3));
                passports.forEach(passport -> System.out.println(passport + " is now " + passport.getAge()));
            }
        }

        List<FamilyVisaApplication> familyVisaApplications = ApplicationRepository.getFamilyVisaApplications();
        familyVisaApplications.forEach(ksession::insert);

        System.out.println("==== DROOLS SESSION START ==== ");
        ksession.fireAllRules();
        ksession.dispose();
        System.out.println("==== DROOLS SESSION END ==== ");

        System.out.println("==== INVALID FAMILY VISA APPLICATIONS FROM DROOLS SESSION === ");
        Collection<?> invalidApplications = ksession.getObjects(o -> o.getClass() == InvalidFamilyVisaApplication.class);
        invalidApplications.forEach(System.out::println);

        Collection<?> visas = ksession.getObjects(o -> o.getClass() == Visa.class);
        System.out.println("== Visas from session == ");
        visas.forEach(System.out::println);

        Collection<?> groupLeaders = ksession.getObjects(o -> o.getClass() == GroupLeader.class);
        System.out.println("== Group leaders from session == ");
        groupLeaders.forEach(System.out::println);

    }
}
