class Solution {
    Map<Character, String> map;

    public int numDecodings(String s) {

        int n = s.length();

        map = new HashMap<>();

        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(c, String.valueOf(c - 'A' + 1));
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return find(0, s, dp);
    }

    public int find(int i, String s, int[] dp) {

        // Successfully decoded entire string
        if (i == s.length()) {
            return 1;
        }

        // Cannot decode a number starting with 0
        if (s.charAt(i) == '0') {
            return 0;
        }

        // Already calculated
        if (dp[i] != -1) {
            return dp[i];
        }

        int ways = 0;

        // Take one digit
        String one = s.substring(i, i + 1);

        if (map.containsValue(one)) {
            ways += find(i + 1, s, dp);
        }

        // Take two digits
        if (i + 1 < s.length()) {

            String two = s.substring(i, i + 2);

            if (map.containsValue(two)) {
                ways += find(i + 2, s, dp);
            }
        }

        return dp[i] = ways;
    }
}