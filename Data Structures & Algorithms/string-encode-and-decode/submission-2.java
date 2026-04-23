class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length() + "#" + str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        char[] encoded = str.toCharArray();
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < encoded.length) {
            StringBuilder encodedSize = new StringBuilder();
            while (encoded[i] != '#') { 
                encodedSize.append(encoded[i]);
                i++;
            }
            int wordSize = Integer.parseInt(String.valueOf(encodedSize.toString()));
            int j = i + 1;
            char[] word = new char[wordSize];
            int k = 0;
            while (j < i + wordSize + 1) {
                word[k] = encoded[j];
                k++;
                j++;
            }
            res.add(new String(word));
            i += wordSize + 1;
        }
        return res;
    }
}
