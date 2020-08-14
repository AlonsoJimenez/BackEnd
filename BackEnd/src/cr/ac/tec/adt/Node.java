package cr.ac.tec.adt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cr.ac.tec.workingObjects.TrainStation;

public class Node implements Comparable<Node>{

    public Node(TrainStation station) {
        this.station = station;
    }

    private LinkedList isDestinationTo  = new LinkedList ();

    private TrainStation station;

    private Node shortestPath = null;

    private Integer distance = Integer.MAX_VALUE;

    Map<Node, Integer> adjacentNodes = new HashMap<> ();
    
    

    public void deleteDestination(Node removal){
    	Node removalAux = Graph.getMainGraph().getNodes().get(removal);
        adjacentNodes.remove (removalAux);
        
    }

    public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
        destination.getIsDestinationTo ().add (new Node(this.getStation()));
    }

    public ArrayList<Node> getIsDestinationTo() {
        return isDestinationTo.toArrayList();
    }

    public void setIsDestinationTo(LinkedList isDestinationTo) {
        this.isDestinationTo=isDestinationTo;
    }

    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
        this.adjacentNodes=adjacentNodes;
    }

    public void setShortestPath(Node shortestPath){
        this.shortestPath = shortestPath;
    }

    public Node getShortestPath(){
        return this.shortestPath;
    }

    public void setDistance(Integer distance) {
        this.distance=distance;
    }

    public int getDistance() {
        return distance;
    }

    public void setStation(TrainStation station) {
        this.station=station;
    }

    public TrainStation getStation() {
        return station;
    }


    @Override
    public int compareTo(Node o) {
        return this.station.compareTo(o.station);
    }

    @Override
    public String toString(){
        return this.station.getName();
    }
}
