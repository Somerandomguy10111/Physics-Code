package Ex;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class ExBlatt7Nr1b {
	public static void main(String[] args) throws BiffException, WriteException, IOException {
		// TODO Auto-generated method stub
		
		
		double mr = 2* Math.pow(10, 4);
		double mn = 3* Math.pow(10, 4);
		double g = 9.81;
		double r0 = 6.371 * Math.pow(10,6);
		double repo = r0 + 2 * Math.pow(10,5);
		double mt2 = 2* Math.pow(10, 4);
		
		double vepo = Math.sqrt(g/repo)*r0;
		double deltav = (Math.sqrt(2)-1)*vepo;
		double vrel = 5 *Math.pow(10, 3);
		
//		double ssmt = Math.pow(Math.E,deltav/vrel)*(mr+mn)-mr-mn;
				
		double msmt1 = (Math.pow(Math.E,deltav/vrel)*(mr/2+mn)-2*mn-1.5*mr-2*mt2)/2;
		
		System.out.println(msmt1);
		
	}
}
