package Classes;

public class Rotationsmatrix{
	
	public static Matrix RMatrix(double alpha, String dim) {
	
		double cosalpha = Math.cos(alpha);
		double sinalpha = Math.sin(alpha);
		
		if (dim == "x"){
			double[][] Matrixarray = 		{
								{1,0,0},
								{0,cosalpha,sinalpha},
								{0,-sinalpha,cosalpha}
									};
			Matrix Rotationsmatrix = new Matrix(3, 3, Matrixarray);
			return Rotationsmatrix;
									 
		}
		 
		
		if (dim == "y"){
			double[][] Matrixarray = {
								{cosalpha, 0,-sinalpha},
								{  0,	   1,	0	},
								{sinalpha, 0,cosalpha}
									};
			Matrix Rotationsmatrix = new Matrix(3, 3, Matrixarray);
			return Rotationsmatrix;
									 
		}
		
		if (dim == "z"){
			double[][] Matrixarray = {
								{cosalpha, sinalpha, 0},
								{-sinalpha,cosalpha, 0},
								{0,			0,		 1}
									};
			Matrix Rotationsmatrix = new Matrix(3, 3, Matrixarray);
			return Rotationsmatrix;				 
		}
		
		return null;
		
	}
}
