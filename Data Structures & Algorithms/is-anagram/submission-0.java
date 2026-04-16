class Solution {
    public boolean isAnagram(String s, String t) {
       HashMap<Character, Integer> lettersS = new HashMap<Character, Integer>();
       HashMap<Character, Integer> lettersT = new HashMap<Character, Integer>();
       char[] sArr = s.toCharArray();
       char[] tArr = t.toCharArray();  
       if (sArr.length != tArr.length) return false;
       for (char c : sArr){
        lettersS.put(c, lettersS.getOrDefault(c, 0) + 1);
       }
       for (char c : tArr) {
        lettersT.put(c, lettersT.getOrDefault(c, 0) + 1);
       }
       for (char c : sArr) {
        int sCount = lettersS.getOrDefault(c, 0);
        int tCount = lettersT.getOrDefault(c, 0);
        if (sCount != tCount) {
            return false;
        }
       }
       return true;
    }
}