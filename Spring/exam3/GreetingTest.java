package exam3;

import java.time.*;
import org.springframework.context.*;
import org.springframework.context.support.*;

public class GreetingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext factory = new ClassPathXmlApplicationContext("exam3/applicationContext.xml");
		
		LocalTime localTime = factory.getBean("localTime", LocalTime.class);

		int hour = localTime.getHour();
		Greeting greeting = null;
		if(6 <= hour && hour <12) {
			greeting = (Greeting)factory.getBean("morning");
		} else if(12 <= hour && hour < 17) {
			greeting = (Greeting)factory.getBean("afternoon");
		} else if(17 <= hour && hour < 22) {
			greeting = (Greeting)factory.getBean("evening");
		} else {
			greeting = (Greeting)factory.getBean("night");
		}
		
		greeting.greet();
		
		((ClassPathXmlApplicationContext)factory).close();
	}
}
