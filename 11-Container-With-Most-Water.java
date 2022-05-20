// Solution 3 - Runtime 3ms | Time complexity O(n)

class Solution {
    public int maxArea(int[] height) {
        
        int res=0;
        
        int left=0, right=height.length-1;
        
        while(left<right){
            
            int area = Math.min(height[left], height[right])*(right-left);  // area of the container
            
            if(area>res) res=area;
            
            if(height[left]<height[right]) left++;
            else{
                int rightHeight = height[right];
                while(left<right && (height[right]<=rightHeight)) right--;
            }
            
        }
        
        return res;
        
    }
}

// Solution 2 - Runtime 5ms | Time complexity O(n)

class Solution {
    public int maxArea(int[] height) {
        
        int res=0;
        
        int left=0, right=height.length-1;
        
        while(left<right){
            
            int area = Math.min(height[left], height[right])*(right-left);  // area of the container
            
            if(area>res) res=area;
          
//           for changing the pointers decrement or increment which has lesser height, if both are equal change any one left or rigth pointer
            
            if(height[left]<height[right]) left++;
            else right--;
            
        }
        
        return res;
        
    }
}

// Solution 1 - Time Limit Exceeded for some cases | Time complexity O(n^2)

class Solution {
    public int maxArea(int[] height) {
        
        int res=0;
        
        for(int i=0; i<height.length; i++){
            for(int j=i+1; j<height.length; j++){
                int area = Math.min(height[i], height[j]) * (j-i);
                if(area>res)
                    res=area;
            }
        }
        
        return res;
        
    }
}
