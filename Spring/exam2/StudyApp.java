package exam2;

import org.springframework.context.*;
import org.springframework.context.support.*;

public class StudyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext factory = new ClassPathXmlApplicationContext("exam2/bean2.xml");
		
		Student[] st = {
				factory.getBean("st1", Student.class),
				factory.getBean("st2", Student.class),
				factory.getBean("st3", Student.class)
		};
		
		for(Student data : st)
			System.out.println(data.getName() + "는 " + data.getMyHomework().getHomeworkName() + "을 학습합니다.");
		
		((ClassPathXmlApplicationContext)factory).close();
	}
}
