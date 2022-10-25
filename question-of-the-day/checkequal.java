// 1662. Check If Two String Arrays are Equivalent
// Date - 25 Oct 2022
// TC - O(n)

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
        int w1 = word1.length;
        int w2 = word2.length;
        
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        
            for(int i=0; i<w1; i++){
                s1.append(word1[i]);
            }
        
            for(int i=0; i<w2; i++){
                s2.append(word2[i]);
            }
        
        return s1.toString().equals(s2.toString());
        
    }
}
