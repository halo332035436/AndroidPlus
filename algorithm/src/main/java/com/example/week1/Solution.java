package com.example.week1;

public class Solution {

    public static void main(String[] args) {

    }

    //给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
    //
    //说明：本题中，我们将空字符串定义为有效的回文串。
    public boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer sgood_rev = new StringBuffer(sb).reverse();
        return sb.toString().equals(sgood_rev.toString());
    }

    //给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
    //
    //回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/palindrome-number
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public boolean isPalindrome(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    //给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
    //
    //单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/length-of-last-word
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int lengthOfLastWord(String s) {
        if (s == null || s.equals("")) return 0;
        char[] chars = s.toCharArray();
        int lastIndex = chars.length - 1;
        while (lastIndex >= 0) {
            if (chars[lastIndex] != ' ') break;
            lastIndex--;
        }
        if (lastIndex <= 0) return 0;
        int firstIndex = lastIndex - 1;
        while (firstIndex >= 0) {
            if (chars[firstIndex] == ' ') break;
            firstIndex--;
        }
        return lastIndex - firstIndex;
    }

    //请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            if (ch == ' ') {
                sb.append("%20");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    //字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
    // 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
    // 该函数将返回左旋转两位得到的结果"cdefgab"。
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < chars.length; i++) {
            sb.append(chars[i]);
        }
        for (int i = 0; i < n; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    //给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
    //
    //不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int index1 = 1;
        int index2 = 1;
        while (index2 < nums.length) {
            if (nums[index1 - 1] != nums[index2]) {
                nums[index1] = nums[index2];
                index1++;
            }
            index2++;
        }
        return index1;
    }

}
