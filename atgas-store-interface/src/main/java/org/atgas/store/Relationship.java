package org.atgas.store;

import java.io.Serializable;

public final class Relationship implements Serializable {
	private static final long serialVersionUID = -4894006792762785606L;
	
	public final String kind;
	public final String sourceID;
	public final String targetID;
	
	public Relationship(String kind, String sourceID, String targetID) {
		this.kind = kind;
		this.sourceID = sourceID;
		this.targetID = targetID;
	}
	
	public Relationship(String kind, Thing source, Thing target) {
		this.kind = kind;
		this.sourceID = source.getId();
		this.targetID = target.getId();
	}
	
}
