// Solution 1 - runtime 218ms

class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int len = heights.length;
        
        int maxArea = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<=len;){
            int h = (i==len ? 0 : heights[i]);
            if(stack.isEmpty() || h>=heights[stack.peek()]){
                stack.push(i);
                i++;
            }
            
            else{
                int curHeight = heights[stack.pop()];
                int rightBoundary = i-1;
                int leftBoundary = stack.isEmpty() ? 0: stack.peek() + 1;
                int width = rightBoundary - leftBoundary + 1;
                maxArea = Math.max(maxArea, (curHeight*width));
            }
        }
        
        return maxArea;
        
    }
}
