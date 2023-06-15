

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        char[] newS = s.toLowerCase().toCharArray ();
        if (newS.length == 1) return true;
        int i = 0, j = newS.length-1;
        while ((i != j) && i < j){
            int num1 = newS[i];
            int num2 = newS[j];
            if (((num1 >= 97 && num1 <= 122) || (num1 >= 48 && num1 <= 57)) &&
                    (((num2 >= 97 && num2 <= 122)) || (num2 >= 48 && num2 <= 57))){
                if(num1 != num2){
                    return false;
                }else{
                    i++;
                    j--;
                }
            }else if((num1 < 97 || num1 > 122) && (((num2 >= 97 && num2 <= 122)) || (num2 >= 48 && num2 <= 57))){
                i++;
            }else if (((num1 >= 97 && num1 <= 122) || (num1 >= 48 && num1 <= 57)) && (num2 < 97 || num2 > 122)){
                j--;
            }else if((num1 < 97 || num1 > 122) && (num2 < 97 || num2 > 122)){
                i++;
                j--;
            }
        }
        return true;
    }
}
