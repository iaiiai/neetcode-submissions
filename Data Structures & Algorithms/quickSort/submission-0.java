// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        quickSortHelper(pairs, 0, pairs.size() - 1);
        return pairs;
    }
    public List<Pair> quickSortHelper(List<Pair> arr, int s, int e) {
        if (e - s + 1 <= 1) {
            return arr;
        }
        Pair pivot = arr.get(e);
        int left = s;
        for (int i = s; i < e; i++) {
            if (arr.get(i).key < pivot.key) {
                Pair tmp = arr.get(left);
                arr.set(left, arr.get(i));
                arr.set(i, tmp);
                left++;
            }
        }
        arr.set(e, arr.get(left));
        arr.set(left, pivot);
        int pivotIndex = left;
        quickSortHelper(arr, s, pivotIndex - 1);
        quickSortHelper(arr, pivotIndex + 1, e);
        return arr;
    }
}
