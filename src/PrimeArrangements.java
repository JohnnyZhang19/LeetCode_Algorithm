import java.util.Arrays;

public class PrimeArrangements {
   private static final int MOD = 1000000007;

    public int numPrimeArrangements(int n) {
        int primeCount = countPrimes(n);
        int nonPrimeCount = n - primeCount;

        return (int) ((factorial(primeCount) * factorial(nonPrimeCount)) % MOD);
    }

    // Count the number of primes <= n
    private int countPrimes(int n) {
        if (n < 2) return 0;
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }

    // Calculate factorial of x % MOD
    private long factorial(int x) {
        long result = 1;
        for (int i = 2; i <= x; i++) {
            result = (result * i) % MOD;
        }
        return result;
    }
}
