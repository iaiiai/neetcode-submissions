// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;

//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        if (pairs.size() < 2) {
            return pairs;
        }
        int mid = pairs.size() / 2;
        List<Pair> left = mergeSort(new ArrayList<>(pairs.subList(0, mid)));
        List<Pair> right = mergeSort(new ArrayList<>(pairs.subList(mid, pairs.size())));
        merge(left, right, pairs);
        return pairs;
    }

    public void merge(List<Pair> left, List<Pair> right, List<Pair> pairs) {
        int l = 0, r = 0, i = 0;
        while (l < left.size() && r < right.size()) {
            if (left.get(l).key <= right.get(r).key) {
                pairs.set(i, left.get(l));
                l++;
            } else {
                pairs.set(i, right.get(r));
                r++;
            }
            i++;
        }
        while (l < left.size()) {
            pairs.set(i, left.get(l));
            l++;
            i++;
        }
        while (r < right.size()) {
            pairs.set(i, right.get(r));
            r++;
            i++;
        }

    }
}
