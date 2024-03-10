class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet<Integer> hs = new HashSet<>();
        int i=0,j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                hs.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i]<nums2[j]){
                i++;
            }
            else{
                j++;
            }
        }
        Integer[] resultInteger = hs.toArray(new Integer[hs.size()]);
        int[] result = new int[resultInteger.length];
        for (int k = 0; k < resultInteger.length; k++) {
            result[k] = resultInteger[k];
        }
        return result;
    }
}