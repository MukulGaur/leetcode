// 910. Smallest Range II

class Solution {
    public int smallestRangeII(int[] nums, int k) {
        int n = nums.length;
        if(n==1) return 0;
        
        Arrays.sort(nums);
        
        int mx = nums[n-1], mn = nums[0], res=mx-mn;
        
        for(int i=0; i<n-1; i++){
            mx = Math.max(mx, nums[i]+2*k);
            mn = Math.min(nums[i+1], nums[0]+2*k);
            res = Math.min(res, mx-mn);
        }
        
        return res;
    }
}
