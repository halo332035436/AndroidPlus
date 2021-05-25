package com.example.algorithm.week1;

public class Solution1 {

    public static void main(String[] args) {

    }

    //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
    //
    //你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
    //
    //你可以按任意顺序返回答案。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/two-sum
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[2];
    }

    //给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
    //
    //所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。

    public String defangIPaddr(String address) {
        char[] chars = address.toCharArray();
        char[] newChars = new char[address.length() + 6];
        int index = 0;
        for (char aChar : chars) {
            if ('.' == aChar) {
                newChars[index++] = '[';
                newChars[index++] = '.';
                newChars[index++] = ']';
            } else {
                newChars[index] = aChar;
                index++;
            }
        }
        return new String(newChars);
    }

    //编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
    //
    //不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
    //
    //你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
    //
    // 
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/reverse-string
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char c = s[i];
            int index = (s.length - 1) - i;
            s[i] = s[index];
            s[index] = c;
        }
    }

    //输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(" ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
