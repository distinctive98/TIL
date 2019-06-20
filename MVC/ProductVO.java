package model.vo;

public class ProductVO {
	
	private int apple;
	private int banana;
	private int orange;
	
	public ProductVO(){
		apple=0;
		banana=0;
		orange=0;
	}
	
	public int getApple() {
		return apple;
	}
	public void setApple() {
		this.apple++;
	}
	public int getBanana() {
		return banana;
	}
	public void setBanana() {
		this.banana++;
	}
	public int getOrange() {
		return orange;
	}
	public void setOrange() {
		this.orange++;
	}
	
	
	
	/*
	private int[] product;
	
	public ProductVO(int n){
		product = new int[n];
	}
	
	public int getProduct(int n) {
		return product[n];
	}
	
	public void setProduct(int n) {
		product[n]++;
	}
	*/
}
