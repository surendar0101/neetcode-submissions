// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        return mergeSortHelper(pairs, 0, pairs.size()-1);
    }

    private List<Pair> mergeSortHelper(List<Pair> pairs, int start, int end) {
        if (end - start + 1 <= 1) return pairs;

        // Find the middle of the array
        int mid = start + (end - start)/ 2;

        // Sort the left half
        mergeSortHelper(pairs, start, mid);

        // Sort the right half
        mergeSortHelper(pairs, mid+1, end);

        // Merge the two sorted halves
        merge(pairs, start, mid, end);
        return pairs;
    }

    private void merge(List<Pair> arr, int s, int m, int e) {
        List<Pair> left = new ArrayList<>(arr.subList(s, m + 1));
        List<Pair> right = new ArrayList<>(arr.subList(m+1, e + 1));
        int i=0; // index for left arr
        int j=0; // index for right arr
        int k = s; // index for arr
        while( i < left.size() && j < right.size()) {
            if (left.get(i).key <= right.get(j).key) {
                arr.set(k, left.get(i));
                i++;
            } else {
                arr.set(k, right.get(j));
                j++;
            }
            k++;
        }

        // One of the halfs has elements
        while(i < left.size()) {
            arr.set(k, left.get(i));
            i++; k++;
        }
        while(j < right.size()) {
            arr.set(k, right.get(j));
            j++; k++;
        }
    }
}
