class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

       if(n==0) return;
       if(m==0){
            for(int i =0; i<n; i++){
                nums1[i]=nums2[i];
            }
            return;
       }
       int j = 0;
       for(int i = m; i< nums1.length; i++){
            nums1[i] = nums2[j];
            j++;
       }
        var list = Arrays.stream(nums1)
                           .boxed()  // Converts IntStream to Stream<Integer>
                           .collect(Collectors.toList());;
       Comparator<Integer> comp = (k1,k2)-> k1-k2;

        PriorityQueue<Integer> pq = new PriorityQueue<>(comp);
        pq.addAll(list);
        for(int i = 0; i<n+m; i++){
            nums1[i] = pq.poll();
        }
    }
}