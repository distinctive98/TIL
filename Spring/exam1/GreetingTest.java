package exam1;

import java.time.*;
import org.springframework.context.*;
import org.springframework.context.support.*;

public class GreetingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext factory = new ClassPathXmlApplicationContext("exam1/applicationContext.xml");
		
		LocalTime localTime = factory.getBean("localTime", LocalTime.class);
		
		int hour = localTime.getHour();
		if(6 <= hour && hour <12) {
			factory.getBean("morning", MorningGreetingImpl.class).greet();
		} else if(12 <= hour && hour < 17) {
			factory.getBean("afternoon", AfternoonGreetingImpl.class).greet();
		} else if(17 <= hour && hour < 22) {
			factory.getBean("evening", EveningGreetingImpl.class).greet();
		} else {
			factory.getBean("night", NightGreetingImpl.class).greet();
		}
		
		((ClassPathXmlApplicationContext)factory).close();
	}
}
