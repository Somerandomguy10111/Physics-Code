package Ex;

public class ExB7Nr3b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		double[] vreli = {691,675,745,812,1043};
		double[] v1f = {221,216,237,261,339};
		double[] v2f = {883,861,952,1036,1315};
		
		double[] e = new double[v2f.length];
		double esum = 0;
		double[] vrelf = new double[v2f.length];
		
		for (int i = 0; i < v2f.length;i++){
			vrelf[i] = v2f[i]-v1f[i];
		}
		
		
		for (int i = 0; i < v2f.length;i++){
			e[i] = vrelf[i]/vreli[i];
			esum += e[i];
			System.out.println(e[i]);
		}
		esum = esum/v2f.length;
		System.out.println(esum);
	}

}
