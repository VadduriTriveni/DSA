347. Top K Frequent Elements
=============================================================================================
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // Step 2: Create buckets
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : count.keySet()) {
            int freq = count.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        // Step 3: Collect top K elements
        int[] result = new int[k];
        int index = 0;
        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[index++] = num;
                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}
---------------------------------------------------------------------------------------------------------
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        if(k == nums.length){
            return nums;
        }
        
        Map<Integer, Integer> count = new HashMap<>();
        for(int n:nums){
            count.put(n, count.getOrDefault(n,0) +1);
        }
        
        Queue<Integer> heap = new PriorityQueue<>(
            (a,b) -> count.get(a)-count.get(b));
        
        for(int n:count.keySet()){
            heap.add(n);
            if(heap.size() > k){
                heap.poll();
            }
        }
      
        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = heap.poll();
        }
        
        return ans; 
    }
}
