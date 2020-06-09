/*
Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
If there is no common subsequence, return 0.
Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
Constraints:

1 <= text1.length <= 1000
1 <= text2.length <= 1000
The input strings consist of lowercase English characters only.
*/
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int[][] cache=new int[text1.length()][text2.length()];
        return checkSub(text1,0,text2,0,cache);
    }
    
    public int checkSub(String text1, int index1, String text2, int index2,int[][] cache){
        
        if(index1>=text1.length() || index2>= text2.length()) return 0;
        
        if(cache[index1][index2]!=0) return cache[index1][index2];
        
        int match=0,nomatch=0;
        
        if(text1.charAt(index1)==text2.charAt(index2)){
            match=1+checkSub(text1, index1+1, text2, index2+1, cache);
        }
        else{
            nomatch=Math.max(checkSub(text1, index1, text2, index2+1, cache) ,checkSub(text1, index1+1, text2, index2, cache));
        }
        
        cache[index1][index2]=match+nomatch;
        return cache[index1][index2];
    }
}
