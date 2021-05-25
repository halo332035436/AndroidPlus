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
