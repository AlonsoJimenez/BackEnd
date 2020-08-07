package cr.ac.tec.workingObjects;
import cr.ac.tec.adt.*;
public class ShortestRoute {
	
	public LinkedList<TrainStation> dijsktraAlgorithm(TrainStation source, TrainStation destination) {
		
		TrainStation[] visitedStations = new TrainStation[MapGraph.trainMap.size()];
		Stop[] weights = new Stop[MapGraph.trainMap.size()];
		
		visitedStations[0] = source;
		weights[0] = new Stop(source, source, 0);
		
		LinkedList<Stop> tempListRoutes = MapGraph.trainMap.get(source);
		for(int x = 0; x < MapGraph.trainMap.size(); x++) {
			weights[x] = tempListRoutes.getIndex(x) != null ? tempListRoutes.getIndex(x) : null;
		}
		
		for(int x = 0; x < MapGraph.trainMap.size(); x++) {
			Stop lowerValue = lowerValue(weights, visitedStations);
			visitedStations[x+1] = lowerValue.getDestination();
			tempListRoutes = compareRoutes(tempListRoutes, MapGraph.trainMap.get(lowerValue.getDestination()), lowerValue.getWeight());
		}
		
		LinkedList<TrainStation> shortestPath = new LinkedList<TrainStation>();
		Stop mainEdge = tempListRoutes.get(new Stop(null, destination, 0));
		while(!mainEdge.getSource().getName().equals(source.getName())) {
			shortestPath.add(mainEdge.getSource());
			mainEdge = tempListRoutes.get(new Stop(null, mainEdge.getDestination(), 0));
		}
		return shortestPath;		
	}
	
	private boolean isVisited(Stop stop, TrainStation[] visited) {
		for(TrainStation station : visited) {
			if(station.getName().equals(stop.getDestination().getName())) {
				return true;
			}
		}
		return false;
	}
	
	private Stop lowerValue(Stop[] weights, TrainStation[] visited) {
		Stop tempStop = weights[0];
		for(Stop stop : weights) {
			if(stop == null) {
				return tempStop;
			}
			else if(isVisited(stop, visited)) {
				
			}
			else if(stop.getWeight() < tempStop.getWeight()) {
				tempStop = stop;
			}
		}
		return tempStop;
	}
	
	private int realArraySize(TrainStation[] analize) {
		int counter = 0;
		for(int x = 0; x < analize.length; x++) {
			if(analize[x]==null) {
				return counter;
			}
			counter++;
		}
		return counter;
	}
	
	private LinkedList<Stop> compareRoutes(LinkedList<Stop> oldRoutes, LinkedList<Stop> newRoutes, int price){
		LinkedList<Stop> returnList = new LinkedList<>();
		for(int x = 0; x < newRoutes.size(); x++) {
			if(oldRoutes.contains(newRoutes.getIndex(x))) {
				if(oldRoutes.get(newRoutes.getIndex(x)).getWeight() > price + newRoutes.getIndex(x).getWeight()) {
					returnList.add(newRoutes.getIndex(x));
				}else {
					returnList.add(oldRoutes.get(newRoutes.getIndex(x)));
				}
			}else {
				returnList.add(newRoutes.getIndex(x));
			}
		}
		return returnList;
	}
}