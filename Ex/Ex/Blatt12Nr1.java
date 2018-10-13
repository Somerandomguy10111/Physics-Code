package Ex;

public class Blatt12Nr1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	double ms = 1;
	double rs = 0.15;
	double l = 1.1;
	double g = 9.81;
	double T = 2;
	
	double pisquared = Math.pow(Math.PI,2);
	double gtsquared = g*Math.pow(T, 2);
	
	double alpha = (gtsquared/2*l-4*pisquared*Math.pow(l,2)/3);
	double beta = 4*pisquared*(Math.pow(l+rs,2)*ms+1/2*Math.pow(rs,2)*ms)-gtsquared*(l+rs)*ms;
	
	double ml = beta/alpha;
	System.out.println(ml);
	
	//checking (i know it's right)...
	
	double Tsquared = 4*pisquared *(Math.pow(l,2)/3*ml+Math.pow(l+rs,2)*ms+1/2*Math.pow(rs,2)*ms)/(g*((l/2*ml)+(l+rs)*ms));
	System.out.println(Tsquared);
	
	}
}
