package Tools;
import Classes.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

@SuppressWarnings("unused")
public class Gauss {
	public static void main(String[] args) {

	double[][] matrix = {
			{2,1,-1, 26},
			{3,5,1,  26},
			{2,0,2,  26},
			{1,29, 2}
	};
	
	
      getSolution(matrix);
	}
	
	//Solves the matrix and outputs the solution
	public static double[] getSolution(double[][] matrix){
		double[] solution = {0,0,0};
		
		
		//Downward elimination
		for (int k = 0; k < matrix[1].length;k++){
			for (int i = 0; i < matrix.length-1-k;i++){
				eliminatevariable(matrix[matrix.length-2 -i],matrix[matrix.length-1-i],k);
			}
		}
		
		
		//Upward elimination
		for (int k = 0; k < matrix[1].length-1;k++){
			for (int i = k; i > 0;i--){
				eliminatevariable(matrix[k],matrix[i-1],k);
			}
		}
		
		//Normalize vectors
		for (int k = 0; k < matrix[1].length-1;k++){
			matrix[k] = normalizevector(matrix[k]);
		}
		
		outputmatrix(matrix);
		
		//Get solution vector from matrix
		for (int k = 0; k < matrix[1].length-1;k++){
			solution[k] = matrix[k][matrix[k].length-1];
		}
		
		
		
		System.out.println();
		System.out.println();
		for (double k : solution){
			System.out.println(k);
		}
		
		return solution;
	}
	
	//Subtracts vector1 by vector2
	public static double[] subtract(double[] togetSubtracted, double[] toSubtract){
		
		for (int k = 0;k < toSubtract.length;k++){
			togetSubtracted[k] = togetSubtracted[k] - toSubtract[k];
		}
		
		
		return togetSubtracted;
	}
	
	//Multiplies vector by multiplicant
	public static double[] multiplyvector (double[] vector, double multiplicant){
		for (int k = 0;k < vector.length;k++){
			vector[k] = vector[k] * multiplicant;
		}
		return vector;
	}
	
	//Eliminates nth variable of vector2 gets with vector1
	public static void eliminatevariable(double[] V1,double[] V2,int n){
		

			V1 = multiplyvector(V1, V2[n]/V1[n]);
		
			V2 = subtract(V2,V1);
		}
	
	//Puts coefficient to 1 and rounds the result
	public static double[] normalizevector(double[] vector){
		for (double k : vector){
			if (k != 0){
				vector = multiplyvector(vector,1/k);
				
				
				
				vector[vector.length-1] = round(vector[vector.length-1],8);
				break;
			}
		}
		
		return vector;
	}
	
	//Outputs given matrix in text form
	public static void outputmatrix(double[][] matrix){
		
	for (int i = 0;i < matrix.length;i++){
		for (int k = 0; k < matrix[i].length;k++){	
		if (k == matrix[i].length-1){
			System.out.print("= " + matrix[i][k] + " " );
			}
		else { 
			System.out.print("+ " + matrix[i][k] + " " );
				}
			}
		System.out.println();
		}
	}
	
	//Stock library
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
}