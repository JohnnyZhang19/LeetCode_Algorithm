public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int[] count = new int[10];
        int bulls = 0, cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if (s == g) bulls++;
            else {
                if (count[s]++ < 0) cows++;
                if (count[g]-- > 0) cows++;
            }
        }
        return bulls + "A" + cows + "B";  // "1A3B"
    
    }
}
