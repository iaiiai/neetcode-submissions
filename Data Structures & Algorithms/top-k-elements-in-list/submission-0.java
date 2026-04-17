class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int number : nums) {
            counts.put(number, counts.getOrDefault(number, 0) + 1);
        } 
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(counts.entrySet());
        list.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());
        Map<Integer, Integer> sortedCounts = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            sortedCounts.put(entry.getKey(), entry.getValue());
        }
        List<Integer> ansRaw = new ArrayList<>();
        Set<Integer> numbers = sortedCounts.keySet();
        int counter = 0;
        for (int number : numbers) {
            if (counter >= k) break;
            ansRaw.add(number);
            counter++;
        }
        int[] ans = new int[ansRaw.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = ansRaw.get(i);
        }
        return ans;
    }
}