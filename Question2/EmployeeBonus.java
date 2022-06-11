package Question2;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EmployeeBonus {
    
	public double bonusGet(String date) throws InvalidAgeException{
		
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		LocalDate ld=LocalDate.parse(date,dtf);
		
		LocalDate ld1=LocalDate.now() ;
		
		Period p=Period.between(ld1,ld);
		
		if(p.getYears()<1) {
			
			return 5000;
		}
		else if(p.getYears()>1 && p.getYears()<2) {
			return 8000;
		}
		else if(p.getYears()>2){
			return 10000;	
		}
		else {
			InvalidAgeException iae= new InvalidAgeException("Invalid Age..");
			throw iae;
		}
	}
	
	public static void main(String [] args) throws InvalidAgeException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter date of joining in dd/MM/yyyy formate");
		
		String date=sc.next();
		EmployeeBonus ib=new EmployeeBonus();
		
		try {
			double bonus=ib.bonusGet(date);
			System.out.println("Bonus is: " +bonus);
		}
		catch(InvalidAgeException iae) {
			System.out.println(iae.getMessage());
		}
		catch(Exception e) {
			InvalidAgeException iae1=new InvalidAgeException("Invalid Date Format");
			
			System.out.println(iae1.getMessage());
		}
	}
}
