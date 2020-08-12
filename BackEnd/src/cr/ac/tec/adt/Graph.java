package cr.ac.tec.adt;

import java.util.ArrayList;
import java.util.Collections;


public class Graph {
	
	private static Graph mainGraph = null;

    private  LinkedList nodes = new LinkedList ();

    public  LinkedList getNodes() {
        return nodes;
    }

    public  void setNodes(LinkedList nodes) {
        this.nodes = nodes;
    }

    public void deleteNode(Node name){
        Node removal = nodes.get(name);
        for(Node dest : removal.getIsDestinationTo ().toArrayList ()){
            dest.deleteDestination (name);
        }
        nodes.delete (name.getStation().getName());
    }

    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }

    public ArrayList<Node> gettingPath(Node path, Node origin){
        ArrayList<Node> toReturn = new ArrayList<> ();
        toReturn.add (path);
        Node current  = this.nodes.get (path).getShortestPath ();
        while(current!=origin && current != null){
            toReturn.add (current);
            current = current.getShortestPath ();
        }
        toReturn.add (origin);
        Collections.reverse (toReturn);
        return toReturn;
    }
    
    public static Graph getMainGraph() {
    	if(mainGraph == null) {
    		mainGraph = new Graph();
    		//mainGraph.addNode(new Node(new TrainStation()));
    		return mainGraph;
    	}else {
    		return mainGraph;
    	}
    }


}
