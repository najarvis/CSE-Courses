// PolygonTester.java
// This class exercises the Polygon class.

import java.util.*;
import java.io.*;

class PolygonTester {
    public static void main(String args[]) {
    	try {
		    Scanner in = new Scanner(new File("polys.txt"));
		    
		    while (in.hasNextLine()) {
		    	String line = in.nextLine();
		    	Polygon poly = Polygon.parse(line);
		    	System.out.println(poly);
		    	System.out.println(poly.area());
		    }
		    
		    in.close();
    	}
    	catch (Exception e) {
    		System.err.println("Problem reading file");
    	}
    }
}
