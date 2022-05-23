// Solution 2 - runtime 4ms | time - O(n)
  
  class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int left=0, right=0, res=0;
        
        int[] ch = new int[128];
        
        while(right<s.length()){
            char c = s.charAt(right);
            if(ch[c]>0){
                left = Math.max(left, ch[c]);
            }
            res = Math.max(res, right-left+1);
            ch[c] = ++right;
        }
        
        return res;
        
    }
}

// Solution 1 - runtime 13ms | time - O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashSet<Character> set = new HashSet<>();
        
        char[] ch = s.toCharArray();
        
        int left=0, right=0;
        int res=0;
        
        while(right<ch.length){
            if(!set.contains(ch[right])){
                set.add(ch[right]);
                right++;
            }
            else{
                set.remove(ch[left]);
                left++;
            }
            
            res=Math.max(res, (right-left));
        }
        
        return res;
        
    }
}
