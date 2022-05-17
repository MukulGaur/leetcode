// Solution 1 - RunTime 16ms

class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length==0) return 0;
        
        Arrays.sort(nums);
        
        int count=1;
        int res=1;
        int prev = nums[0];
        
        for(int i=1; i<nums.length; i++){
            if(nums[i] == prev+1)
                count++;
            else if(nums[i]!= prev){
                count=1;
            }
            
            prev=nums[i];
            res = Math.max(count, res);
        }
        
        return res;
        
    }
}
