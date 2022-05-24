// This question was identified as a GOOGLE interview question from here:
// https://github.com/xizhengszhang/Leetcode_company_frequency

// Solution 2 - runtime 4ms | time - O(n)

class Solution {
    public int characterReplacement(String s, int k) {
        
        char[] arr = s.toCharArray();
        int left=0, right=0, maxCount=0, arrLen=arr.length;
        
        int[] alpha = new int[26];
        
        while(right<arrLen){
            alpha[arr[right]-'A']++;
            maxCount = Math.max(maxCount, alpha[arr[right]-'A']);
            while(right-left+1 - maxCount > k)
                alpha[arr[left++]-'A']--;
            right++;
        }        
        
        return s.length()-left;
        
    }
}

// Solution 1 - runtime 69ms | time - O(n)

class Solution {
    public int characterReplacement(String s, int k) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        int res=0, left=0;
        
        for(int right=0; right<s.length(); right++){
            
            char c = s.charAt(right);
            
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            while((right-left+1 - Collections.max(map.values())) > k){
                char ch = s.charAt(left);
                map.put(ch, map.get(ch) - 1);
                left++;
            } 
            
            res = Math.max(res, right-left+1);
            
        }
        
        return res;
        
    }
}
