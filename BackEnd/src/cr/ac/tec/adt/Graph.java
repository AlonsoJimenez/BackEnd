package cr.ac.tec.adt;

import java.util.ArrayList;
import java.util.Collections;

import cr.ac.tec.workingObjects.Purchase;
import cr.ac.tec.workingObjects.TrainStation;


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
        for(Node dest : removal.getIsDestinationTo ()){
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
    		Node cart = new Node(new TrainStation("Juan", new int[] {5, 4}));
    		Node cart2 = new Node(new TrainStation("Rios", new int[] {9, 4}));
    		Node tr = new Node(new TrainStation("SJ", new int[] {3, 2}));
    		cart.addDestination(tr, 5);
    		cart2.addDestination(cart, 2);
    		tr.addDestination(cart2, 9);
    		tr.addDestination(cart, 7);
    		mainGraph.addNode(cart);
    		mainGraph.addNode(tr);
    		mainGraph.addNode(cart2);
    		Purchase trial = new Purchase("Cartago", "Tres Rios", "Alonso", 5);
    		Purchase.list.add(trial);
    		return mainGraph;
    	}else {
    		return mainGraph;
    	}
    }


}
