import java.util.ArrayList;

import java.util.*;

public class PascalTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for(int i = 1; i <= rowIndex; i++){
            row.add((int)((long)row.get(i-1)*(rowIndex - (i-1))/(i)));
        }
        return row;
    }
}

/*
This solution uses the fact that each entry in Pascal's triangle is a combination (rowIndex choose i) 
for i in [0, rowIndex]. Therefore, the i-th entry in a row can be calculated as
 row[i] = row[i-1] * (rowIndex - i + 1) / i, 
 which saves us the extra space that would be required if we calculate Pascal's triangle row by row.

The time complexity of this algorithm is O(rowIndex) as we have to calculate each element in the target row,
 and the space complexity is also O(rowIndex) as we need to store the elements in the target row.

 The (int)((long)row.get(i - 1) * (rowIndex - (i - 1)) / (i)) is used to avoid integer overflow.
 */
