class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
       int i = 0, j = 0;
        int minCommonElement = Integer.MAX_VALUE;
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                minCommonElement = Math.min(minCommonElement, nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        
        if (minCommonElement == Integer.MAX_VALUE) {
            return -1;
        }
        
        return minCommonElement;
    }
}