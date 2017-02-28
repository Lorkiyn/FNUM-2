package Rabbits;

import java.security.SecureRandom;
import java.text.DecimalFormat;

public class Rabbits {

	public static void main(String[] args) {
		SecureRandom rn = new SecureRandom();
		DecimalFormat df = new DecimalFormat("##.####");
		int amount = 1000;
		int onek = 0;
		int twok = 0;
		int thrk = 0;
		double onekP = 0;
		double twokP = 0;
		double thrkP = 0;
		int min = 1;
		int max = 6;
		for(int i = 0; i < amount; i++) {
			boolean one = false;
			boolean thr = false;
			int j1Shot = rn.nextInt(max - min + 1) + min;
			int j2Shot = rn.nextInt(max - min + 1) + min;
			int j3Shot = rn.nextInt(max - min + 1) + min;
			
			if(j1Shot == j2Shot && j1Shot == j3Shot) {
				onek++;
				one = true;
			}
			
			if(j1Shot != j2Shot && j1Shot != j3Shot && j3Shot != j2Shot) {
				thrk++;
				thr = true;
			}
			
			if(!one && !thr) {
				twok++;
			}
		}
		
		onekP = (onek/amount) * 100;
		twokP = (twok/amount) * 100;
		thrkP = (thrk/amount) * 100;
		
		System.out.println("Ein Hase tod: " + df.format(onekP) + "%");
		System.out.println("Zwei Hasen tod: " + df.format(twokP) + "%");
		System.out.println("Drei Hasen tod: " + df.format(thrkP) + "%");
	}

}
