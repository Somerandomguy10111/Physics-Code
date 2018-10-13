package Tools;
import Classes.*;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

@SuppressWarnings("unused")
public class Methods {

	
	//returns the Integral of f(x)dx
		public static double getIntegral(double[] xlist, double[] ylist){
			double[] deltaxlist = new double[xlist.length-1];
			double partialSum = 0;
			double Integral = 0;
			
			for (int i = 0; i < deltaxlist.length;i++){
				deltaxlist[i] = xlist[i+1]-xlist[i];		
				}
			
			for (int i = 0; i < deltaxlist.length;i++){
				partialSum = deltaxlist[i]*ylist[i];
				Integral += partialSum;
			}
			
			System.out.println(Integral);
			return Integral;
		}
		

	
	
	//returns the Skalarprodukt of Vektor 1 and Vektor 2 as a double
	public static double skalarprodukt(double[] Vektor1, double[] Vektor2){
		double solution = 0;
		
		for (int i =0; i < Vektor1.length;i++){
				solution += Vektor1[i]*Vektor2[i];
		}
		
		return solution;
	}
	
	//returns a list of products of list elements
	public static double[] multiplylists(double[] xlist, double[] ylist){
//		System.out.println("Xlist length: " + xlist.length);
//		System.out.println("Ylist length: " + ylist.length);
		if (xlist.length != ylist.length){
			System.out.println("Length of xlist does not match length of ylist");
			return null;
		}
		
		double[] xylist = new double[xlist.length];
		
		for (int i =0; i < xlist.length;i++){
				xylist[i] = xlist[i]*ylist[i];
		}
		
		return xylist;
	}
	
	//returns an array of the Spaltenvektor of given Spalte
	public static double[] extractSpaltenvektor(Matrix Matrix,int Spalte){
		double[] solution = new double[Matrix.DimY];
		
		for (int i = 0; i < Matrix.DimY;i++){
			solution[i] = Matrix.Matrixarray[i][Spalte];
		}
		
		return solution;
	}
	
	//returns an array of the Zeilenvektor of given Zeile
	public static double[] extractZeilenvektor(Matrix Matrix,int Zeile){
		double[] solution = new double[Matrix.DimX];
		
		for (int i = 0; i < Matrix.DimX;i++){
			solution[i] = Matrix.Matrixarray[Zeile][i];
		}
		
		return solution;
	}
	
	//Matrix[0] = Vektor/0thMatrix, Matrix[1] is applied first and matrix[n-1] is applied last
	public static Matrix sukzessiveMatrixmultiplication(Matrix[] Matrixliste){
		
		Matrix MatrixC = Matrixliste[0];
		for (int i = 0; i < Matrixliste.length-1;i++){
			MatrixC = Matrixmultiplication.Multiplymatrix(Matrixliste[i+1], MatrixC);
			System.out.println(vektorbetrag(extractSpaltenvektor(MatrixC,0)));
		}
		
		return MatrixC;
	}
	
	//return Betrag of Vektor
	public static double vektorbetrag(double[] Vektor){
		double Vektorbetrag = Methods.skalarprodukt(Vektor, Vektor);
		Vektorbetrag = Math.sqrt(Vektorbetrag);
		return Vektorbetrag;
	}
	
