class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> {

                int distA = Math.abs(a - x);
                int distB = Math.abs(b - x);

                // Smaller distance first
                if (distA != distB) {
                    return distA - distB;
                }

                // If distance is same, smaller number first
                return a - b;
            }
        );

        // Add all array elements
        for (int num : arr) {
            pq.add(num);
        }

        List<Integer> result = new ArrayList<>();

        // Take k closest elements
        for (int i = 0; i < k; i++) {
            result.add(pq.poll());
        }

        // Answer must be sorted
        Collections.sort(result);

        return result;
    }
}