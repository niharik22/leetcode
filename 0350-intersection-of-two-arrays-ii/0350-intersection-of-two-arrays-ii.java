class Solution {
    
    public int[] intersect(int[] nums1, int[] nums2) {
        
      Arrays.sort(nums1);
      Arrays.sort(nums2);
      ArrayList<Integer> result = new ArrayList<>();
      int i = 0;
      int j = 0;
      while(i< nums1.length && j<nums2.length){
        if(nums1[i]==nums2[j]){
            result.add(nums1[i]);
            i++;
            j++;
        } else if(nums1[i]>nums2[j]){
            j++;
        } else if(nums1[i]<nums2[j]){
            i++;
        }
      }
     
     int[] intersection = result.stream().filter(n->n!=null).mapToInt(n->n).toArray();
     return intersection;
    }
}