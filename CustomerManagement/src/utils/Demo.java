package utils;
import java.time.LocalDate;
import java.time.Period;
public class Demo {

	public static void main(String[] args) {
		
		LocalDate d=LocalDate.parse("2000-12-12");
	//	int year=d.getYear();
		int year=Period.between(d,LocalDate.now()).getYears();
		System.out.println(year);
		
	}

}
