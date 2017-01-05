// Polygon.java
// Same as array-based Polygon.java but uses ArrayList instead
// of Java arrays.

import java.util.*;

public class Polygon {
    private ArrayList<Point> vertices;
    
    public Polygon() {
        vertices = new ArrayList<Point>();
        vertices.add(new Point(0,0));
        vertices.add(new Point(1,0));
        vertices.add(new Point(1,1));
    }
    
    /**
     * Creates a standard polygon, centered on the origin. 
     * @param nVerts The number of vertices in the polygon.
     */
    public Polygon(int nVerts) {
        vertices = new ArrayList<Point>();
        double deg = 2 * Math.PI / nVerts;
        final double R = 10;
        for (int i=0; i<nVerts; i++) {
            vertices.add(new Point(R*Math.cos(i*deg), R*Math.sin(i*deg)));
        }
    }   
    
    /**
     * Copy constructor for Polygon class
     * @param poly The Polygon to be copied.
     */
    public Polygon(Polygon poly) {
    	this(poly.vertices);
    }
    
    /**
     * Constructs a Polygon using a collection of points. It is assumed that the collection of
     * points is ordered.
     * @param pts Vertices
     */
    private Polygon(Collection <Point> pts) {
    	vertices = new ArrayList<Point>();
    	for (Point pt : pts) {
    		vertices.add(new Point(pt));
    	}
    }
    
    /**
     * Constructs a polygon from an array of points. A deep copy
     * of the points are created in the newly constructed polygon.
     * @param pts The array of points
     */
    public Polygon(Point[] pts) {
        int len = pts.length;
        vertices = new ArrayList<Point>();
        for (int i=0; i<len; i++)
            vertices.add(new Point( pts[i] ));
    }
    
    /**
     * Creates a Polygon from its string representation
     * @param text The polygon's string representation
     * @return Polygon equivalent to the string representation
     */
    public static Polygon parse(String text) {
    	text = text.substring(1, text.length()-1);
    	String [] tokens = text.split(";");
        int nVerts = tokens.length;
    	Polygon result = new Polygon(nVerts);

        for (int i=0; i<nVerts; i++) {
            result.vertices.set(i, Point.parse(tokens[i]));
        }
        
        return result;
    }
    
    /**
     * Creates a string representation of the polygon
     * @return String representation of polygon
     */
    public String toString() {
    	String result = "";
        for (int i=0; i<numVertices(); i++) {
            Point pt = vertices.get(i);
            result += pt.toString();
            if (i < numVertices() - 1)
            	result += ';';
        }
        return "[" + result + "]";
    }
    
    /**
     * Computes area of polygon
     * @return Area of polygon
     */
    public double area() {
        double sum = 0;
        for (int i=0; i<numVertices()-2; i++) {
            Triangle tri = new Triangle((Point)vertices.get(0), (Point)vertices.get(i+1), (Point)vertices.get(i+2));
            sum += tri.area();
        }
        return sum;
    }
    
    /**
     * Appends a vertex at end of polygon
     * @param newPoint The vertex to be added
     */
    public void addVertice(Point newPoint) {
        vertices.add( vertices.size(), new Point(newPoint) );
    }
    
    /**
     * Computes the number of vertices in the polygon
     * @return Number of vertices 
     */
    public int numVertices() {
        return vertices.size();
    }
    
    /**
     * Calculates and returns the perimeter of the Polygon.
     * @return the perimeter of the Polygon
     */
    public double perimeter(){
    	double perim = 0;
    	for (int i = 0; i < vertices.size() - 1; i++){
    		perim += vertices.get(i).distance(vertices.get(i + 1));
    	}
    	perim += vertices.get(0).distance(vertices.get(vertices.size()-1));
    	return perim;
    }
    
    /**
     * Calculates and returns the isoperimetricQuotient of the polygon (compactness of a polygon).
     * @return the isoperimetricQuotient of the triangle
     */
    public double isoperimetricQuotient(){
    	return 4 * Math.PI * area() / Math.pow(perimeter(), 2);
    }
    
    /**
     * Returns whether or not the current polygon is larger than the other polygon supplied
     * @param other The other polygon to test against
     * @return True if the current polygon is larger, if not, False.
     */
    public boolean isLarger(Polygon other){
    	return area() > other.area();
    }
    
    /**
     * Translate the polygon by given deltas
     * @param deltaX How much to change the X position of each point.
     * @param deltaY How much to change the Y position of each point.
     */
    public void translate(double deltaX, double deltaY){
    	for (Point pt : vertices){
    		pt.move(deltaX, deltaY);
    	}
    }
 }
