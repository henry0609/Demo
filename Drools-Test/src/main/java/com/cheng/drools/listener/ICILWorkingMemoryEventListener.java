package com.cheng.drools.listener;

import java.util.List;

import org.drools.event.rule.DefaultWorkingMemoryEventListener;
import org.drools.event.rule.ObjectInsertedEvent;
import org.drools.event.rule.ObjectRetractedEvent;
import org.drools.event.rule.ObjectUpdatedEvent;

public class ICILWorkingMemoryEventListener extends DefaultWorkingMemoryEventListener {

	private List<String> list;
	
	private String prefix = "Working Memory Listener:";
	
	public ICILWorkingMemoryEventListener(List<String> list) {
		this.list = list;
	}
	
	public void objectInserted(ObjectInsertedEvent event) {
		list.add(prefix + " [inserted] " + event.getObject());
	}

	public void objectRetracted(ObjectRetractedEvent event) {
		list.add(prefix + " [retracted] " + event.getOldObject());
	}

	public void objectUpdated(ObjectUpdatedEvent event) {
		list.add(prefix + " [updated] " + event.getObject());
	}
}
