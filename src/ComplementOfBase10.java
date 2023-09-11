public class ComplementOfBase10 {
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }
        int bits = (int) (Math.floor(Math.log(n) / Math.log(2)) + 1);
        int mask = (1 << bits) - 1;
        return n ^ mask;
    }
}
