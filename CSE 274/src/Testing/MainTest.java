package Testing;

public class MainTest {

	public static void main(String[] args) {
		int[] nums = new int[] {444443, -3436, -66667, 999};
		for (int i : nums){
			System.out.print(i % 5 + ", " + i % 4 + ", " + i % 10);
			System.out.println();
		}

	}

}
