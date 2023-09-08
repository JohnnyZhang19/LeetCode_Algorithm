import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class AddToArrayFormOfInt {
//     The array-form of an integer num is an array representing its digits in left to right order.

// For example, for num = 1321, the array form is [1,3,2,1].
// Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.
        public List<Integer> addToArrayForm(int[] num, int k) {
            List<Integer> list = new ArrayList<>();
            int i = num.length - 1;
            while (i >= 0 || k > 0) {
                if (i >= 0) {
                    k += num[i];
                }
                list.add(k % 10);
                k /= 10;
                i--;
            }
            Collections.reverse(list);
            return list;
    }
}
