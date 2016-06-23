import java.util.Random;

public class Solution {
    private static final Random random = new Random();
    
    public void wiggleSort(int[] nums) {
        if (nums.length <= 1) {
        return;
    }
    final int n = nums.length, d = n | 1; // now (1 + 2 * i) % d will go like 1, 3,... wrap-around, 0, 2,...
    int left = 0, right = nums.length - 1, k = n / 2; // note: 0-based k
    // Do quickselect for kth LARGEST element. Use wiggle-indexing to get the answer right away.
    while (true) {
        assert left <= right;
        int p = nums[(1 + 2 * (left + random.nextInt(right - left + 1))) % d];
        int l = left, m = l;
        for (int r = right, lw = (1 + 2 * l) % d, mw = lw, rw = (1 + 2 * r) % d; m <= r; ) {
            if (nums[mw] > p) {
                int tmp = nums[mw];
                nums[mw] = nums[lw];
                nums[lw] = tmp;
                ++l; lw = (lw + 2) % d;
                ++m; mw = (mw + 2) % d;
            } else if (nums[mw] < p) {
                int tmp = nums[mw];
                nums[mw] = nums[rw];
                nums[rw] = tmp;
                --r; rw = (rw - 2 + d) % d;
            } else { // ==
                ++m; mw = (mw + 2) % d;
            }
        }
        if (k < l - left) {
            right = l - 1;
        } else if (k >= m - left) {
            k -= m - left;
            left = m;
        } else {
            // else we got lucky - p is the median
            return;
        }
    }
}
}