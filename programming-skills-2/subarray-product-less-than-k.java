// 713. Subarray Product Less Than K

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        if(k<=1) return 0;
        
        int res=0, n=nums.length, left=0, product=1;
        
        for(int right=0; right<n; right++){
            product *= nums[right];
            
            while(product>=k){
                product /= nums[left];
                left++;
            }
            
            res += right-left+1;
        }
        
        return res;
        
    }
}
