public class BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift; // left << shift is the same as left * (2^shift)
        // because left * (2^shift) is equivalent to left << shift
        // left * (2^shift) is equivalent to left << shift
        // left * (2^shift) is equivalent to left << shift
        // left * (2^shift) is equivalent to left << shift
        // left * (2^shift) is equivalent to left << shift
        // left * (2^shift) is equivalent to left << shift
        // left * (2^shift) is equivalent to left << shift
        // left * (2^shift) is equivalent to left << shift
        // left * (2^shift) is equivalent to left << shift
        // left * (2^shift) is equivalent to left << shift
        // left * (2^shift) is equivalent to left << shift
        // left * (2^shift) is equivalent to left << shift
        // left
    }
    
}
