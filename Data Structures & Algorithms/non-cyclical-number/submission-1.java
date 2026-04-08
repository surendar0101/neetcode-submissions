class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        while (true) {
            slow = getNum(slow); 
            fast = getNum(getNum(fast));
            if (fast == 1)
                return true;

            if (slow == fast)
                break;
        }
        return false;
    }

    private int getNum(int n) {
        int result = 0;
        while (n > 0) {
            int num = n % 10;
            result += num * num;
            n /= 10;
        }
        return result;
    }
}
