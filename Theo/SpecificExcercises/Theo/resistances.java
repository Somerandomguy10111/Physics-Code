package SpecificExcercises.Theo;
import Tools.*;


public class resistances {

	public static void main(String[] args) {
	double r1 = 5;
	double r2 = 10;
	double r3 = 88;
	
	double Rer = (r1*r2)/(r1+r2) + r3;
	
	double a = -1;
	double b = 2*Rer-r1-r2;
	double c = (r1+r2)*(Rer)-r1*r2;
	
	double[] r3starlist = Mitternachtsformel.getSolution(a, b, c);
	double r3star = r3starlist[1];

	
	double Rer2 = ((r1+r3star)*(r2+r3star))/(r1+r2+2*r3star);
	
	System.out.println("r3star = "  + r3star);
	System.out.println("Rer = " + Rer);
	System.out.println("Rer2 = " + Rer2);
	
	
	}	
}