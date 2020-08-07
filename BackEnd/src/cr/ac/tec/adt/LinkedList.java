package cr.ac.tec.adt;

public class LinkedList <T extends Comparable<T>>{
	NodeList first;
	NodeList last;
	
	public void remove(T value) {
		NodeList tempFront = first;
		NodeList tempBack = first;
		while(first != null) {
			if(tempFront.getData().compareTo(value)==0) {
				tempBack.setReference(tempFront.getReference());
				return;
			}
			tempBack = tempFront;
			tempFront = tempFront.getReference();
		}
	}
	
	
	public void add(T placeToGo) {
		last.setReference(new NodeList(placeToGo));
	}
	
	public T get(T compareValue) {
		return this.get(first, compareValue);
	}
	
	private T get(NodeList pointer,T value) {
		if(pointer.getData().compareTo(value)==0) {
			return (T) pointer.getData();
		}
		else {
			return this.get(pointer.getReference(), value);
		}
	}
	
	public int size() {
		NodeList pointer = first;
		int tempReturn = 0;
		while(pointer != null) {
			pointer = pointer.getReference();
			tempReturn ++;
		}
		return tempReturn;
	}
	
	public T getIndex(int index) {
		NodeList current = first;
		for(int x = 0; x < index; x++) {
			if(current == null)	{
				return null;
			}
			current = current.getReference();
		}
		return (T) current.getData();
	}
	
	public boolean contains(T stop) {
		NodeList pointer = first;
		while(pointer!=null) {
			if(pointer.getData().compareTo(stop)==0) {
				return true
			}
		}
		return false;
	}
	
	
	
}
