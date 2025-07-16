import java.util.ArrayList;
import java.util.List;

class Solution {
    public static int countNumbers(int n) {
        if (n < 2) return 0;
        
        int maxPrime = (int) Math.sqrt(n) + 1;
        boolean[] isPrime = new boolean[maxPrime + 1];
        for (int i = 2; i <= maxPrime; i++) {
            isPrime[i] = true;
        }
        
        for (int i = 2; i * i <= maxPrime; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= maxPrime; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= maxPrime; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        
        int count = 0;
        
        // Check for p^8
        for (int p : primes) {
            long power = (long) Math.pow(p, 8);
            if (power <= n) {
                count++;
            } else {
                break;
            }
        }
        
        // Check for p^2 * q^2 where p and q are distinct primes
        int primeCount = primes.size();
        for (int i = 0; i < primeCount; i++) {
            long pSquare = (long) primes.get(i) * primes.get(i);
            if (pSquare > n) break;
            
            for (int j = i + 1; j < primeCount; j++) {
                long qSquare = (long) primes.get(j) * primes.get(j);
                long product = pSquare * qSquare;
                if (product <= n) {
                    count++;
                } else {
                    break;
                }
            }
        }
        
        return count;
    }
}