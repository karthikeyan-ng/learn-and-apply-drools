package com.techstack.drools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Common {

    public static int promptForStep(int section, String[] args, int minStep, int maxStep) {
        String stepStr = "";

        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                if (args != null && args.length > 0) {
                    stepStr = args[0];
                    return Integer.parseInt(stepStr);
                }
                else {
                    System.out.print(String.format("Section %d. Enter step (%d...%d): ", section, minStep, maxStep));
                    stepStr = br.readLine();
                }

                int step = Integer.parseInt(stepStr);

                if (step < minStep || step > maxStep) {
                    System.out.println("Step number out of range. Insert a number between " + minStep + " and " + maxStep);
                }
                else {
                    return step;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid number: " + stepStr);
            }
            catch (IOException e) {
                System.out.println("Invalid step input: " + stepStr);
            }
        }

    }


    public static boolean promptForYesNoQuestion(String question) {
        String enteredStr = "";

        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.print(String.format("%s Enter 'yes' or 'no': ", question));
                enteredStr = br.readLine().trim();

                if ("yes".equalsIgnoreCase(enteredStr) || "y".equalsIgnoreCase(enteredStr)) {
                    return true;
                }

                if ("no".equalsIgnoreCase(enteredStr) || "n".equalsIgnoreCase(enteredStr)) {
                    return false;
                }

                System.out.println("Enter either 'yes' or 'no'");
            }
            catch (IOException e) {
                System.out.println("Invalid input: " + enteredStr);
            }
        }

    }
}
