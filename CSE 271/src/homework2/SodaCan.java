package homework2;

public class SodaCan implements Measurable{

	double height, radius;
	
	public SodaCan(double height, double radius){
		
		this.height = height;
		this.radius = radius;
	}
	
	public SodaCan(){
		this(50, 5);
	}
	
	public double getSurfaceArea() {
		double base = Math.PI * Math.pow(radius, 2);
		double circumference = Math.PI * 2 * radius;
		return (2 * base) + (circumference * height);
	}
	
	public double getVolume() {
		double base = Math.PI * Math.pow(radius, 2);
		return base * height;
	}

	@Override
	public double getMeasure() {
		return getSurfaceArea();
	}
	
}
