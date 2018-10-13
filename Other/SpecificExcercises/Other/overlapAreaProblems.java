package SpecificExcercises.Other;

public class overlapAreaProblems {
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			rngsquare();
			rngcircle();
		}
		
		public static void normalcircle(){
			double avgdistance;
			double distance = 0;
			double xcord;
			double ycord;
			
			
			double imax =  Math.pow(10,7);
			for (int i = 1;i < imax;i++){
				for (int i2 = 1;i < imax;i++){
					xcord = i/imax;
					ycord = (1-xcord)* (i2/imax);
				distance += Math.sqrt(Math.pow(xcord,2)+Math.pow(ycord, 2));
				}
			}
			avgdistance = distance/imax;
			
			
			System.out.println(avgdistance);
		}
		
		public static void normalsquare(){
			double avgdistance;
			double distance = 0;
			double xcord;
			double ycord;
			
			
			double imax =  Math.pow(10,7);
			for (int i = 1;i < imax;i++){
				for (int i2 = 1;i < imax;i++){
					xcord = i/imax;
					ycord = i2/imax;
					distance += Math.sqrt(Math.pow(xcord,2)+Math.pow(ycord, 2));
				}
			}
			avgdistance = distance/imax;
			
			
			System.out.println(avgdistance);
		}
		
		public static void rngsquare(){
			double avgdistance;
			double distance = 0;
			double xcord;
			double ycord;
			
			double imax =  Math.pow(10,7);
			for (int i = 1;i < imax;i++){
				xcord = Math.random();
				ycord = Math.random();
				distance += Math.sqrt(Math.pow(xcord,2)+Math.pow(ycord, 2));
			}
			avgdistance = distance/imax;
			System.out.println(avgdistance);
		}
		
		public static void rngcircle(){
			double avgdistance;
			double distance = 0;
			double xcord;
			double ycord;
			
			
			double imax =  Math.pow(10,7);
			for (int i = 1;i < imax;i++){
					xcord = Math.random();
					ycord = Math.random();
				
					if ((xcord+ycord) > 1){
						i--;
					}
					else {
				distance += Math.sqrt(Math.pow(xcord,2)+Math.pow(ycord, 2));
					}
			}
			avgdistance = distance/imax;
			
			
			System.out.println(avgdistance);
		}
}
