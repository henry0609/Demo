package com.cheng.drools.test.test1;

import java.util.HashMap;
import java.util.Map;

public class Unit {

	private String name;
	
	private Map<String, TT> tts = new HashMap<String, TT>();

	public String getName() {
		return name; 
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, TT> getTts() {
		return tts;
	}

	public void setTts(Map<String, TT> tts) {
		this.tts = tts;
	}
}
