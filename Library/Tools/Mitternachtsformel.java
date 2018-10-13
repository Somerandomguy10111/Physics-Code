package Tools;
import Classes.*;

@SuppressWarnings("unused")

public class Mitternachtsformel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double alpha = 14.05/360*2*Math.PI;
		double v = 25;
		double h = -0.5;
		
		
		double a = -9.81/(Math.pow(Math.cos(alpha),2)*Math.pow(v,2));
		double b = 2*Math.tan(alpha);
		double c = -2*h;
		
		double[] Solution = getSolution(a,b,c);
		
		System.out.println(Solution[0]);
		System.out.println(Solution[1]);
		
	}

	
	public static double[] getSolution(double a, double b, double c){
		
		if (Math.pow(b,2)-4*a*c < 0){
			return null;
		}
		
		double[] solution = {0,0};
		
		solution[0] = (-b + Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a);
		solution[1] = (-b - Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a);
		
		return solution;
	}
	
}
