package Tools;
import Classes.*;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

@SuppressWarnings("unused")
public class LinearRegression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String filename = "C:\\Users\\LiquidSpot\\Desktop\\Data from phyphox (1).xls";
		
		double[] omegalist = Methods.excelReadcolumn(filename, 1, 5,4);
		double[] accelerationlist = Methods.excelReadcolumn(filename, 2, 5, 4);
		
		double[] omegasquaredlist = Methods.squarelistelements(omegalist);
		LinearRegression.getParameters(omegasquaredlist, accelerationlist);
	}
	
	//returnsParameters a and b of a linear regression
	//a = getParameters[0]
	//b = getParameters[1]
	public static double[] getParameters (double[] xlist, double[] ylist){
		double[] parameters = new double[2];
		
		double[] xsquaredlist = Methods.squarelistelements(xlist);
		double[] xylist = Methods.multiplylists(xlist, ylist);
		
		double xBracket = Methods.average(xlist);
		double yBracket = Methods.average(ylist);
		double xyBracket = Methods.average(xylist);
		double xsquaredBracket = Methods.average(xsquaredlist);
		double xBracketsquared = Math.pow(xBracket, 2);
		
//		System.out.println(-xBracket*yBracket+xyBracket);
//		System.out.println(xsquaredBracket-xBracketsquared);
		
		double a = (xyBracket-xBracket*yBracket)/(xsquaredBracket-xBracketsquared);
		double b = yBracket-a*xBracket;
		
//		System.out.println();
		System.out.println("XBracket = " + xBracket);
		System.out.println("YBracket = " + yBracket);
		System.out.println("Regression a = " + a);
		System.out.println("Regression b = " + b);
		
		parameters[0] = a;
		parameters[1] = b;
		
		return parameters;
	}
}
