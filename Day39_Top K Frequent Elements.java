class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        List<List<Integer>> frequency = new ArrayList<>();
        for (int i = 0; i < nums.length + 1; i++) frequency.add(new ArrayList<Integer>());
        
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            
            frequency.get(value).add(key);
        }
        
        int[] ans = new int[k];
        int i = 0;
        int j = nums.length;
        while (i < k) {
            for (Integer key : frequency.get(j)) {
                ans[i++] = key;
            }
            j--;
        }
        return ans;
    }
}