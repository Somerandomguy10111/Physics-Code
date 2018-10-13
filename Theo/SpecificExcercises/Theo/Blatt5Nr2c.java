package SpecificExcercises.Theo;
import Tools.*;
import Classes.*;

@SuppressWarnings("unused")
public class Blatt5Nr2c {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double alpha = 1;
		double v = 1;
		double g = 1;
		double x = 1000;
		
		System.out.println("TestIntegral: " + TestIntegral(alpha,v,g,x));
		System.out.println("Integral by approximation: " + EstIntegral(alpha,v,g,x,100000));
//		
	
	}
	
	public static double TestIntegral(double alpha, double v, double g, double x){
		double k = -Math.pow(Math.cos(alpha)*v,2)/g;
		System.out.println("k = " + k);
		
		double z = Math.tan(alpha)+x/k;
		System.out.println("z = " + z);
		
		double zsquared = Math.pow(z, 2);
		double y = Math.log(z+Math.sqrt(1+zsquared));
		System.out.println("y = " + y);
		
//		double dzxy = z+1/(z+Math.sqrt(zsquared+1));
		double dzdy = Math.sqrt(1+zsquared);
		
		double fx =  Math.sqrt(1+zsquared);
		System.out.println("s'(x) = " + fx);
		
		double s = 0.5*k*(y+dzdy*z);
		System.out.println("s = " + s);
		
		double TestIntegral = s;
		return TestIntegral;
	}
	
	public static double EstIntegral(double alpha, double v, double g, double x,int partitions){
		double EstIntegral = 0;
		
		for (int i = 0; i <= partitions;i++){
			
			double xn = i*(x/(double) partitions);
			
			double k = -Math.pow(Math.cos(alpha)*v,2)/g;
			double z = Math.tan(alpha)+xn/k;
			double zsquared = Math.pow(z, 2);
			double fx =  Math.sqrt(1+zsquared);
			
			double deltaA = x/(double)partitions * fx;
			
			EstIntegral += deltaA;
		}
		
		
		return EstIntegral;
	}

}
