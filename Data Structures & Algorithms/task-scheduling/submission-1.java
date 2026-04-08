class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] countArr = new int[26];
        // Capture the frequency of each tasks
        for (char task: tasks)
            countArr[task - 'A']++;

        // Build a maxHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int count: countArr) {
            if (count > 0)
                maxHeap.offer(count);
        }

        int time = 0; // Stores total time taken to complete all tasks
        Queue<int[]> q = new LinkedList<>();

        // Run the loop until no tasks are in heap and queue
        while (!q.isEmpty() || !maxHeap.isEmpty()) {
            time++;

            if (maxHeap.isEmpty()) {
                time = q.peek()[1];
            } else {
                int count = maxHeap.poll() - 1;
                if (count > 0)
                    q.add(new int[] {count, time + n});
            }

            if (!q.isEmpty() && q.peek()[1] == time)
                maxHeap.offer(q.poll()[0]);
        }
        return time;
    }
}
