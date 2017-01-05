import java.util.Iterator;

public class LinkedBagDemo1 {
	public static void main(String[] args) {
		String[] contentsOfBag = { "A", "G", "D", "B", "A", "C", "F" };
		LinkedBag1<String> bag = new LinkedBag1<>();
		for (String s : contentsOfBag) {
			bag.add(s);
		}
		Iterator<String> iter = bag.iterator();
		
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		for (String s : bag) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
}
