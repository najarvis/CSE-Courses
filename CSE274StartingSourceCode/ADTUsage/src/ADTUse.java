// ADTUse.java

import java.util.*;

public class ADTUse {
	public static void exercise(Set<String> items)
	{
		items.add("Hello");
		items.add("Hello");
		items.add("World");
		items.add("Hello");
		items.remove("someword");
		items.add("someword");
		items.add("someword");
		System.out.println("Size: " + items.size());
		items.clear();
		System.out.println("Size: " + items.size());
	}
	
	public static void main(String[] args) {
		HashSet<String> hsItems = new HashSet<>();
		exercise(hsItems);
		TreeSet<String> tsItems = new TreeSet<>();
		exercise(tsItems);	
	}

}
