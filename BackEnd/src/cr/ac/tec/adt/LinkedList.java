package cr.ac.tec.adt;
import java.util.ArrayList;

public class LinkedList {
    NodeList first;

    public void add(Node node){
        NodeList current = first;
        if(first==null){
            first = new NodeList (node);
            return;
        }
        while (current.getReference ()!=null){
            current = current.getReference ();
        }
        current.setReference ( new NodeList (node));
    }

    public Node get(Node compare){
        NodeList current = first;
        while (current!=null) {
            if ( compare.compareTo (current.getData ())==0 ) {
                return current.getData ();
            } else {
                current=current.getReference ();
            }
        }
        return null;
    }

    public Node getIndex(int index){
        NodeList current = first;
        while(index!=0){
            current = current.getReference ();
            index--;
        }
        return current.getData ();
    }

    public void delete(String name){
        NodeList pointerHead = first;
        while(pointerHead.getReference ()!=null) {
            if ( name.compareTo (pointerHead.getReference ().getData ().getStation().getName())==0 ) {
                pointerHead.setReference (pointerHead.getReference ().getReference ());
                return;
            } else {
                pointerHead=pointerHead.getReference ();
            }
        }
    }

    public void deleteLast(){
        NodeList current = first;
        while (current.getReference () != null){
            current = current.getReference ();
        }
        delete (current.getData ().getStation ().getName());
    }

    public ArrayList<Node> toArrayList(){
        ArrayList<Node> toReturn = new ArrayList<> ();
        NodeList current = first;
        while(current != null){
            toReturn.add (current.getData ());
            current = current.getReference ();
        }
        return toReturn;
    }

    @Override
    public String toString(){
        String toReturn = new String ();
        NodeList current = first;
        while (current.getReference ()!=null){
            toReturn += current.getData ().getStation().getName();
            current = current.getReference ();
        }
        toReturn += current.getData ().getStation().getName();
        return toReturn;
    }


}

