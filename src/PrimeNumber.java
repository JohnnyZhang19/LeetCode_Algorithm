public class PrimeNumber {
    //暴力算法
    public static int bf(int num){
        int count = 0;
        for (int i = 2; i < num; i ++){
            count += isPrime(i) ? 1 : 0;
        }
        return count;
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i ++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
    //埃筛法
    public static int eratosthenes(int num){
        boolean[] isPrime = new boolean[num]; //false is prime
        int count = 0;
        for (int i = 2; i < num; i ++){
            if (!isPrime[i]){
                count++;
                //以i为基数的数标为true
                for (int j = i * i; j < num; j+=i){
                    isPrime[j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(bf(100));
        System.out.println(eratosthenes(100));
    }
}
