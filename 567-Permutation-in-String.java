// Microsoft interview question
// https://github.com/xizhengszhang/Leetcode_company_frequency
// Solution 2 - runtime 5ms | time O(n)

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        // s1 is our window
        char[] window = s1.toCharArray();
        // System.out.println(window);
        
        int s1Length = s1.length();
        int s2Length = s2.length();
        
        // check constraint - s1 has to be smaller than s2
        if (s1Length >s2Length) {
            return false;
        }
        
        // check constraints for size of strings
        if (s1.isEmpty() || s2.isEmpty() || s1.length() >=100000 || s2.length() >=100000) {
            return false;
        }
        
        // check if they are the same string with 1 element
        if (s2Length == 1) {
            return s1.charAt(0) == s2.charAt(0);
        }
        
        // check right away if it contained with the builtin method
        if(s2.contains(s1)) {
            return true;
        }
        
        // now is the dirty work... create an array for frequency of each letter
        int alphaArray[]  = new int[26];
        
        for (int i=0; i<s1Length; i++) {
            alphaArray[window[i] - 'a']++;
        }
        
        int i=0;
        int j=0;
        
        char char1 = 'a';
        char char2 = 'b';
        
        char[] s2CharArray = s2.toCharArray();
        
        
        while (i < s2Length) {

            while (i < s2Length && j==i && alphaArray[(char1 = s2CharArray[i]) - 'a'] == 0) {
                i++;
                j=i;
            }

            if (s2Length-i < s1Length)
                break;
            
            while (j < s2Length && alphaArray[(char1 = s2CharArray[j]) - 'a'] != 0) {
                alphaArray[char1 - 'a']--;
                j++;
            }
            if (j - i == s1Length)
                return true;
            
            if (j >= s2Length)
                break;

            while(i < j && alphaArray[char1 - 'a'] == 0) {
                alphaArray[(char2 = s2CharArray[i]) - 'a']++;
                i++;
            }
        }
        return false;
    }
}

// Solution 1 - runtime 11ms | time - O(n)

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length()>s2.length()) return false;
        
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];
        
        for(int i=0; i<s1.length(); i++){
            s1Arr[s1.charAt(i)-'a'] += 1;
            s2Arr[s2.charAt(i)-'a'] += 1;
        }
        
        int matches=0;
        
        for(int i=0; i<26; i++){
            matches += (s1Arr[i]==s2Arr[i])? 1 : 0;
        }
        
        int left=0;
        
        for(int right=s1.length(); right<s2.length(); right++){
            if(matches==26)
                return true;
            
            int index = s2.charAt(right)-'a';
            s2Arr[index] += 1;
            
            if(s1Arr[index] == s2Arr[index])
                matches += 1;
            else if(s1Arr[index] + 1 == s2Arr[index])
                matches -= 1;
            
            index = s2.charAt(left)-'a';
            s2Arr[index] -= 1;
            
            if(s1Arr[index] == s2Arr[index])
                matches += 1;
            else if(s1Arr[index] - 1 == s2Arr[index])
                matches -= 1;
            
            left++;
        }
        
        return matches==26;
        
    }
}
