// Solution 1 - runtime 1ms

// Uses backtracking

class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList();
        backtrack(res, "", 0, 0, n);
        return res;
        
    }
    
    private void backtrack(List<String> res, String currentString, int open, int close, int max){
        
        if(currentString.length()==max*2){
            res.add(currentString);
            return;
        }
        
        if(open<max)
            backtrack(res, currentString + "(", open+1, close, max);
        if(close<open)
            backtrack(res, currentString + ")", open, close+1, max);
        
    }
}
