package vn.iotstar.util;

import java.time.LocalDate;

public class AddDate {
	 public static void main(String args[]){  
         
	        //get current date using now() method and add 1 day using plusDays() method  
	        LocalDate newDate1 =  LocalDate.now().plusDays(1);  
	        System.out.println(newDate1+" is a day after adding 1 day to the current date");  
	            
	        //get current date using now() method and add 7 day using plusDays() method  
	        LocalDate newDate2 =  LocalDate.now().plusDays(7);  
	        System.out.println(newDate2+" is a day after adding 7 day to the current date");  
	            
	        //define a date using of() method and add 1 day using plusDays() method  
	        LocalDate newDate3 = LocalDate.of(2019, 10, 31).plusDays(1);  
	        System.out.println(newDate3+" is a day after adding 1 day to the define date");  
	            
	        //define a date using of() method and add 1 day using plusDays() method  
	        LocalDate newDate4 = LocalDate.of(2019, 12, 31).plusDays(7);  
	        System.out.println(newDate4+" is a day after adding 7 day to the define date");  
	    }  
}
