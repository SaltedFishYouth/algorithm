package cn.lsx.algorithm;

/**
 * KMP匹配
 * @author linShengxi
 * @date 2021/7/3
 */

public class KMP {
    public static int search(String text,String targetText){
        int length = text.length();
        int targetTextLength = targetText.length();
        int[] next = buildNextArr(targetText);
        for (int i : next) {
            System.out.print(i+"->");
        }

        int i = 0,j = 0;
        while (i<length && j<targetTextLength) {
            if (j == -1 || (text.charAt(i) == targetText.charAt(j))) {
                i++;
                j++;
            }else {
                j = next[j];
            }
        }

        if (j==targetTextLength) {
            return i-j;
        }else {
            return -1;
        }
    }
    private static int[] buildNextArr(String str) {
        int[] next = new int[str.length()];
        next[0] = -1;
        int k = -1, j = 0;
        while (j < str.length() - 1) {
            if (k == -1 || str.charAt(j) == str.charAt(k)) {
                ++k;
                ++j;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";

        int search = KMP.search(str1, str2);
        System.out.println(search);//15
    }

}
