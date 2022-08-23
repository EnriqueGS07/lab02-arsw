package edu.eci.arsw.primefinder;
import javax.management.monitor.Monitor;
import java.util.Scanner;
public class Main {

	private boolean enter = false;
	public static void main(String[] args) throws InterruptedException {

		PrimeFinderThread pft = new PrimeFinderThread(0, 10000000);
		PrimeFinderThread pft2 = new PrimeFinderThread(10000000, 20000000);
		PrimeFinderThread pft3 = new PrimeFinderThread(20000000, 30000000);
		pft.start();
		pft2.start();
		pft3.start();
		Scanner scanr = new Scanner(System.in);
		String imput = scanr.nextLine();
		if(imput == ""){
			pft2.ale();
			pft3.ale();
			pft.ale();

		}
	}
	
}
