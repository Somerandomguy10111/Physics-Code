package SpecificExcercises.Theo;


public class Complexnumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		double a  = 0;
		double amax = 2;
		
		for (int i = -10; i <= 20;i++){
			a = amax*i/10;
			double b = Math.sqrt(2*a-Math.pow(a,2)+8);
			
			System.out.println("a = " + a);
			System.out.println("b = " + b);
			System.out.println();
		}
	}
}
