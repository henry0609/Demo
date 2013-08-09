package com.cheng.drools.listener;

import java.util.List;

import org.drools.event.rule.ActivationCancelledEvent;
import org.drools.event.rule.ActivationCreatedEvent;
import org.drools.event.rule.AfterActivationFiredEvent;
import org.drools.event.rule.AgendaGroupPoppedEvent;
import org.drools.event.rule.AgendaGroupPushedEvent;
import org.drools.event.rule.BeforeActivationFiredEvent;
import org.drools.event.rule.DefaultAgendaEventListener;

public class ICILAgendaEventListener extends DefaultAgendaEventListener {

	private List<String> list;
	
	private String prefix = "Agenda Listener:";
	
	public ICILAgendaEventListener(List<String> list) {
		this.list = list;
	}
	
	public void activationCancelled(ActivationCancelledEvent event) {
		list.add(prefix + " [activation cancelled] " + event.getActivation().getRule().getName());
	}

	public void activationCreated(ActivationCreatedEvent event) {
		list.add(prefix + " [activation created] " + event.getActivation().getRule().getName());
	}

	public void afterActivationFired(AfterActivationFiredEvent event) {
		list.add(prefix + " [after activation fired] " + event.getActivation().getRule().getName());
	}

	public void agendaGroupPopped(AgendaGroupPoppedEvent event) {
		list.add(prefix + " [agenda group popped] " + event.getAgendaGroup().getName());
	}

	public void agendaGroupPushed(AgendaGroupPushedEvent event) {
		list.add(prefix + " [agenda group pushed] " + event.getAgendaGroup().getName());
	}

	public void beforeActivationFired(BeforeActivationFiredEvent event) {
		list.add(prefix + " [before activation fired] " + event.getActivation().getRule().getName());
	}
}
