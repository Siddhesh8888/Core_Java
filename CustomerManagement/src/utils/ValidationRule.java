package utils;
import java.util.List;

import cust_exception.CustomerHandlingException;
import java.time.LocalDate;
import java.time.Period;
import com.app.customer.*;
import java.time.Period;
public class ValidationRule {
	
	//static method to invoke all validation rules
	public static Customer validateAllInput(String firstName, String lastName, String email, String password, double registrationAmount,
			String dob,String plan, String regdate,List<Customer> customers) throws CustomerHandlingException
	{
		
		checkForDuplicate(email, customers);
		LocalDate birthDate=checkForAge(dob);
		LocalDate registration_date=LocalDate.parse(regdate);
		ServicePlan sPlan=checkForPlan(plan, registrationAmount);
		return new Customer(firstName,lastName,email,password,registrationAmount,birthDate,sPlan,registration_date);
	}
	
	
	public static void checkForDuplicate(String email,List<Customer> customerList) throws CustomerHandlingException
	{
		Customer newCustomer=new Customer(email);
			if(customerList.contains(newCustomer))
				throw new CustomerHandlingException("Duplicate record!!");
		System.out.println("No duplicate");
	}
	
	public static LocalDate checkForAge(String birthDate) throws CustomerHandlingException
	{
		LocalDate doj=LocalDate.parse(birthDate);
		int age=Period.between(doj, LocalDate.now()).getYears();
		if(age>21)
			return doj;
		throw new CustomerHandlingException("Your age is less than 21 !!");
	}
	

	
	public static ServicePlan checkForPlan(String servicePlan,double amount) throws CustomerHandlingException,IllegalArgumentException
	{
		ServicePlan plan=ServicePlan.valueOf(servicePlan.toUpperCase());
		if(amount==plan.getPlanCost())
			return plan;
		
		throw new CustomerHandlingException("You entered wrong amount for plan!!!");
	}
	
	//static method customer login
	public static Customer signIn(String userName,String password,List<Customer> customers) throws CustomerHandlingException
	{
		Customer c1=new Customer(userName);
		int index=customers.indexOf(c1);
		if(index==-1)
			throw new CustomerHandlingException("Invalid email");
		if(password.equals(customers.get(index).getPassword()))
		{
			System.out.println("Logging Successful!!!");
			Customer validCustomer=customers.get(index);
			return validCustomer;
		}
		else
			throw new CustomerHandlingException("Invalid Password");
	}
	
	

		
//		if(customers.contains(c1))
//		{
//			int index=customers.indexOf(c1);
//			if(password.equals(customers.get(index).getPassword()))
//			{
//				System.out.println("Logging Successful!!!");
//			}
//			else
//				System.out.println("Invalid Password!!");
//		}
//		else
//			System.out.println("Invalid Email!!");
	}
	
	//alternate method to check plan
//	public static ServicePlan parseAndValidatePlan(String servicePlan) throws IllegalArgumentException
//	{
//	
//			return ServicePlan.valueOf(servicePlan.toUpperCase());
//	}
//	
//	
//	public static void validateRegAmountForPlan(ServicePlan plan,double amount) throws CustomerHandlingException
//	{
//		
//		if(amount!=plan.getPlanCost())
//		throw new CustomerHandlingException("You entered wrong amount for plan!!!");
//	}

//}
