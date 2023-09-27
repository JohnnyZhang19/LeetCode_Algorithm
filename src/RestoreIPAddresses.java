import java.util.List;
import java.util.ArrayList;

public class RestoreIPAddresses {
    /*
     * A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.

For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        restoreIpAddresses(s, 0, "", result);
        return result;
    }

    private void restoreIpAddresses(String s, int index, String temp, List<String> result) {
        if (index == 4) {
            if (s.length() == 0) {
                result.add(temp);
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (s.length() >= i) {
                String sub = s.substring(0, i);
                if (isValid(sub)) {
                    restoreIpAddresses(s.substring(i), index + 1, temp + sub + (index == 3 ? "" : "."), result);
                }
            }
        }
    }

    private boolean isValid(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }
}
