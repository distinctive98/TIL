package exam3;

import org.springframework.stereotype.*;

@Component("night")
public class NightGreetingImpl implements Greeting{
	public void greet() {
		System.out.println("�ȳ��� �ֹ�����.");
	}
}
