class Solution {
    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false; 
        int[] alphabet = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
            alphabet[t.charAt(i) - 'a']--;
        }

        for (int check : alphabet) {
            if (check != 0) return false;
        }

        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }
            groups.get(key).add(word);
        }
        return new ArrayList<>(groups.values());
    }
}