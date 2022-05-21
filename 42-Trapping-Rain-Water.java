// Solution 1 - Runtime 1ms
class Solution {
    public int trap(int[] height) {
        
        if(height.length<=2) return 0;
        
        int l=0, r=height.length-1;
        int leftMax=height[l], rightMax=height[r];
        int res=0;
        
        while(l<r){
            if(leftMax<rightMax){
                l++;
                leftMax=Math.max(leftMax, height[l]);
                res += leftMax-height[l];
            }
            else{
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax-height[r];
            }
                
        }
        
        return res;
        
    }
}
