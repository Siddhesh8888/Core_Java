package com.app.customer;

public enum ServicePlan {
	
	SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000);

	private double planCost;
	
	
	private ServicePlan(double planCost) {
		this.planCost=planCost;
	}
	
	
	public double getPlanCost() {
		return planCost;
	}

	@Override
	public String toString()
	{
		return name()+" Cost"+this.planCost;
	}
}
