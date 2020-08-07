package cr.ac.tec.workingObjects;

public class TrainStation implements Comparable<TrainStation> {
	
	private int[] coordinates;
	private String name;
	private TrainStation[] references;
	
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
	public TrainStation[] getReferences() {
		return references;
	}
	public void setReferences(TrainStation[] references) {
		this.references = references;
	}

	@Override
	public int compareTo(TrainStation o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
