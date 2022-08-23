package edu.eci.arsw.primefinder;

import java.util.LinkedList;
import java.util.List;


public class PrimeFinderThread extends Thread{
	
	int a,b;
	
	private List<Integer> primes=new LinkedList<Integer>();

	private static long finish = (System.nanoTime() / 1000000000) + 5;

	public PrimeFinderThread(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	public void run(){
		try {
			ciclo();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		terminarThread();
	}
	
	boolean isPrime(int n) {
	    if (n%2==0) return false;
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}

	public  void ciclo() throws InterruptedException {
		while (a<=b && (System.nanoTime() / 1000000000 < finish)){
			if (isPrime(a)){
				primes.add(a);
			}
			a++;
		}
		System.out.println(primes.size());
		epera();
	}

	public void terminarThread() {
		for (int i = a; i <= b; i++) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}
		System.out.println(primes.size());
	}

	public List<Integer> getPrimes() {
		return primes;
	}

	public synchronized void epera() throws InterruptedException {
		wait();
	}

	public  synchronized void ale(){
		notify();
	}
}
