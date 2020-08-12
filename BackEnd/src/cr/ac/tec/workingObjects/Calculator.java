package cr.ac.tec.workingObjects;

import java.util.ArrayList;

import cr.ac.tec.adt.Node;

public class Calculator {
	
	public Calculator(int price, ArrayList<Node> route) {
		this.price = price;
		this.route = route;
	}
	
	private int price;
	private ArrayList<Node> route;
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public ArrayList<Node> getRoute() {
		return route;
	}
	public void setRoute(ArrayList<Node> route) {
		this.route = route;
	}
	
	
	
}
