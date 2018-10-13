package Ex;

public class ExBlatt8Nr4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		double mp = 2.3 *Math.pow(10,19);
		double R = 6.37*Math.pow(10,6);
		double Ie = 8*Math.pow(10, 37);
		double iks = 0.6666666666666666666*mp*Math.pow(R,2);
		double T0 = 24*3600;
		
		System.out.println(iks);
		
		double deltaT = T0 * (Math.sqrt((Ie+iks)/Ie)-1);
		System.out.println(deltaT);
		
	}

}
