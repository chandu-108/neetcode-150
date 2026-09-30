class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = 0;
        int j = 0;
        int idx = 0;

        int[] result = new int[m + n];

        while (i < m && j < n) {

            if (nums1[i] <= nums2[j]) {
                result[idx++] = nums1[i++];
            } else {
                result[idx++] = nums2[j++];
            }
        }

        while (i < m) {
            result[idx++] = nums1[i++];
        }

        while (j < n) {
            result[idx++] = nums2[j++];
        }

        // Copy result back into nums1
        for (int k = 0; k < m + n; k++) {
            nums1[k] = result[k];
        }
    }
}