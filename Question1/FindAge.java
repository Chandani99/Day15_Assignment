package Question1;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Calendar;
import java.util.Scanner;
import java.time.format.DateTimeFormatter ;

public class FindAge {
	
	public int findAge(String date) throws InvalidDateFormatException{
		try {
			DateTimeFormatter ltf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			LocalDate ld1=LocalDate.parse(date,ltf);
			
			LocalDate ld=LocalDate.now();
			
	        Period p=Period.between(ld1, ld);
	        
	        if(p.getYears()>0 || p.getMonths()>0 || p.getDays()>0) {
	        	
	        	return p.getYears();	
	        }
	        else{
	        	return-1;
	        }
		}
		catch(Exception e){
      
        	InvalidDateFormatException idf=new InvalidDateFormatException("Inavlid date format");
        	
        	throw idf;
        }
	}

	public static void main(String[] args) throws InvalidDateFormatException {
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the date of birth in the formate dd/MM/yyyy");
			
			String dob= sc.next();
			
			FindAge fa=new FindAge();
			
			int age=fa.findAge(dob);
			if(age<0) {
				System.out.println("Date should not be in Future.");
			}
			else {
			    System.out.println(age);
			}
		}
		catch(InvalidDateFormatException idf) {
			System.out.println(idf.getMessage());
		}
		

		
//		
		
		
		
//		LocalDateTime current = LocalDateTime.now();
//		System.out.println("current date and time in default format: "+ current);
//		
//		DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//		
//		System.out.println(formatObj);
//		String udf= current.format(formatObj);
//		System.out.println("current date and time in userdefined format: "+ udf);
		
//		LocalDate date = LocalDate.now();
//		LocalDate yesterday = date.minusDays(1);
//		LocalDate tomorrow = date.plusDays(1);
//		System.out.println("Today date: "+date);
//		System.out.println("Yesterday date: "+yesterday);
//		System.out.println("Tomorrow date: "+tomorrow);
//		
//		LocalDate date1 = LocalDate.of(2020, 1, 13);
//		System.out.println(date1.isLeapYear());
//		LocalDate date2 = LocalDate.of(2016, 9, 23);
//		System.out.println(date2.isLeapYear());
		
//		
//		
//		
//		// TODO Auto-generated method stub

	}

}
