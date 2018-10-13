package Ex;

public class ExBlattNr1d {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		double mr = 2* Math.pow(10, 4);
//		double mn = 3* Math.pow(10, 4);
		double g = 9.81;
		double r0 = 6.371 * Math.pow(10,6);
		double repo = r0 + 2 * Math.pow(10,5);
//		double mt2 = 2* Math.pow(10, 4);
		
		double vepo = Math.sqrt(g/repo)*r0;
		double deltav = (Math.sqrt(2)-1)*vepo;
		double vrel = 5 *Math.pow(10, 3);
		
//		double a = 0;
//		double b = 2*Math.pow(Math.E, -deltav/vrel);
//		double c =  Math.pow(Math.E, -deltav/vrel)*(2*mn+1.5*mr+mt2)-(mn+mr);
		
		
//		double a = Math.pow(Math.E, -deltav/vrel);
//		double b = Math.pow(Math.E, -deltav/vrel)*(2*mn+1.5*mr+mt2)-(mn+mr/2);
//		double c =  Math.pow(Math.E, -deltav/vrel)*(mn+mr+mt2)*(mn+mr/2)-(mn+mr)*(mn+mr/2);
		
		
		double a = Math.pow(Math.E, -deltav/vrel);
		double b = Math.pow(Math.E, -deltav/vrel)*110-40;
		double c =  Math.pow(Math.E, -deltav/vrel)*70*40-50*40;
		
		System.out.println(deltav);
		System.out.println(vrel);
		
		
//		double a = -1;
//		double b = -110+Math.pow(Math.E, -deltav/vrel)*40;
//		double c =  Math.pow(Math.E, -deltav/vrel)*50*40-70*40;
		
		double[] mt1 = Tools.Mitternachtsformel.getSolution(a, b, c);
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		
		System.out.println(mt1[0]);
		System.out.println(mt1[1]);
	}

}
