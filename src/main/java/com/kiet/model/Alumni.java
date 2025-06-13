package com.kiet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Alumni {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String batch;
	private String company;
	private String contact;
	
	public Alumni() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Alumni(int id, String name, String batch, String company, String contact) {
		super();
		this.id = id;
		this.name = name;
		this.batch = batch;
		this.company = company;
		this.contact = contact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Alumni [id=" + id + ", name=" + name + ", batch=" + batch + ", company=" + company + ", contact="
				+ contact + "]";
	}

	public int getPassingYear() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
