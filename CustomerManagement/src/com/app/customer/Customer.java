package com.app.customer;

import java.time.LocalDate;

public class Customer implements Comparable<Customer>{
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double registrationAmount;
	private LocalDate dob;
	private ServicePlan plan;
	private LocalDate registrationDate;
	private static int idGenerator;
	
	//constructor
	public Customer(String firstName, String lastName, String email, String password, double registrationAmount,
			LocalDate dob, ServicePlan plan,LocalDate registrationDate) {
		super();
		this.id = ++idGenerator;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.dob = dob;
		this.plan = plan;
		this.registrationDate=registrationDate;
	}
	
	//constructor
	public Customer(String email)
	{
		this.email=email;
	}


	//getter/setter
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public ServicePlan getPlan() {
		return plan;
	}

	public void setPlan(ServicePlan plan) {
		this.plan = plan;
	}
	
	public double getRegistrationAmount() {
		return registrationAmount;
	}
	
	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	
	@Override
	public int compareTo(Customer c)
	{
		return this.email.compareTo(c.email);
	}

	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Customer)
			return this.email.equals(((Customer)o).email);
		return false;
	}
	


	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", registrationAmount=" + registrationAmount + ", dob=" + dob + ", plan="
				+ plan + "]";
	}

	
	}
	
	
	
	
	

