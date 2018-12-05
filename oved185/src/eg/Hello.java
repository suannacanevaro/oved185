package eg;

import java.time.LocalDate;
import java.time.Month;

public class Hello {
	public static void main(String[] args) {
		System.out.println("Hello @" + LocalDate.of(2019, Month.JANUARY, 1));
	}
}
