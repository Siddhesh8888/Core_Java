package tester;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.app.customer.*;


import static utils.ValidationRule.*;
public class CustomerManagement {

	public static void main(String[] args) {

		try(Scanner sc=new Scanner(System.in))
		{
			ArrayList<Customer> customers=new ArrayList<>();
			boolean exit=false;
			
			while(!exit)
			{
				System.out.println("1.Sign up  2.Sign in  3.Change password  4.Un subscribe customer  5.Display all customers. 6.sort as per E-mail  7.sort as per DOJ  8.remove account who's subscribe date greater than 3 year");
				System.out.println("Enter choice: ");
				
				try
				{
					switch(sc.nextInt())
					{
					
						case 1:
							
							System.out.println("Enter First_name Last_name Email Password Registration_Amount Date_of_Birth Service_Plan Registration_Date");
							Customer newCustomer=validateAllInput(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next(),sc.next(),customers);
							customers.add(newCustomer);
							break;	
							
						case 2:
							System.out.println("Log in");
							System.out.println("Enter Username(email) && Password: ");
							Customer validCustomer= signIn(sc.next(),sc.next(),customers);
							break;	
							
						case 3:
							System.out.println("Log in");
							System.out.println("Enter Username(email) && Password: ");
							Customer validateCustomer= signIn(sc.next(),sc.next(),customers);
							System.out.println("Enter New-Password: ");
							validateCustomer.setPassword(sc.next());
							System.out.println("Password updated Successfully");
							break;	
							
						case 4:
							System.out.println("Log in");
							System.out.println("Enter Username(email) && Password: ");
							Customer cust= signIn(sc.next(),sc.next(),customers);
							customers.remove(cust);
							System.out.println("Unsubscribed!!");
							break;	
								
						case 5:
							for(Customer c:customers)
							{
								System.out.println(c);
							}
							break;	
							
						case 6:
							Collections.sort(customers);
				
							
							break;
							
						case 7:
							Collections.sort(customers,new Comparator<Customer>() {
								
								public int compare(Customer c1,Customer c2) {
									//dob based
									int index=c1.getDob().compareTo(c2.getDob());
									if(index==0)
									{
										//reg. amount based
										if(c1.getRegistrationAmount()<c2.getRegistrationAmount())
											return -1;
										if(c1.getRegistrationAmount()==c2.getRegistrationAmount())
											return 0;
										else
											return 0;
									}
									else
										return index;
								}
							});
							break;
							
						case 8:
							Iterator<Customer> custList=customers.iterator();
							while(custList.hasNext())
							{
								
								int year=Period.between(custList.next().getRegistrationDate(),LocalDate.now()).getYears();		
								System.out.println(year);
								if(year>3)
									custList.remove();
								
							}
							break;
						case 0:
						 exit=true;
						break;
						default:
							System.out.println("Invalid input");
							break;
					}
					
					
					
				}catch(Exception e) {
					e.printStackTrace();
					//read off pending token from the scanner till EOL(end of line)
					sc.nextLine();
				}
			}
		}

	}

}

