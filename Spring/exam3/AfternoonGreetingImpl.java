package exam3;

import org.springframework.stereotype.*;

@Component("afternoon")
public class AfternoonGreetingImpl implements Greeting{
	public void greet() {
		System.out.println("��ſ� ���ĵǼ���.");
	}
}
