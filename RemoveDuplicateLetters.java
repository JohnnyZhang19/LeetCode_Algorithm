public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        if(s.length() == 0) return "";
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        for(char c : s.toCharArray()) count[c - 'a']++;
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            count[c - 'a']--;
            if(visited[c - 'a']) continue;
            while(sb.length() > 0 && c < sb.charAt(sb.length() - 1) && count[sb.charAt(sb.length() - 1) - 'a'] > 0){
                visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(c);
            visited[c - 'a'] = true;
        }
        return sb.toString();
    }

    
}
