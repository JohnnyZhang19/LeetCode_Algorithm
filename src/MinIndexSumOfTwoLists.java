import java.util.ArrayList;
import java.util.List;
public class MinIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int min = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (i + j < min) {
                        min = i + j;
                        res.clear();
                        res.add(list1[i]);
                    } else if (i + j == min) {
                        res.add(list1[i]);
                    }
                }
            }
        }
        return res.toArray(new String[res.size()]);
    
    }
}
