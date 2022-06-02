// Solution 3 - runtime 199ms | TC - O(n)

class Solution {
    public int[] dailyTemperatures(int[] temp) {
        
        int n = temp.length;
        
        int[] res = new int[n];
        
        Stack<Integer[]> stack = new Stack();
        
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && stack.peek()[0]<temp[i]){
                Integer[] tp = stack.pop();
                res[tp[1]] = i-tp[1];
            }
            stack.push(new Integer[]{temp[i],i});
        }
        
        return res;
        
    }
}

// Solution 2 - runtime 2393ms

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int[] ans = new int[temperatures.length];
        
        int left=0, right=1;
        
        while(right<temperatures.length){
            if(temperatures[right]>temperatures[left]){
                ans[left]=right-left;
                left++;
                right=left;
            }
            else if(right==ans.length-1){
                left++;
                right=left;
            }
            right++;
        }
        
        return ans;
        
    }
}

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
