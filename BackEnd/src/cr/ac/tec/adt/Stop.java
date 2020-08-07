package cr.ac.tec.adt;
import cr.ac.tec.workingObjects.*;

public class Stop implements Comparable<Stop>{
	
	public Stop(TrainStation source, TrainStation destination, int weight) {
		this.destination = destination;
		this.source = source;
		this.weight = weight;
	}
	
	private TrainStation source;
	private int weight;
	private TrainStation destination;
	
	public TrainStation getSource() {
		return source;
	}
	public void setSource(TrainStation source) {
		this.source = source;
	}
	public TrainStation getDestination() {
		return destination;
	}
	public void setDestination(TrainStation destination) {
		this.destination = destination;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@Override
	public int compareTo(Stop o) {
		if(o.getDestination().equals(destination)) {
			return 0;
		}else {
			return -1;
		}
	}
	
	
	
	
}
