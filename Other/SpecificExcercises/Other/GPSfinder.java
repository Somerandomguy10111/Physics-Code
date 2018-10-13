package SpecificExcercises.Other;

public class GPSfinder {
	
	GPSfinder(){
		
	}
	
	class Point{
		double x = 0;
		double y = 0;
		double z = 0;
		
		Point(double x,double y,double z){
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		Point(){
		}
	}
	
    public static Point coordfinder(double lat,double lon){
    	double alpha1 = lat*2*Math.PI/360;
    	double beta1  = lon*2*Math.PI/360;
    	
    	GPSfinder fido = new GPSfinder();
    	Point Point = fido.new Point();
    	
    	Point.x = Math.sin(beta1) * Math.cos(alpha1);
    	Point.y = Math.sin(alpha1);
    	Point.z = Math.cos(beta1) * Math.cos(alpha1);
    	
    	return Point;
 }
    
    
    public static double[] pointtovector(Point point,double sumequals){
    	double[] vector = new double[4];
    	vector[0] = point.x;
    	vector[1] = point.y;
    	vector[2] = point.z;
    	vector[3] = sumequals;
    	
    	return vector;
    }
    
    public static Point vectortopoint(double[] vector){
    	GPSfinder fido = new GPSfinder();
    	Point Point = fido.new Point();
    	
    	return Point;
    }
	
public static void main(String[] args) {
	// TODO Auto-generated method stub
		//radius of the earth
		double radius = 6371;
		
		//Amsterdam
		double lat1      = 52.379189;
		double lon1      = 4.899431;
		double distance1 = 465;
		//450
		
		//San Francisco
		double lat2      =  37.733795;
		double lon2      = -122.446747;
		double distance2 = 9243;
		//9400
		
		//London
		double lat3      = 51.508530;
		double lon3      = -0.076132;
		double distance3 = 669;
		//854
		
		Point Point1 = coordfinder(lat1,lon1);
		Point Point2 = coordfinder(lat2,lon2);
		Point Point3 = coordfinder(lat3,lon3);
		
		double[][] matrix = {pointtovector(Point1,Math.cos(distance1/radius))
							,pointtovector(Point2,Math.cos(distance2/radius))
							,pointtovector(Point3,Math.cos(distance3/radius))};
		
		
		Point Pointfin = vectortopoint(Tools.Gauss.getSolution(matrix));
		
		System.out.println();
		System.out.println(Pointfin.x);
		System.out.println(Pointfin.y);
		System.out.println(Pointfin.z);
		
		double latfin = Math.asin(Pointfin.y);
		double lonfin = Math.asin(Pointfin.x/Math.cos(latfin));
		
		System.out.println();
		System.out.println("Latitude  is: " + latfin/(2*Math.PI)*360);
		System.out.println("Longitude is: " + lonfin/(2*Math.PI)*360);
		

	}
}

