package com.dd.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Resource {
	public static final String KEY_LINK_SELF = "self";

	private Map<String, Link> links = new HashMap<String, Link>();
	private Map<String, List<Link>> _linkLists = new HashMap<String, List<Link>>();
	
	private Map<String, Object> _embedded = new HashMap<String, Object>();

	public Map<String, Link> getLinks() {
		return links;
	}

	public void set_Links(Map<String, Link> links) {
		this.links = links;
	}

	public Map<String, Object> get_Embedded() {
		return _embedded;
	}

	public void set_Embedded(Map<String, Object> embedded) {
		this._embedded = embedded;
	}
	
	public Link getLinkByName(String name) {
		return (Link)links.get(name);
	}

	public void addLink(String name, Link link) {
		links.put(name, link);
	}

	
	public List<Link> getLinkLists(String name) {
		return _linkLists.get(name);
	}
	
	public void addLinkLists(String name, List<Link> link) {
		_linkLists.put(name, link);
	}
	
}
