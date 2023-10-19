import java.util.Stack;
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        Stack<Character> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() > c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.toString();
    
    }
}
