package GBI;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int k1 = 1;
		int k2 = 1;
		int k3 = 0;
		int it = 10;
		
		if (it > 0){
		System.out.println(k1);
		}
		
		if (it > 1){
			System.out.println(k1);
			}
		
		for (int i = 0; i < it;i++){
			
			if (it > 1){
			k3 = k2;
			k2 = k1+k2;
			k1 = k3;
			}
			System.out.println(k2);
		}
		
	}

}
