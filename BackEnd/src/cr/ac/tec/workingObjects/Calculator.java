package cr.ac.tec.workingObjects;

import java.util.ArrayList;

import cr.ac.tec.adt.Node;

public class Calculator {
	
	public Calculator(int price, ArrayList<Node> route) {
		this.price = price;
		for(Node node: route) {
			this.route.add(node.getStation().getName()+"-");
		}
	}
	
	private int price;
	private ArrayList<String> route = new ArrayList<String>();
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public ArrayList<String> getRoute() {
		return route;
	}
	public void setRoute(ArrayList<String> route) {
		this.route = route;
	}
	
	
	
}
