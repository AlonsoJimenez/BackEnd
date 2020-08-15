package cr.ac.tec.workingObjects;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import cr.ac.tec.adt.Graph;
import cr.ac.tec.adt.Node;

public class Dijkstra {

    /**
     * @param graph
     * @param source
     * @return Calcula por medio de Djikstra los caminos mas cortos de un nodo al otro del grafo
     */
    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
        source.setDistance(0);
        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<> ();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for ( Map.Entry< Node, Integer> adjacencyPair:
                    currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    CalculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    /**
     * @param unsettledNodes
     * @return  el valor mas bajo para llegar de un nodo al otro
     * funcion iterativa por lo que esta constantemente en y en cambio
     */
    private static Node getLowestDistanceNode(Set < Node > unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node: unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }
    /**
     * @param evaluationNode
     * @param edgeWeigh
     * @param sourceNode
     * cambia los origenes para encontrar la menor distancia
     */
    private static void CalculateMinimumDistance(Node evaluationNode,
                                                 Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            evaluationNode.setShortestPath(sourceNode);
        }
    }
}