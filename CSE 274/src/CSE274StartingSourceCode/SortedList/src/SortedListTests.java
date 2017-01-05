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

}
