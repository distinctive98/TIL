package exam3;

import org.springframework.stereotype.*;

@Component("evening")
public class EveningGreetingImpl implements Greeting{
	public void greet() {
		System.out.println("����� ����Ǽ���.");
	}
}
