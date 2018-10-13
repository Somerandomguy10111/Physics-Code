package SpecificExcercises.Theo;
import Tools.*;
import Classes.*;

@SuppressWarnings("unused")
public class Levicivita {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Levi civita
		int j = 0;
		int k = 0;
		int l = 0;
		int m = 0;
		
		int levicivita = 0;
		int kroneckers = 0;
		
		int levi1 = 0;
		int levi2 = 0;
		
		int kron1 = 0;
		int kron2 = 0;
		int kron3 = 0;
		int kron4 = 0;
		
		for (int i = 0; i < 2;i++){
			for (int i2 = 0; i2 < 2;i2++){
				for (int i3 = 0; i3 < 2;i3++){
					for (int i4 = 0; i4 < 2;i4++){
						j = i;
						k = i2;
						l = i3;
						m = i4;
						
						levi1 = levi(levi1,j,k);
						levi1 = levi(levi2,l,m);
						
						kron1 = kron(kron1,j,l);
						kron2 = kron(kron2,k,m);
						kron3 = kron(kron3,j,m);
						kron4 = kron(kron4,k,l);
						
						kroneckers = kron1*kron2-kron3*kron4;
						levicivita = levi1*levi2;
						
						if (levicivita == kroneckers){
							System.out.println("true");
						}
					}
				}
			}
		}
	}
	
	public static int levi(int levi1,int j, int k){
		
		if (j == k){
			levi1 = 0;
		}
		
		if (j == 1 && k == 2){
			levi1 = 1;
		}
		
		if (j == 2 && k == 1){
			levi1 = -1;
		}
		
		return levi1;
		
	}
	
	public static int kron(int kron,int j, int k){
		
		if (j == k){
			kron = 0;
		}
		
		return kron;
		
	}
}
