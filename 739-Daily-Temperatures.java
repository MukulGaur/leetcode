

// Solution 1 - time limit exceeded

class Solution {
    public int[] dailyTemperatures(int[] temp) {
        
        int[] ans = new int[temp.length];
        
        for(int i=0; i<temp.length-1; i++){
            int left=0, right=1;
            for(int j=i+1; j<temp.length; j++){
                if(temp[j]<=temp[i])
                    right++;
                else{
                    left++;
                    ans[i]=right;
                    break;
                }
            }
            if(left==0) ans[i]=0;
        }
        
        ans[temp.length-1]=0;
        
        return ans;
        
    }
}
