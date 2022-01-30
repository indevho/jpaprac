package jpabook.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Team {
	@Id
	@Column(name = "TEAM_ID")
	private String id;
	
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Team() {
		// TODO Auto-generated constructor stub
	}

	public Team(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}
