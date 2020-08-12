package cr.ac.tec.workingObjects;

public class TrainStation implements Comparable<TrainStation> {
	
	public TrainStation(String name, int[] coordinates) {
		this.coordinates = coordinates;
		this.name = name;
	}
	
	private int[] coordinates;
	private String name;
	private String ID;
	private String color;
	
	
	public int[] getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(int[] coordinates) {
		this.coordinates = coordinates;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int compareTo(TrainStation o) {
		return this.name.compareTo(o.getName());
	}
	
	

}
