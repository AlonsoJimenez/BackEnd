package cr.ac.tec.workingObjects;

import java.util.ArrayList;

public class Purchase {
	
	public Purchase(String startPoint, String endPoint, String email, int numberOf ) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.email = email;
		this.numberOf = numberOf;
	}
	
	public static ArrayList<Purchase> list = new ArrayList<>();
	private int numberOf;
	private String email;
	private String startPoint;
	private String endPoint;
	
	public int getNumberOf() {
		return numberOf;
	}
	public void setNumberOf(int price) {
		this.numberOf = price;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}
	public String getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}
	
	
	
	
}
