package SpecificExcercises.Other;

public class investmentstart {
	public static void main(String[] args) {
		
//		double p = 0.55;
		double start = 10;
		double goal = 1000;
		int jmax = 10;
		int imax = 2000;
		
		
		double[] bestxlist = new double[50];
		
		int partitions = 500;
		
		for(double i = 0;i < partitions;i++){
			bestxlist[(int) i] = findbestx(0.5 + (i+1)/(2*partitions),start,goal,imax,jmax);
		}
		
		for(double i = 0;i < 50;i++){
			//times 1000 for excel
			System.out.println(bestxlist[(int) (int) i] * 1000);
		}
	}	
	

	//Divide listnofx in imax/10 subarrays
	//Currently only works for arrays of length divisible by 100
 	public static double findbestx (double p, double start, double goal,double imax, double jmax){
 		
 		
 		int grouplenght = 5;
 		int groupamount = (int) imax/5;
 		
 		int[][] subgroup = new int[grouplenght][groupamount];
 		int[]   nofgroup = new int[groupamount];
 		double bestx = 0;
 		
 		int[] listnofx = listnofx(p,start,goal,(int) imax,(int) jmax);
 		
 		for (int i = 0; i < groupamount;i++){
				for (int j = 0; j < grouplenght;j++){
				subgroup[j][i] = listnofx[i*grouplenght+j];
			}
		}
 		
 		
 			for (int i = 0; i < groupamount;i++){
 				for (int j = 0; j < grouplenght;j++){
 				nofgroup[i] += subgroup[j][i];
 			}
 		}
 			
 			int nofbestgroup = nofgroup[0];
			int iofbestgroup = 0;
			
 			for (int i = 0; i < 100;i++){
 				
 				
 				if (nofgroup[i] < nofbestgroup){
 					iofbestgroup = i;
 					nofbestgroup = nofgroup[i];
 				}
 				
// 				System.out.println("Sum of n: " + nofgroup[i]);
 			}
 			
 			
 			bestx = ((iofbestgroup* grouplenght +(1+iofbestgroup) * grouplenght)/2)/imax;
 			System.out.println("Best x for win probablity of " + p +" found is: " + bestx);
 			
 			
 		return bestx;
 		
		}

 	public static int[] listnofx (double p, double start, double goal,int imax, int jmax){
	 
	  double[][] datapoints = new double[imax][jmax+1];
	 
	 // jmax = amount of diffrent loops with some x
	 // imax = amount of diffrent x tried
	 // n = iterations needed to reach goal
	 // p = propability
	 // x = multiplier
	 // start = starting money
	 // goal  = money required for stop
	 // c = currentmoney
	 
	 
	 	datapoints = datapoints(datapoints,start,goal,p,imax,jmax);
		
	 	return averageoverj(datapoints,imax,jmax);
}
	
 	//datapointavg should be double but isnt due to excel being not okay with double
	public static int[] averageoverj (double[][] datapoints,int imax, int jmax){
		int[] datapointavg = new int[imax];
		
		
		for (int i = 0; i < imax;i++){	
			for (int j = 0; j < jmax;j++){
				datapointavg[i] += datapoints[i][j];
					
				}
				datapointavg[i] = Math.round(datapointavg[i]/jmax);
//				System.out.println(datapointavg[i]);
			}
		
		return datapointavg;
	}

	public static int findn (double start, double goal, double p, double multiplier){
	int iterator = 0;
	
	// c = currentmoney
	double c = start;
		
	while (c < goal && iterator < 100000) {
		
		if (Math.random() < p){
			c = c * (1+ 0.9* multiplier);
		}
		
		else {
			c = c *  (1 - multiplier);
			
		}
//		System.out.println(c);
		iterator++;
			}
		return iterator;
		}	
	
	public static double[][] datapoints(double[][] datapoints, double start,double goal, double p, int imax, int jmax){
		
		for (double j = 0; j < jmax;j++){
			for (double i = 0; i < imax;i++){
			
			//x = multiplier
			double multiplier = i/imax;
//			System.out.println("Multiplier " + multiplier);
			
			//n = amount of iterations needed to reach goal
			int n = findn(start,goal,p,multiplier);
			
//			System.out.println(n);
			
			datapoints[(int) i][(int) j] = n;
			}
		}
		
		return datapoints;
	}
	
}
