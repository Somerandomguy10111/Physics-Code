package Classes;

public class Matrix {

	public double[][] Matrixarray = new double [0][0];
	public int DimX = 0;
	public int DimY = 0;
	
	public Matrix (int DimX, int DimY, double[][] Matrixarray){
		this.Matrixarray = Matrixarray;
		this.DimX = DimX;
		this.DimY = DimY;
	}
}
