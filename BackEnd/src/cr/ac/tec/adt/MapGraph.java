package cr.ac.tec.adt;
import java.util.HashMap;
import java.util.Map;

import cr.ac.tec.workingObjects.TrainStation;

public class MapGraph<T extends Comparable<T>> {
	
	public static Map<TrainStation, LinkedList<Stop> > trainMap = new HashMap<>(); 
	
	public static void addStation(TrainStation station) {
		trainMap.put(station, new LinkedList<Stop>());
	}
	
	public void addStop(TrainStation from, TrainStation where, int price) {
		if(trainMap.containsKey(from)) {
			if(trainMap.containsKey(where)) {
				Stop temp = new Stop(from, where, price);
				trainMap.get(from).add(temp);
			}else {
				addStation(where);
				addStop(from, where, price);
			}
		}else {
			addStation(from);
			addStop(from, where, price);
		}
	}
	
	public void deleteStation(TrainStation station) {
		trainMap.values().stream().forEach(stop -> stop.remove(new Stop(null, station, 0)));
		trainMap.remove(station);
	}
	
	public void deleteStop(TrainStation station, Stop delete) {
		trainMap.get(station).remove(delete);
	}
}
