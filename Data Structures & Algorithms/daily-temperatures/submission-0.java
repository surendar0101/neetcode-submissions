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
        if (futureDay >= temperatures.length) {
            return 0;
        }

        if (temperatures[currentDay] < temperatures[futureDay]) {
            return futureDay - currentDay;
        }

        return findWarmerDay(temperatures, currentDay, futureDay + 1);
    }
}
