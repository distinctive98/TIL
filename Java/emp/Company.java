package emp;

public class Company {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee[] emp = {
				new Secretary("Duke", 1, "Secretary", 800),
				new Sales("Tuxi", 2, "Sales", 1200)
		};
		
		printEmployee(emp, false);
		
		//인센티브 100 지급
		System.out.println("\n[인센티브 100 지급]");
		for(Employee data : emp) 
			((Bonus)data).incentive(100);
		
		printEmployee(emp, true);
			
	}
	
	public static void printEmployee(Employee[] emp, boolean isTax) {
		
		if(isTax) {
			System.out.println("name\tdepartment\tsalary\ttax\t\textra pay");
			System.out.println("---------------------------------");
			
			for(Employee data : emp) {
				if(data instanceof Secretary)
					System.out.printf("%s\t\t%s\t\t%d\t\t%.1f\n", data.getName(), data.getDepartment(), data.getSalary(), data.tax());
				else
					System.out.printf("%s\t\t%s\t\t%d\t\t%.1f\t%.1f\n", data.getName(), data.getDepartment(), data.getSalary(), data.tax(), ((Sales)data).getExtraPay());
			}
		}
		else {
			System.out.println("name\tdepartment\tsalary\textra pay");
			System.out.println("---------------------------");
			
			for(Employee data : emp) {
				if(data instanceof Secretary)
					System.out.printf("%s\t\t%s\t\t%d\n", data.getName(), data.getDepartment(), data.getSalary());
				else
					System.out.printf("%s\t\t%s\t\t%d\t\t%.1f\n", data.getName(), data.getDepartment(), data.getSalary(), ((Sales)data).getExtraPay());
			}
		}
		
	}//메서드 끝

}
