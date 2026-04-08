class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            result[i] = findWarmerDay(temperatures, i , i+1);
        }
        return result;
    }

    public int findWarmerDay(int[] temperatures, int currentDay, int futureDay) {
        // should return 0 for last day and should stop the recursion
        if (futureDay >= temperatures.length) {
            return 0;
        }

        // if the current day temperature is smaller than future day
        // then find the difference between the days
        if (temperatures[currentDay] < temperatures[futureDay]) {
            return futureDay - currentDay;
        }

        // recurse through the future days
        return findWarmerDay(temperatures, currentDay, futureDay + 1);
    }
}
