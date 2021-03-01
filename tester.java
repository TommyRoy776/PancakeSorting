
public class tester {

	public static void main(String[] args) {
		ListStack<Integer> a = new ListStack<Integer>(); 
		a.push(2);
		a.push(3);
		a.push(19);
		a.push(20);
		a.pop();
		a.push(25);
		a.print();
		linkedList<Integer> flips = new linkedList<Integer>();
		 flips.AddBack(2);
		 flips.AddBack(3);
		 System.out.println(flips.toString());
		
		ArrayStack<Integer> b = new ArrayStack();
	/*	b.push(5*-1);
		b.push(3);
		b.push(19);
		b.push(87);
		b.print();
		b.pop();
		b.print();*/

	}

}
