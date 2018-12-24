package algo.swordToOffer;

/**
 * 题目二：0 ~ n-1 中缺失的数字
 */
public class Q053_02_MissingNumber {
    public int getMissingNumber(int[] num, int len){
        if (num == null || len <= 0)
            return -1;

        int left = 0;
        int right = len - 1;
        while (left <= right){
            int mid = (left + right) >> 1;
            if (num[mid] != mid){
                if (mid == 0 || num[mid - 1] == mid - 1)
                    return mid;

                right = mid - 1;
            } else
                left = mid + 1;
        }

        if (left == len)
            return len;

        // 无效输入
        return -1;
    }
}
