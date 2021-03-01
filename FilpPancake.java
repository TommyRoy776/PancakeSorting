
public class FilpPancake {
	private static int ctflip = 0;
	private static linkedList<Integer> flips = new linkedList<Integer>();
	public static void main(String[] args) {
		String dtype = args[0];
		int num =  Integer.parseInt(args[1]);
		if(dtype.equals("array")){
			ArrayStack<Integer> main = new ArrayStack<Integer>();
			int lastindex = args.length -1;
	        for(int i = lastindex ;i>=2;i--){
				main.push(Integer.parseInt(args[i]));
			}
	        main.print();
			sort(main, num);
			System.out.print("("+ctflip+") ");
			System.out.print(flips.toString());
			System.out.println();
			main.print();
			
		}
		else if(dtype.equals("list")){
			ListStack<Integer> Lmain = new ListStack<Integer>();
			int lastindex = args.length -1;
			for(int i = lastindex ;i>=2;i--){
				Lmain.push(Integer.parseInt(args[i]));
			}
			Lmain.print();
			Lsort(Lmain, num);
			System.out.print(" ("+ctflip+") ");
			System.out.print(flips.toString());
			System.out.println();
			Lmain.print();			
		}
	}
     
	// <--------------------Array stack methods----------------------->
	private static void flip(ArrayStack<Integer> S, int idx) {
		ArrayStack<Integer> temp = new ArrayStack<Integer>();
		ArrayStack<Integer> temp2 = new ArrayStack<Integer>();
		int c = S.size() - idx;
		for (int i = 0; i < c; i++) { //pop out size - index elements 
			temp.push(S.pop() * -1); //each time flip, the elements turn from positive to negative or negative to positive        
		}
		while (!temp.isEmpty()) { //push to temp2 to adjust the order 
			temp2.push(temp.pop()); 
		}
		while (!temp2.isEmpty()) { //push back to S so the flip is done  
			S.push(temp2.pop()); 
		}
		ctflip++;
		flips.AddBack(c);
		//System.out.print(c + " ");

	}

	private static void sort(ArrayStack<Integer> S, int idx) {
		for (int size = 0; size < idx; size++) {
			int max = findMax(S, size); //get position of the biggest element from current size to the top
			if (max != size || isBurned(S, max)) { //do fliping if max position is not the current size or the element is burned   
				if (max != S.size() - 1) { //if max element is not at the bottom
					flip(S, max);    //flip the pancakes from max position  
					//S.print();
				}
			
				if (S.top() > 0) { //if top is positive 
					flip(S, S.size() - 1); //flip itself to negative
					//S.print();
				}
				flip(S, size); //flips the pancakes from size position that moves the current top to size position   
			}
			//S.print();
		}
	}

	private static int findMax(ArrayStack<Integer> S, int idx) {
		ArrayStack<Integer> temp = new ArrayStack<Integer>();
		int counter = idx; //find max element from idx to the top
		int max = 0;
		int position = idx - 1;
		int n = S.size() - idx;
		for (int i = 0; i < n; i++) {
			temp.push(S.pop());
		}
		// temp.print();

		while (!temp.isEmpty()) { // push back the element
			if (Math.abs(temp.top()) > max) {
				max = Math.abs(temp.top());
				position = counter;
			}
			S.push(temp.pop());
			counter++;
		}
		//S.print();
		return position;
	}

	private static boolean isBurned(ArrayStack<Integer> S, int idx) {
		ArrayStack<Integer> temp = new ArrayStack<Integer>();
		int c = S.size() - idx;
		for (int i = 0; i < c; i++) { //pop out size - index elements 
			temp.push(S.pop()); 
		}
		int tempN = temp.top(); //save the target element
		while (!temp.isEmpty()) { 
			S.push(temp.pop()); 
		}
		if (tempN > 0) {   //determinate the burned side 
			return false;
		} else {
			return true;
		}
	}

	//<------------------LinkStack methods-------------------------->
	// the functions are the same as array version but they accept ListStack and use ListStack as temporary storage 
	private static void Lflip(ListStack<Integer> S, int idx) {
		ListStack<Integer> temp = new ListStack<Integer>();
		ListStack<Integer> temp2 = new ListStack<Integer>();
		int c = S.size() - idx;
		for (int i = 0; i < c; i++) { 
			temp.push(S.pop() * -1); 
		}
		while (!temp.isEmpty()) { 
			temp2.push(temp.pop()); 
		}
		while (!temp2.isEmpty()) { 
			S.push(temp2.pop()); 
		}
		ctflip++;
		flips.AddBack(c);
		//System.out.print(c + " ");


	}

	private static void Lsort(ListStack<Integer> S, int idx) {
		for (int size = 0; size < idx; size++) {
			int max = LfindMax(S, size); // 2
			if (max != size || LisBurned(S, max)) {
				if (max != S.size() - 1) {
					Lflip(S, max);
					//S.print();
				}
			
				if (S.top() > 0) {
					Lflip(S, S.size() - 1);
					//S.print();
				}
				Lflip(S, size);
			}
			//S.print();
		}

	}
	
	private static int LfindMax(ListStack<Integer> S, int idx){
		ListStack<Integer> temp = new ListStack<Integer>();
		int counter = idx;
		int max = 0;
		int position = idx - 1;
		int n = S.size() - idx;
		for (int i = 0; i < n; i++) {
			temp.push(S.pop());
		}
		//temp.print();

		while (!temp.isEmpty()) { // push back the element
			if (Math.abs(temp.top()) > max) {
				max = Math.abs(temp.top());
				position = counter;
			}
			S.push(temp.pop());
			counter++;
		}
		
		return position;
	} 
	
	private static boolean LisBurned(ListStack<Integer> S, int idx) {
		ListStack<Integer> temp = new ListStack<Integer>();
		int c = S.size() - idx;
		for (int i = 0; i < c; i++) { 
			temp.push(S.pop()); 
		}
		int tempN = temp.top();
		while (!temp.isEmpty()) { 
			S.push(temp.pop()); 
		}
		if (tempN > 0) {
			return false;
		} else {
			return true;
		}
	}

}
