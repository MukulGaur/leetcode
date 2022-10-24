// 645. Set Mismatch
// Date - 23 Oct 2022
class Solution {
    public int[] findErrorNums(int[] nums) {
        
        int n = nums.length;
        int[] res = new int[n];
        
        for(int i:nums){
            res[i-1]++;
        }
        
        int[] ans = new int[2];
        
        for(int i=0; i<n; i++){
            if(res[i]==2)
                ans[0]=i+1;
            if(res[i]==0)
                ans[1]=i+1;
        }
        
        return ans;
        
    }
}