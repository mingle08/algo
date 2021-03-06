package algo.codingInterviewChinese2;

/**
 * 最长不含重复字符的子字符串
 * 输入一个字符串（只包含a~z的字符），求其最长不含重复字符的子字符串的长度。
 * 例如对于arabcacfr，最长不含重复字符的子字符串为acfr，长度为4。
 */
public class Q048_LongestSubstringWithoutDup {

    public int maxLength(String str){
        if (str == null || str.length() == 0)
            return 0;

//        int preLength = 0;  // f(i-1)
        int curLength = 0;  // f(i)
        int maxLength = 0;
        int[] pos = new int[26];
        for (int i = 0; i < 26; i++)
            pos[i] = -1;

        for (int k = 0; k < str.length(); k++) {
            int letterVal = str.charAt(k) - 'a';
            if (pos[letterVal] < 0 || k - pos[letterVal] > curLength) {
                curLength++;
            } else {
                if (curLength > maxLength)
                    maxLength = curLength;

                curLength = k - pos[letterVal];
            }
            pos[letterVal] = k;
        }

        if (curLength > maxLength)
            maxLength = curLength;

        return maxLength;
    }

    public static void main(String[] args){
        Q048_LongestSubstringWithoutDup solution = new Q048_LongestSubstringWithoutDup();
        String str = "arabcacfr";
        int cnt = solution.maxLength(str);
        System.out.println(cnt);
    }
}
