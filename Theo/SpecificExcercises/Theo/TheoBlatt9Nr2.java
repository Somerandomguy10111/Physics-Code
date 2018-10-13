package SpecificExcercises.Theo;

import Tools.Mitternachtsformel;

public class TheoBlatt9Nr2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double alpha = 3;
		double beta = 0.3;
		
		for (int i = -7; i <= 7;i++){
			double c = -i;
			double u1 = Mitternachtsformel.getSolution(beta, -alpha, -c)[0];
			double u2 = Mitternachtsformel.getSolution(beta, -alpha, -c)[1];
			
			double d1 = Math.sqrt(u1);
			double d2 = Math.sqrt(u2);
			
			
		if (d1 < 2){
			System.out.println("d1 = " + d1);
		}
		
		if (d2 < 2){
			System.out.println("d2 = " + d2);
		}
			System.out.println("c = " +c );
			
			
			
//			System.out.println("u = " + u1);
//			System.out.println("u = " + u2);
			
			System.out.println();
		}
	}
}
