public class linkedList<E> {
	private class Node<E> {
		private E element;
		private Node<E> next;
		//private Node<E> pre;
		private int index;
	    public Node(){
	     	element = null;
	    	//pre = null;
	    	next = null;
	    }
		public Node(E e) {
			element = e;
			//pre = null;
			next = null;
		}

		public E getelement() {
			return element;
		}

		/*public Node getpre() {
			return pre;
		}*/

		public Node getnext() {
			return next;
		}

		public void setnext(Node n) {
			next = n;
		}

		/*public void setpre(Node p) {
			pre = p;
		}*/
		public int getindex() {
			return index;
		}
		public void setElement(E value){
			element = value;
		}
	}
	private Node<E> Head, Tail;
	private int size;
	
	public linkedList(){
		Head = null;
		Tail = null;
		size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public void AddFront(E e) {
		Node<E> newNode = new Node(e);
		if (this.isEmpty()) { //if empty, add to head and tail 
			Head = newNode;
			Tail = Head;
			size++;
			return;
		}
		newNode.setnext(Head); //set the new node as head
		Head = newNode;
		size++;
	}
	
	public void AddBack(E e) {
		Node<E> newNode = new Node(e);
		if (this.isEmpty()) { //if empty, add to head and tail 
			Head = newNode;
			Tail = Head;
			size++;
			return;
		}
		Tail.setnext(newNode); //set the new node as tail
		Tail = newNode;
		size++;
	}
	
	public void AddElement(int ind, E e) {
		Node<E> newNode = new Node(e);
		if (this.isEmpty()) {
			Head = newNode;
			Tail = Head;
			size++;
			return;
		}
		if (ind == 0) {
			AddFront(e);
			return;
		}
		if (ind == size) {
			AddBack(e);
			return;
		}
		if(ind > size){
			System.out.println("Error, index is out of range");
			return;
		}
		Node<E> temp = Head;
		for (int i = 0; i < ind - 1; i++) { // runs the loop until position =
											// index-1
			temp = temp.getnext();
		}
		Node<E> save = temp.getnext();
		temp.setnext(newNode);
		newNode.setnext(save);
		size++; 
	}
	
	public E removeFront() {
		if (this.isEmpty()) {
			return null;
		}
		Node<E> temp = Head;
		E save = Head.getelement();
		Head = Head.getnext();
		size--;
		return save;
	}
	
	public E top(){
		return Head.getelement();
	}
	
	public E removeBack() {
		if (this.isEmpty()) {
			return null;
		}
		if (Tail == Head) {
			E save = Tail.getelement();
			size--;
			return save;
		}
		E save = Tail.getelement();
		Tail = null;
		Node<E> temp = Head;
		Node<E> temp2 = temp.getnext();
		while (temp2.getnext() != null) { // runs the loop until the next node
											// of temp2 is null
			temp = temp2; // so temp2 is the last node
			temp2 = temp.getnext();
		}
		Tail = temp;
		Tail.setnext(null); // disconnect the last node
		size--;
		return save;
	}
	
	public E removeElement(E element) {
		if (this.isEmpty()) {
			return null;
		}
		if(size == 1){
			Head = null;
			Tail = null;
			size --;
		}
		Node<E> temp = Head;
		while(temp != null) { 
			if(temp.getnext().getelement() == element){
				break;
			}							
			temp = temp.getnext();
		}
		Node<E> savenode = temp.getnext(); // save the target node
		E save = savenode.getelement(); // save the target node's data
		temp.setnext(temp.getnext().getnext()); // skip the deleted node and
												// connect to the next node
		size--;
		return save;

	}
	
	public String toString() {
		if (this.isEmpty())
			return "[]";
		String st = "";
		Node temp = Head;
		// to go through a list, up to the last element,
		// so that the last element will be procecced differently
		while (temp.getnext() != null) {
			st += temp.getelement().toString() + ", ";
			temp = temp.getnext();
		}
		// The last node, don;t add the comma, add the bracket
		st += temp.getelement().toString() + "";
		return st;
	}
	

}
