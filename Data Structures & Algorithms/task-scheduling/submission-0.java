class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] countArr = new int[26];
        for (char task: tasks)
            countArr[task - 'A']++;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int count: countArr){
            if (count > 0)
                maxHeap.add(count);
        }
        
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        while (!q.isEmpty() || !maxHeap.isEmpty()) {
            time++;

            if (maxHeap.isEmpty()) {
                time = q.peek()[1];
            } else {
                int count = maxHeap.poll() - 1;
                if (count > 0)
                    q.add(new int[]{ count, time + n});
            }

            if (!q.isEmpty() && q.peek()[1] == time)
                maxHeap.add(q.poll()[0]);
        }
        return time;
    }
}
