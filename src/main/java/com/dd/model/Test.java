package com.dd.model;

import java.util.UUID;

public class Test extends Resource {

	protected String id;

	public Test() {
		super();
		createRef();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private void createRef() {
		UUID uuid = UUID.randomUUID();
		String ref = "/test/" + ((Long) Math.abs(uuid.getMostSignificantBits())).toString();
	}
}
