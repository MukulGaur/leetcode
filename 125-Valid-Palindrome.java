// Solution 1 - Runtime 710 ms
class Solution {
    public boolean isPalindrome(String s) {
        
        char[] str = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "").toCharArray();
        
        int i=0, j=str.length-1;
        
        while(i<j){
            if(str[i]!=str[j])
                return false;
            i++;
            j--;
        }
        
        return true;
        
    }
}
