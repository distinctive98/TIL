package exam3;

import org.springframework.stereotype.*;

@Component("morning")
public class MorningGreetingImpl implements Greeting{
	public void greet() {
		System.out.println("상쾌한 아침입니다.");
	}
}
