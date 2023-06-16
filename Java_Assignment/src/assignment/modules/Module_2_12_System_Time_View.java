// Write a Java program to display the system time.



package assignment.modules;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Module_2_12_System_Time_View {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		
	}

}