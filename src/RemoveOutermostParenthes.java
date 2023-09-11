public class RemoveOutermostParenthes {
    public String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' && count++ > 0) {
                sb.append(s.charAt(i));
            }
            if (s.charAt(i) == ')' && count-- > 1) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
