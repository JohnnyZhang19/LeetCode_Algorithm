import java.util.TreeMap;

public class RelativeSortArray {
    /*
     * Example 1:

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int index = 0;
        for(int num: arr2) {
            int count = map.get(num);
            while(count > 0) {
                arr1[index++] = num;
                count--;
            }
            map.remove(num);
        }
        for(int key: map.keySet()) {
            int count = map.get(key);
            while(count > 0) {
                arr1[index++] = key;
                count--;
            }
        }
        return arr1;
    }
}
