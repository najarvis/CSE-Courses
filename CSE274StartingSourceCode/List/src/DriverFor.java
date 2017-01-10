import java.util.Iterator;

/**
 * A driver that demonstrates the for-each statement with a class, such as
 * LinkedListWithIterator, that implements Iterable. Note that
 * LinkedListWithIterator implements Iterable because ListWithIteratorInterface
 * extends Iterable.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 4.0
 */
public class DriverFor {
	public static void main(String[] args) {
		ListWithIteratorInterface<Integer> integerList = new LinkedListWithIterator<>();
		integerList.add(16);
		integerList.add(4);
		integerList.add(33);
		integerList.add(27);

		for (Integer entry : integerList)
			System.out.print(entry + " ");
		System.out.println();

		Iterator<Integer> iter = integerList.iterator();
		while(iter.hasNext()){
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		
		ArrayListWithIterator<Integer> integerListNew = new ArrayListWithIterator<Integer>();
		integerListNew.add(16);
		integerListNew.add(4);
		integerListNew.add(33);
		integerListNew.add(27);
		
		Iterator<Integer> RevIter = integerListNew.getRevIterator();
		while (RevIter.hasNext()){
			System.out.print(RevIter.next() + " ");
		}
		System.out.println();
		
		
		System.out.println();
		
		ListWithIteratorInterface<String> nameList = new LinkedListWithIterator<>();
		nameList.add("Joe");
		nameList.add("Jess");
		nameList.add("Josh");
		nameList.add("Joy");

		for (String name : nameList)
			System.out.print(name + " ");
		System.out.println();
	} // end main
} // end DriverFor

/*
 * 16 4 33 27 Joe Jess Josh Joy
 */