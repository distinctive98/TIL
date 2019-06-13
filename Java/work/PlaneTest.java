package work;

public class PlaneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Plane[] planes = {
				new Airplane("L747", 1000),
				new Cargoplane("C40", 1000)
		};
		
		printInfo(planes);
		
		System.out.println("\t[100 운항]");
		for(Plane data : planes)
			data.flight(100);
		printInfo(planes);
		
		System.out.println("\t[200 주유]");
		for(Plane data : planes)
			data.refuel(200);
		printInfo(planes);
		
		
	}
	
	public static void printInfo(Plane[] list) {
		System.out.println("\tPlane\tfuelSize");
		System.out.println("\t-----------");
		
		for(Plane data : list)
			System.out.printf("\t%s\t\t%d\n", data.getPlaneName(), data.getFuelSize());
		
		System.out.println();
		
	}

}
