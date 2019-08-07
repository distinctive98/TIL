package lamdaexam;

import java.text.*;
import java.util.*;

public class LamdaThreadLab{

	public static void main(String[] args) {
		SimpleDateFormat format1 = new SimpleDateFormat("MM�� dd��");
		SimpleDateFormat format2 = new SimpleDateFormat("HH�� mm�� ss��");
		Date date = new Date();
		
		Thread t1 = new Thread(()-> {
			for(int i=0; i<3; i++) {
				try {
					Thread.sleep(1000);
				} catch(InterruptedException e) {}
				System.out.println("������ " + format1.format(date) + "�Դϴ�.");
			}
		});
		
		Thread t2 = new Thread(()-> {
			for(int i=0; i<5; i++) {
				try {
					Thread.sleep(500);
				} catch(InterruptedException e) {}
				System.out.println(format2.format(date));
			}
		});
		
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
