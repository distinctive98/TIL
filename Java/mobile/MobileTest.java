package mobile;

public class MobileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Mobile[] mobile ={
			new Ltab("Ltab", 500, "ABC-01"),
			new Otab("Otab", 1000, "XYZ-20")
		};
		
		printTitle();
		for(Mobile data : mobile) {
			printMobile(data);
			data.charge(10);
		}
		
		System.out.println("\n\t[10분 충전]");
			
		
		printTitle();
		for(Mobile data : mobile) {
			printMobile(data);
			data.operate(5);
		}
		
		System.out.println("\n\t[5분 통화]");
		
		printTitle();
		for(Mobile data : mobile) {
			printMobile(data);
		}
		
	}
	
	public static void printMobile(Mobile mobile) {
		System.out.println("\t" + mobile.getMobileName() + "\t\t" + mobile.getBatterySize() + "\t\t" + mobile.getOsType());
	}
	
	public static void printTitle() {
		System.out.println("\tMobile\tBattery\tOS");
		System.out.println("\t-----------------");
	}

}
