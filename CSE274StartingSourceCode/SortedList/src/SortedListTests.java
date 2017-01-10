import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class SortedListTests {

	public static Integer [] getIntegerArray(int len)
	{
		Integer [] result = new Integer [len];
		for (int i=0; i<len; i++) {
			result[i] = (int)(Math.random() * 10);
		}
		return result;
	}
	public static boolean check(int len)
	{
		SortedList<Integer> sortedList = new SortedList<>();
		Integer [] originalItems = getIntegerArray(len);
		for (int item : originalItems) {
			sortedList.add(item);
		}
		Arrays.sort(originalItems);
		Comparable<Integer> [] slOutput = sortedList.toArray();	// T [] slOutput causes errors
		return Arrays.equals(originalItems, slOutput);
	}
	@Test
	public void RandomTests() {
		assertTrue(check(0));
		for (int t=0; t<1000; t++) {
			assertTrue(check(1));
			assertTrue(check(2));
			assertTrue(check(3));
			assertTrue(check(20));
		}
	}
	
	/**
	 * Test for RemoveTests - jarvisna
	 */
	@Test
	public void RemoveTests(){
		SortedList<Integer> sortedList = new SortedList<Integer>();
		sortedList.add(20);
		sortedList.add(30);
		sortedList.add(10);
		sortedList.add(40);
		sortedList.remove(30);
		
		SortedList<Integer> sortedListEquals = new SortedList<Integer>();
		sortedList.add(20);
		sortedList.add(10);
		sortedList.add(40);
		assertTrue(Arrays.equals(sortedList.toArray(), sortedListEquals.toArray()));
		
	}

}
