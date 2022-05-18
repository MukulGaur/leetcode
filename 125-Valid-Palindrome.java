// Solution 2 - Runtime 2 ms
class Solution {
    public boolean isPalindrome(String s) {
        
        int i=0, j=s.length()-1; // two pointers to traverse the String
        
        while(i<j){
            
            // check if the character at this pointer is Alpha Numeric, if it is not increment the pointer by one.
            while(i<j && !isAlphaNum(s.charAt(i)))
                i++;
            
            // check if the character at this pointer is Alpha Numeric, if it is not increment the pointer by one.
            while(j>i && !isAlphaNum(s.charAt(j)))
                j--;
            
            // check if the character are equal, if it's not equal then return false
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) 
                return false;
            
            // increment pointers after every traversal
            i++;
            j--;
            
        }
        
        return true;
        
    }
    
    // this method will check if the given character is an Alpha Numeric
    
    private boolean isAlphaNum(char c){
        
        //compare the ASCII value of the character 'c'; This will check if the value is present in this range 'A' | 'a' | '0' and 'Z' | 'z' | '9'
        
        return (((int)'A' <= (int) c && (int) c <= (int)'Z') ||
                ((int)'a' <= (int) c && (int) c <= (int)'z') ||
                ((int)'0' <= (int) c && (int) c <= (int)'9')
          );
    }
}

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
