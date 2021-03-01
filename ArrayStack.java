
public class ArrayStack<E> implements Stack<E> {
	private E[] St;
	private int size;
	
	public ArrayStack(){
		St = (E[]) new Object[3];
		size = 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size == 0);
	}
	
	private void resize () {
		E[] temp = (E[]) new Object[St.length *2];
		//copy all elements from old array to new array 
		for (int i =0; i<size; i++){
			temp[i] = St[i];
		}
		//update Arr to reference the new array
		St = temp;
	}

	@Override
	public void push(E e) {
		if(St.length == size) 
			this.resize(); //increase the size, if the stack is full
		St[size] = (E) e;  //put the element to back 
		size++;
	}

	@Override
	public E top() {
		if (isEmpty())
			return null;
		return St[size - 1];
	}

	@Override
	public E pop() {
		if (isEmpty())
			return null;
		E temp = St[size-1];
		St[size-1] = null;  //set the last element to null and reduce the size
		size--;
		return temp;
	}
	
	public String toString() {
		if (this.isEmpty())
			return "{}";
		String st = "bottom: {";
		//add to the set all elements except the last one 
		for (int i = 0; i <size-1; i++){
			st = st + St[i].toString() + ", ";
		}
		//add the last element 
		st = st + St[size-1].toString() + "} :Top";
		return st;
	}
	public void print() {
		System.out.println(this.toString());
	}

}
