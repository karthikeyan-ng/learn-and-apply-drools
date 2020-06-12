package com.techstack.drools.validation.agendagroup;

import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.AgendaGroupPoppedEvent;
import org.kie.api.event.rule.AgendaGroupPushedEvent;
import org.kie.api.event.rule.BeforeMatchFiredEvent;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.MatchCancelledEvent;
import org.kie.api.event.rule.MatchCreatedEvent;
import org.kie.api.event.rule.RuleFlowGroupActivatedEvent;
import org.kie.api.event.rule.RuleFlowGroupDeactivatedEvent;

import java.io.PrintStream;

public class AgendaGroupEventListener extends DebugAgendaEventListener {

    private PrintStream stream;

    public AgendaGroupEventListener() {
        super();
    }

    public AgendaGroupEventListener(PrintStream stream) {
        super(stream);
        this.stream = stream;
    }

    @Override
    public void matchCancelled(MatchCancelledEvent event) {
        //super.matchCancelled(event);
    }

    @Override
    public void matchCreated(MatchCreatedEvent event) {
        //super.matchCreated(event);
    }

    @Override
    public void afterMatchFired(AfterMatchFiredEvent event) {
        //super.afterMatchFired(event);
    }

    @Override
    public void agendaGroupPopped(AgendaGroupPoppedEvent event) {
        stream.println("==> " + event.getAgendaGroup() + " popped from stack ");
    }

    @Override
    public void agendaGroupPushed(AgendaGroupPushedEvent event) {
        stream.println("==> " + event.getAgendaGroup() + " pushed to stack ");
    }

    @Override
    public void beforeMatchFired(BeforeMatchFiredEvent event) {
        //super.beforeMatchFired(event);
    }

    @Override
    public void beforeRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
        //super.beforeRuleFlowGroupActivated(event);
    }

    @Override
    public void afterRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
        //super.afterRuleFlowGroupActivated(event);
    }

    @Override
    public void beforeRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent event) {
        //super.beforeRuleFlowGroupDeactivated(event);
    }

    @Override
    public void afterRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent event) {
        //super.afterRuleFlowGroupDeactivated(event);
    }
}

