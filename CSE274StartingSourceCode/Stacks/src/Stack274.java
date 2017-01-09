

import java.util.EmptyStackException;

/**
 * Stack implementation with where the bottom element is at the end of the array.
 * @author Nick Jarvis
 *
 * @param <T>
 */
public class Stack274<T> implements StackInterface<T>{

	private final static int MINIMUM_SIZE = 20;
	public T[] stack;
	public int topIndex;
	
	public Stack274(){
		this(MINIMUM_SIZE);
	}
	
	public Stack274(int initialCapacity){
		@SuppressWarnings("unchecked")
		T[] tmpStack = (T[]) new Object[initialCapacity];
		stack = tmpStack;
		topIndex = initialCapacity; // Set initial topIndex to the end of the Array
	}
	
	// These are similar to the methods found in ArrayStack.java, however many of the operators are reversed.
	@Override
	public void push(T newEntry) {
		resize();
		stack[topIndex-1] = newEntry;
		topIndex--;
	}

	@Override
	public boolean isEmpty() {
		return topIndex == getCapacity();
	}

	@Override
	public void clear() {
		while (!isEmpty())
			pop();
	}

	@Override
	public T pop() {
		resize();
		if (isEmpty()) throw new EmptyStackException();
		T tmp = stack[topIndex];
		stack[topIndex] = null;
		topIndex++;
		return tmp;
	}

	@Override
	public T peek() {
		if (isEmpty()) throw new EmptyStackException();
		return stack[topIndex];
	}
	
	public int getCapacity(){
		return stack.length;
	}
	
	/**
	 * This method automatically resizes the array to the appropriate size by both growing and shrinking the array.
	 */
	private void resize(){
		if (topIndex == 0){
			// Larger
			@SuppressWarnings("unchecked")
			T[] tmpStack = (T[]) new Object[getCapacity() * 2];
			System.arraycopy(stack, 0, tmpStack, getCapacity(), getCapacity());
			stack = tmpStack;
			topIndex = getCapacity() / 2;
		}
		
		else if (topIndex >= getCapacity() / 2 && getCapacity() / 2 >= MINIMUM_SIZE){
			// Smaller
			@SuppressWarnings("unchecked")
			T[] tmpStack = (T[]) new Object[getCapacity() / 2];
			System.arraycopy(stack, getCapacity() / 2, tmpStack, 0, getCapacity() / 2);
			stack = tmpStack;
			topIndex = 0;
		}
	}
	
	/**
	 * Method for printing the contents of the stack out. the bottom of the stack is printed first.
	 */
	public void printStack(){
		Stack274<T> tmpStack = new Stack274<T>();
		while (!isEmpty()){
			T tmp = pop();
			tmpStack.push(tmp);
		}
		
		System.out.print("Stack | ");
		while (!tmpStack.isEmpty()){
			T tmp = tmpStack.pop();
			System.out.print(tmp + ", ");
			push(tmp);
		}
		System.out.println();
	}
	
	// Function for testing
	public static void main(String[] args){
		Stack274<Integer> intStack = new Stack274<Integer>();
		for (int i = 0; i < 50; i++){
			intStack.push((int)(Math.random() * 20));
		}
		intStack.printStack();
		System.out.println(intStack.getCapacity());
		
		for (int i = 0; i < 40; i++){
			intStack.pop();
		}
		intStack.printStack();
		System.out.println(intStack.getCapacity());
	}

}
