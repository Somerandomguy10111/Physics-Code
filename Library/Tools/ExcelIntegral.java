package Tools;

public class ExcelIntegral {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String filepath = "C:\\Users\\User\\Desktop\\filepath";
		
		double[] Tlist = Methods.excelReadcolumn(filepath, 0, 1,0);
		double[] rotationlist = Methods.excelReadcolumn(filepath, 4, 1,0);
		
		double Umdrehungen = Methods.getIntegral(Tlist,rotationlist)/Math.PI;
		System.out.println(Umdrehungen);
	}
	
	
}