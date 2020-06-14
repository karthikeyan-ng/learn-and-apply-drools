## Instructions

Instructions to follow this application code:  
* Refer: package (src and rules) `validation.stateless`
* Refer: package (src and rules) `validation.stateful`
* Refer: package (src and rules) `validation.crossproducts`
* Refer: package (src and rules) `validation.agendagroup`
    - using `salience` (refer step2)
        - is not a good idea if you have a lot of rules, and they keep changing.
        - it is difficult to manage
        - The alternate solution is `agendagroup`. That is more scalable solution.
    - using `agendagroup` (refer step3)
        - Here Agenda is a DataStructure which works Last-In and First-Out (Stack).
        - The Agenda which we added in the agendaGroup first will be executed
        - Last. The execution order is "invalid-passport"..."issue-visa".
        - Finally rules which are not part of "Agenda Group" will be executed at the end after all the Agenda Group rules are executed.
    - using `agendagroup` and `salience` (refer step4)
        - In the previous steps, we had a 5 different agenda groups   
            - invalid Passports
            - valid Passports
            - invalid visa applications
            - valid visa applications
            - issue visa
        - This might have been a bit of overkill.
        - Here in this step4 how we can reduce the number of Agenda Groups to 3 by combining salience with Agenda Group
        - Combining `AgendaGroup` with `Salience` which will work that per group the higher order salience will execute 
        at first and lower order salience will be executed at the last.
    - run a single rule from a `Activation Group` (refer step5)
        - Suppose The Government decided to change the conditions to get visa there is no requirement of physical passport.
        - It's a E-Visa. Hence, after this `date-expires "01-Sep-2018"` no need to validate the passport related rules.
        - Or you could add `enabled false` both can stop trigger the specific rules.
        - Refer `Conclusion.drl` file: There we created two rules which contains `activation-group "conclusion"`.
        However, `activation-group "conclusion"` either one of the rule will be executed at most one.
* Refer: package (src and rules) `validation.logical`  
* Refer: package (src and rules) `validation.group`    