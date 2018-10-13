package Classes;

public class Bahnkurve {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double x = 0;
		double y = 0;
		double t = 0;
		double tmax = 2*Math.PI;
		double steps = 1000;
		
		
		for (int i = 0; i < steps;i++){
			t = i*tmax/(steps);
			x = Math.cos(t) * (1-Math.cos(t));
			y = Math.sin(t) * (1-Math.cos(t));
			
			System.out.println(x);
//			System.out.println("Y Koordinate: " + y);
//			System.out.println();
		}
		
		System.out.println();
		for (int i = 0; i < steps;i++){
			t = i*tmax/(steps);
			x = Math.cos(t) * (1-Math.cos(t));
			y = Math.sin(t) * (1-Math.cos(t));
			
//			System.out.println("X Koordinate: " + x);
			System.out.println(y);
//			System.out.println();
		}
	}
}
