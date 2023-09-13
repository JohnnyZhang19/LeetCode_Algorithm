public class DuplicateZero {
    public void duplicateZeros(int[] arr) {
        if(arr == null || arr.length == 0) {
            return;
        }
        int count = 0;
        int length = arr.length-1;
        int last = length;

        for(int left = 0;  left <= length - count; left++) {
            if(arr[left] == 0) {
                if(left == length - count) {
                    arr[last] = 0;
                    last--;
                    break;
            }
                count++;
            }   
        }
        last = length - count;

        for(int i = last; i >= 0; i--){
            if(arr[i] == 0){
                arr[i+count] = 0;
                count--;
                arr[i+count] = 0;
            }else{
                arr[i+count] = arr[i];
            }
        }
        
    } 
}
