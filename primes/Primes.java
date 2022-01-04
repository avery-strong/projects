import java.util.ArrayList;
import java.text.NumberFormat;

public class Primes implements Runnable{
	public Primes(){}
	public Primes(int lower, int upper){
		this.lower = lower;
		this.upper = upper;
	}

	protected void addPrimes(int lower, int upper){
		if(lower == 0 || lower == 1) lower = 2;		// 0 and 1 are not considered primes

		for(int i=lower; i<upper; i++)
			if(isPrime(i)) primes.add(i);
	}

	public int numberOfPrimes(){ return primes.size(); }
	public int getPrimes(int i){ return primes.get(i); }
	
	public boolean isPrime(int number){
		for (int i=2; i<=number/2; i++)
        	if (number%i == 0) return false;

		return true;
	}

	@Override
	public void run(){ }

	public static void main(String[] args){
		int lower = 1;
		int sumPrimes = 0;
        int[] array = {
        	100,
        	200,
        	300,
        	400,
        	500,
        	600,
        	700,
        	800,
        	900,
        	1000
        };
        ArrayList<Thread> threads = new ArrayList<>();

        Primes primes = new Primes();

        for(int upper : array){
        	threads.add(new Thread(() -> primes.addPrimes(lower, upper)));
        	lower += upper;
        }


        for(Thread t : threads)
        	t.start();

        for(int i=0; i<numberOfPrimes(); i++)
        	sumPrimes += primes.getPrimes(i);
    }


    private int lower;
	private int upper;
	private ArrayList<Integer> primes;
}