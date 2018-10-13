package SpecificExcercises.Theo;

public class TheoBlatt9Nr4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double xrange = 3;
		double yrange = 3;
		
		for (int i = -3; i <= 3;i++){
			for (int i2 = -3; i2 <= 3;i2++){
				double x = xrange*i/3;
				double y = yrange*i2/3;
				
				System.out.println("x Koord = " + x);
				System.out.println("y Koord = " + y);
				
				System.out.println("x Value = " + -y);
				System.out.println("y Value = " + x);
				
				System.out.println();
				
			}
		}
	}

}
