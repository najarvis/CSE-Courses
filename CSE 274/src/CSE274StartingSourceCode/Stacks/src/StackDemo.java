import java.util.Stack;

public class StackDemo {

	public static void main(String[] args){
		System.out.println("---Array Stack Test---");
		ArrayStack<String> ArrStack1 = new ArrayStack<String>();
		ArrStack1.push("Hello");
		ArrStack1.push("World");
		ArrStack1.push("!");
		displayStack(ArrStack1);
		displayStack(ArrStack1); // Show data is unchanged
		
		ArrStack1.pop();
		System.out.println("Popping 1 element and checking if empty");
		System.out.println(ArrStack1.isEmpty());
		displayStack(ArrStack1);
		
		System.out.println("Clearing array and checking if empty");
		ArrStack1.clear();
		System.out.println(ArrStack1.isEmpty());
		displayStack(ArrStack1);

		System.out.println();
		
		System.out.println("---Linked Stack Test---");
		LinkedStack<String> linkStack1 = new LinkedStack<String>();
		linkStack1.push("Hello");
		linkStack1.push("World");
		linkStack1.push("!");
		displayStack(linkStack1);
		displayStack(linkStack1);
		
		linkStack1.pop();
		System.out.println("Popping 1 element and checking if empty");
		System.out.println(linkStack1.isEmpty());
		displayStack(linkStack1);
		
		System.out.println("Clearing array and checking if empty");
		linkStack1.clear();
		System.out.println(linkStack1.isEmpty());
		displayStack(linkStack1);
		
		System.out.println();
		
		System.out.println("---Vector Stack Test---");
		VectorStack<String> vectorStack1 = new VectorStack<String>();
		vectorStack1.push("Hello");
		vectorStack1.push("World");
		vectorStack1.push("!");
		displayStack(vectorStack1);
		displayStack(vectorStack1);
		
		vectorStack1.pop();
		System.out.println("Popping 1 element and checking if empty");
		System.out.println(vectorStack1.isEmpty());
		displayStack(vectorStack1);
		
		System.out.println("Clearing array and checking if empty");
		vectorStack1.clear();
		System.out.println(vectorStack1.isEmpty());
		displayStack(vectorStack1);
	}
	
	public static <T> void displayStack(StackInterface<T> stack){
		Stack<T> tmp = new Stack<T>();
		while (!stack.isEmpty()){
			tmp.push(stack.pop());
		}
		System.out.print("Stack | ");
		while (!tmp.isEmpty()){
			T val = tmp.pop();
			System.out.print("" + val + " ");
			stack.push(val);
		}
		System.out.println();
	}
}
