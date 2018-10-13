package SpecificExcercises.Theo;

public class DglRichungsfeld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double x = 0;
		double y = 0;
		
		double minusbound = 3;
		double intervall = 6;
		
		for (int i = 0;i < intervall;i++){
			for (int i2 = 0;i2 < intervall;i2++){
				x = i-minusbound;
				y = i2-minusbound;
				
				double ystrich = -x*y;
				System.out.println("x = "+ x);
				System.out.println("y = "+ y);
				System.out.println("ystrich = " + ystrich);
				System.out.println();
			}
		}
		
	}

}
