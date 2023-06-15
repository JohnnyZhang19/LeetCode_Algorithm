import java.util.Arrays;

public class MerageSortArray {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3, 5, 7, 9, 0, 0, 0, 0};
        int[] nums2 = new int[]{2, 4, 6, 8};
//        System.out.println(Arrays.toString(merage(nums1,5,nums2,4)));
        System.out.println(Arrays.toString(merage2(nums1, 5, nums2, 4)));
    }

    //时间复杂度： O((n+m)*log(n+m))
    public static int[] merage(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
        return nums1;
    }

    public static int[] merage1(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        int p1 = 0, p2 = 0, p = 0; // p1指向nums1_copy, p2指向nums2, p指向nums1
        while (p1 < m && p2 < n) {
            nums1[p++] = nums1_copy[p1] < nums2[p2] ? nums1_copy[p1++] : nums2[p2++];
        }
        if (p1 < m) {
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
        return nums1;
    }

    public static int[] merage2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, p = m + n - 1; //p是nums1的最后一个下标
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];
        }
        System.arraycopy(nums2,0,nums1,0,p2+1);
        return nums1;
    }
}
