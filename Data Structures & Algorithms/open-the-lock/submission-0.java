class Solution {

    public void fillNeighbors(Queue<String> q, StringBuilder currBuilder, Set<String> deads) {
        for (int i = 0; i < 4; i++) {
            char ch = currBuilder.charAt(i);

            char dec = (ch == '0') ? '9' : (char) (ch - 1);
            char inc = (ch == '9') ? '0' : (char) (ch + 1);

            // Decrease
            currBuilder.setCharAt(i, dec);
            String decStr = currBuilder.toString();
            if (!deads.contains(decStr)) {
                deads.add(decStr);
                q.offer(decStr);
            }

            // Increase
            currBuilder.setCharAt(i, inc);
            String incStr = currBuilder.toString();
            if (!deads.contains(incStr)) {
                deads.add(incStr);
                q.offer(incStr);
            }

            // Restore original character
            currBuilder.setCharAt(i, ch);
        }
    }

    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();

        for (String dead : deadends) {
            deads.add(dead);
        }

        String start = "0000";

        if (deads.contains(start)) {
            return -1;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(start);
        deads.add(start); // Mark as visited

        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                String curr = q.poll();

                if (curr.equals(target)) { // Correct comparison
                    return level;
                }

                fillNeighbors(q, new StringBuilder(curr), deads);
            }

            level++;
        }

        return -1;
    }
}