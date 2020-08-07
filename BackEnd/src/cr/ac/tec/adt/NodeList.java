package cr.ac.tec.adt;

public class NodeList<T extends Comparable<T>> {
	private T data = null;
	private NodeList reference = null;
	
	public NodeList(T data) {
		this.data = data;
	}
	
	public void setReference(NodeList reference) {
		this.reference = reference;
	}
	
	public NodeList getReference() {
		return this.reference;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public T getData() {
		return this.data;
	}
}
