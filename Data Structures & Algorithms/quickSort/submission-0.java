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
        sortHelperFn(pairs, 0, pairs.size() - 1);
        return pairs;
    }

    private void sortHelperFn(List<Pair> pairs, int s, int e) {
        if( e - s + 1 <= 1) {
            return;
        }

        Pair pivot = pairs.get(e);
        int left = s;

        for (int i=s; i< e; i++) {
            if (pairs.get(i).key < pivot.key) {
                Pair temp = pairs.get(i);
                pairs.set(i, pairs.get(left));
                pairs.set(left, temp);
                left++;
            }
        }

        pairs.set(e, pairs.get(left));
        pairs.set(left, pivot);

        sortHelperFn(pairs, s, left - 1);
        sortHelperFn(pairs, left + 1, e);
    }

}
