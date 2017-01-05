import TreePackage.*;
import java.util.*;

public class Driver {
	public static void displayTree(Iterator<Integer> iter) {
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		int [] items = { 5, 3, 4, 13, -5, 20, 100, -199 };
		for (int v : items) {
			bst.add(v);
		}
		
		Iterator<Integer> iter = bst.getInorderIterator();
		while (iter.hasNext()){
			System.out.print(iter.next() +  " ");
		}
		System.out.println();
	}
}
