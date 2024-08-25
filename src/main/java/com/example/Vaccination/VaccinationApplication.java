package com.example.Vaccination;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@SpringBootApplication
public class VaccinationApplication {

    public static void main(String[] args) {

        /*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.

		 Tasks:
		1. Fetch context from ApplicationContext.xml and initiate Scanner.
		2. Fetch vaccine and User type choice.
		3. Get the required bean from context.
		4. Get the appointment details form user
		5. Display the appointment details
		6. Run the loop again to book for another user or else exit.
		 */
    	ClassPathXmlApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
//    	ClassPathXmlApplicationContext contexta = new ClassPathXmlApplicationContext();
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Welcome to Vaccination program!");
    	while (true) {
    		System.out.println("Please choose your vaccine preferance \n 1. Covid \n 2. Polio \n 3. Typhoid");
    		int vaccineChoice = scanner.nextInt();
    		System.out.println("Select below whome do you want to vaccinate! \n 1. Father \n 2. Mother \n 3. Self \n 4. Spouse \n 5. Exit");
    		int userChoice = scanner.nextInt();
    		String vaccine;
    		String userType;
    		switch (vaccineChoice) {
    		case 1: {
    			vaccine = "Covid";
    			break;
    		}
    		case 2: {
    			vaccine = "Polio";
    			break;
    		}
    		case 3 : {
    			vaccine = "Covid";
    			break;
    		}
    		default: {
    			return;
    		}
    		
    		}
    		switch (userChoice) {
    		case 1:{
    			userType = "father";
    			break;
    		}
    		case 2: {
    			userType = "mother";
    			break;
    		}
    		case 3: {
    			userType = "self";
    			break;
    		}
    		case 4: {
    			userType = "spouse";
    			break;
    		}
    		default:
    			return;
    		}
    		User user = (User)context.getBean(userType + vaccine);
    		if (!user.IsVaccinated()) {
    			System.out.println("Please enter " + userType +  " details:");
        		System.out.print("Name: ");
        		String name = scanner.next();
        		scanner.nextLine();
        		System.out.print("Age: ");
        		int age = scanner.nextInt();
//        		scanner.nextLine();
        		System.out.print("Apointment date (YYYY-MM-DD): ");
        		String date = scanner.next();
//        		scanner.nextLine();
        		System.out.print("Apointment time (HH:MM AM/PM): ");
        		String timeSlot = scanner.next();
        		scanner.nextLine();
        		System.out.print("Apointment location: ");
        		String location = scanner.next();
        		scanner.nextLine();
        		TimeAndLocation timeAndLocation = (TimeAndLocation)context.getBean("timeAndLocation");
        		timeAndLocation.setDetails(timeSlot, location, date);
        		user.setUserDetails(name, age, timeAndLocation);
        		user.setAppointment();
        		
    		}else {
    			System.out.println("User is already vaccinated.");
    		}
    		System.out.println("Do you want to register for someone else? \n 1. yes \n 2. No");
    		int registerChoice = scanner.nextInt();
    		if (registerChoice == 2) break;
    		
    		
    	}
    }
}