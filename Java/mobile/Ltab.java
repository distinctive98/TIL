package mobile;

class Ltab extends Mobile{
	
	Ltab(){}
	Ltab(String mobileName, int batterySize, String osType){
		super(mobileName, batterySize, osType);
	}
	
	public void operate(int time) {
		int size = super.getBatterySize() - time * 10;
		super.setBatterySize(size);
	}
	
	public void charge(int time) {
		super.setBatterySize(super.getBatterySize() + time * 10);
	}
}