	//Outputs a double[] of a column starting at startrow and omitting the last omitlast integers
	public static double[] excelReadcolumn(String filepath, int column, int startrow, int omitlast) {

		
	        Workbook workbook = null;
	        try {
	            workbook = Workbook.getWorkbook(new File(filepath));
	            Sheet sheet = workbook.getSheet(0);
	            
				int ColumnHeigth = sheet.getRows();
	            
	            double[] ExcelReadcolumn = new double[(ColumnHeigth-startrow)];
//	            System.out.println(ColumnHeigth-startrow);
	            for (int i = startrow; i < ColumnHeigth-omitlast;i++){
	            	String cellcontent = sheet.getCell(column, i).getContents();
	            	
	            	String cellcontentpoint = Methods.commatopoint(cellcontent);
	            	
	            	double cellcontentdouble = Double.parseDouble(cellcontentpoint);
	            	
	            	ExcelReadcolumn[i-startrow] = cellcontentdouble;
//	            	System.out.println(cellcontentdouble);
	            }
	            if (workbook != null) {
	                workbook.close();
	            }
	            return ExcelReadcolumn;
	        }

	          catch (IOException e) {
	            e.printStackTrace();
	        } catch (BiffException e) {
	            e.printStackTrace();
	        } finally {

	            if (workbook != null) {
	                workbook.close();
	            }
	        }
	        return null;
	    }
	
	
	   public static void writeExcelcolumn(int coloumn, double[] list, String listname) throws BiffException, IOException, WriteException	   {
	      WritableWorkbook wworkbook;
	      wworkbook = Workbook.createWorkbook(new File("output.xls"));
	      WritableSheet wsheet = wworkbook.createSheet("First Sheet", 0);
	      Label name = new Label(0, 0, listname);
	      wsheet.addCell(name);
	      
	      for (int i = 0; i < list.length;i++){
	    	  Label element = new Label(i+1, 0, Double.toString(list[i]));
	    	  wsheet.addCell(element);
	      }
	      
	      wworkbook.write();
	      wworkbook.close();
	   }
	
	
	   public static void writeExcelrow(int coloumn, double[] list, String listname) throws BiffException, IOException, WriteException	   {
		      WritableWorkbook wworkbook;
		      wworkbook = Workbook.createWorkbook(new File("output.xls"));
		      WritableSheet wsheet = wworkbook.createSheet("First Sheet", 0);
		      Label name = new Label(0, 0, listname);
		      wsheet.addCell(name);
		      
		      for (int i = 0; i < list.length;i++){
		    	  Label element = new Label(0,i+1, Double.toString(list[i]));
		    	  wsheet.addCell(element);
		      }
		      
		      wworkbook.write();
		      wworkbook.close();
		   }
	
	//returns a Decimal point version of a given Comma Numer
	public static String commatopoint(String Commastring) {
		
		String Pointstring = Commastring.replace(",", ".");
		return Pointstring;
		
	}	
	
	public static String pointtocomma(String Commastring) {
		
		String Pointstring = Commastring.replace(".", ",");
		return Pointstring;
		
	}	
	
	//returns a list of squared list elements
	public static double[] squarelistelements (double[] list){
		double[] squarelistelements = new double[list.length];
		for (int i = 0;i < list.length;i++){
			squarelistelements[i] = Math.pow(list[i],2);
		}
		return squarelistelements;
	}
	
	//returns the arithmetic average of a list
	public static double average (double[] list){
		double sum = 0;
		sum = Methods.arraysum(list);
		
		double average = sum/list.length;
		return average;
	}
	
	//returns the sum over of all list elements
	public static double arraysum (double[] list){
			double sum = 0;
			for (double d : list){
				sum += d;
			}
			return sum;
		}
	
	//adds element from minuslist to corresponsing element in pluslist
	public static double[] addlists(double[] xlist,double[] ylist){
		if (xlist.length != ylist.length){
			System.out.println("Length of xlist does not match length of ylist");
			return null;
		}
		
		double[] listfin = new double[xlist.length];
		
		for (int i = 0; i < xlist.length;i++){
			listfin[i] = xlist[i]+ylist[i];
		}
		return listfin;
	}
	
	//subtracts element from minuslist from corresponsing element in pluslist
	public static double[] subtractlists(double[] pluslist,double[] minuslist){
		if (pluslist.length != minuslist.length){
			System.out.println("Length of pluslist does not match length of minuslist");
			return null;
		}
		
		double[] listfin = new double[pluslist.length];
		
		for (int i = 0; i < pluslist.length;i++){
			listfin[i] = pluslist[i]-minuslist[i];
		}
		return listfin;
	}
}
