package SpecificExcercises.Other;


public class GPS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		distancefunction(0,0,
						 90,0.002);
	}

	
	
	public static double distancefunction (double lat1,double lon1,double lat2,double lon2){
		
		double radius = 6371;
		double alpha1 = Math.toRadians(lat1);
		double alpha2 = Math.toRadians(lat2);
		double dbeta  = Math.toRadians(lon1-lon2);
		
		double cosalpha = 0.5*(Math.cos(alpha1-alpha2)*(Math.cos(dbeta)+1)+Math.cos(alpha1+alpha2)*(Math.cos(dbeta)-1));
		
		System.out.println(cosalpha);
		
		//Angle in radians
		double alphafin = Math.acos(cosalpha);
		
		double distance = alphafin * radius;
		
		System.out.println(alphafin);
		System.out.println(distance);
		
		return distance;
	}
}
	
	//Alpha version
	//Archive
//	double cosalpha = Math.cos(alpha1)*Math.cos(alpha2)*Math.cos(dbeta)+Math.sin(alpha1)*Math.sin(alpha2);
	
//	double cosalpha = Math.cos(alpha1)*Math.cos(alpha2)*(Math.cos(dbeta)+1)-Math.cos(alpha1+alpha2);
	
//	double cosalpha = 0.5*Math.cos(dalpha)*(Math.cos(dbeta)+1)+0.5*Math.cos(alpha1+alpha2)*(Math.cos(dbeta)-1);
	
	
//	double deltax = xcoord1 - xcoord2;
//	double deltay = ycoord1 - ycoord2;
//	double deltaz = zcoord1 - zcoord2;
//	
//	double sumsquares = Math.pow(deltax, 2) + Math.pow(deltay, 2) + Math.pow(deltaz, 2);
//	
//	double cosalpha = 1- 0.5*sumsquares;
	
//	double xcoord1 = Math.sin(beta1) * Math.cos(alpha1);
//	double ycoord1 = Math.sin(alpha1);
//	double zcoord1 = Math.cos(beta1) * Math.cos(alpha1);
//	
//	double xcoord2 = Math.sin(beta2) * Math.cos(alpha2);
//	double ycoord2 = Math.sin(alpha2);
//	double zcoord2 = Math.cos(beta2) * Math.cos(alpha2);
	
//	double cosalpha = xcoord1*xcoord2 + ycoord1*ycoord2 + zcoord1*zcoord2;
	

