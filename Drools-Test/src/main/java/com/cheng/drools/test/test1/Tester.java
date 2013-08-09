package com.cheng.drools.test.test1;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.FactHandle;

public class Tester {

	private KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
	
	public void loadRules() {
		
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		
		kbuilder.add(ResourceFactory.newClassPathResource("test1/test1.drl"), ResourceType.DRL);
		
		if(kbuilder.hasErrors()) {
			System.out.println(kbuilder.getErrors());
			throw new RuntimeException();
		}
		
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
	}
	
	public StatefulKnowledgeSession getSession() {
		return kbase.newStatefulKnowledgeSession();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		final Object lock = new Object();
		
		Tester tester = new Tester();
		tester.loadRules();
		// ´´½¨session  
		final StatefulKnowledgeSession ksession = tester.getSession();
		
		final Unit unit = new Unit();  
		unit.setName("name");  
		 
		TT tt = new TT();  
		tt.setName("test");  
		unit.getTts().put(tt.getName(), tt);  
		final FactHandle f = ksession.insert(unit);  
//		ksession.insert(unit.getTts());  
		ksession.insert(tt);  
		
//		ksession.fireUntilHalt();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
//				synchronized(lock) {
					while(true) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("thread...");
						ksession.update(f, unit);
						
//						lock.notifyAll();
//						try {
//							lock.wait();
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
					}
				}
//			}
		}).start();
		
		System.out.println("main...");
		ksession.fireUntilHalt();
		
		System.out.println("ha ha...");
	}
}
