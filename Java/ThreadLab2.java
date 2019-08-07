package threadexam;

import java.text.*;
import java.util.*;

public class ThreadLab2{

	public static void main(String[] args) {
		Runnable r1 = new Thread3();
		Runnable r2 = new Thread4();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		for(int i=0; i<10; i++) {
			try {
				Thread.sleep(300);
			} catch(InterruptedException e) {}
			System.out.println("number of milliseconds since January 1, 1970, 00:00:00 GMT");
		}
	}

}

class Thread3 implements Runnable{
	
	public void run() {
		SimpleDateFormat format = new SimpleDateFormat("MM월 dd일");
		Date date = new Date();
		for(int i=0; i<3; i++) {
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {}
			System.out.println("오늘은 " + format.format(date) + "입니다.");
		}
	}
}

class Thread4 implements Runnable{
	SimpleDateFormat format = new SimpleDateFormat("HH시 mm분 ss초");
	Date date = new Date();
	public void run() {
		for(int i=0; i<5; i++) {
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {}
			System.out.println(format.format(date));
		}
	}
}
