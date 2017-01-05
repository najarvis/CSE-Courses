
public class NewLinkedList<T> {

	private class Node {
		public T data;
		public Node prev, next;
		private Node(T dataPortion, Node previousNode, Node nextNode){
			data = dataPortion;
			prev = previousNode;
			next = nextNode;
			
		}
	}
	
	private Node firstNode;
	private int numberOfEntries;
	
	/**
	 * Adds a new entry to the double linked list
	 * @param newEntry - Entry to add to the list
	 * @return true
	 */
	public boolean add(T newEntry){
		if (numberOfEntries == 0){
			Node toAdd = new Node(newEntry, null, null);
			firstNode = toAdd;
		} else {
			Node toAdd = new Node(newEntry, null, firstNode);
			firstNode.prev = toAdd;
			firstNode = toAdd;
		}
		numberOfEntries++;
		
		return true;
	}
	
	/**
	 * Remove the first entry from the double linked list
	 * @return true if the operation was successful, false if not.
	 */
	public boolean remove(){
		if (numberOfEntries == 0) return false;
		if (numberOfEntries == 1) {firstNode = null; return true;}
		
		firstNode = firstNode.next;
		firstNode.prev = null;
		numberOfEntries--;
		return true;
	}
}
