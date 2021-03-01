public class ListStack<E> implements Stack<E> {
	private linkedList<E> list = new linkedList<>();  
	public ListStack(){

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.getSize();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	@Override
	public void push(E e) {
		list.AddFront(e);
	}

	@Override
	public E top() {
		return list.top();
	}

	@Override
	public E pop() {
		return list.removeFront();
	}
	
	public void print() {
		System.out.println("Top: ["+list.toString()+"] Bottom");
	}
	

}
