// Solution 2 - RunTime 2ms

class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] ans = new int[nums.length];
        int prefix=1, postfix=1;
        
        for(int i=0; i<nums.length; i++){
            ans[i]=prefix;
            prefix*=nums[i];
        }
        
        for(int i=nums.length-1; i>=0; i--){
            ans[i]*=postfix;
            postfix*=nums[i];
        }
        
        return ans;
        
    }
}

//Solution 1 - Time Limit Exceeded for some test cases

class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] ans = new int[nums.length];
        
        for(int i=0; i<nums.length; i++){
            int n=0;
            int sum=1;
            while(n<nums.length){
                if(n==i){
                    n++;
                    continue;
                }
                else{
                    sum = sum * nums[n];
                }
                n++;
            }
            ans[i]=sum;
        }
        
        return ans;
        
    }
}
