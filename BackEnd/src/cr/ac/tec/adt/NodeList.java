package cr.ac.tec.adt;

public class NodeList {

    NodeList(Node data){
        this.data = data;
    }
    
    Node data;
    NodeList reference;

    public NodeList getReference() {
        return reference;
    }

    public void setReference(NodeList reference) {
        this.reference=reference;
    }

    public Node getData() {
        return data;
    }

    public void setData(Node data) {
        this.data=data;
    }


}
