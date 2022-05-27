Solution 2 - runtime 52ms

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {		
	int ans[] = new int[nums.length - k + 1];
	Deque<Integer> q = new LinkedList<>();
    
    int i = 0;
    int j = 0;
    
    while(j < nums.length){
        // calculation
        if(q.size() == 0){
            q.add(nums[j]);
        }
        else{
            while(q.size() > 0 && q.peekLast() < nums[j]){
                q.removeLast();
            }
            q.add(nums[j]);
        }
        // now move j pointer
        if(j - i + 1 < k) j++;
        // if we hit the window size
        else if(j - i + 1 == k){
            // answer -> calculation;
            ans[i] = q.peek();
            // slide the window
            // calculation
            if(nums[i] == q.peek()){
                q.removeFirst();
            }
            // now slide the pointer
            i++;
            j++;
        }
    }
    return ans;
}
}

Solution 1 - time limit exceeded

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        List<Integer> lst = new ArrayList<>();
        
        int left=0, right=k-1;
        
        while(right<nums.length){
            int[] arr = new int[k];
            Integer max = Integer.MIN_VALUE;
            int i=left, counter=0;
            while(i<=right){
                arr[counter]=nums[i];
                max = Math.max(max, arr[counter]);
                counter++;
                i++;
            }
            
            lst.add(max);
            left++;
            right++;
            
        }
        
        int[] res = new int[lst.size()];
        int j=0;
        
        for(Integer i: lst){
            res[j++]=i;
        }
        
        return res;
        
    }
}
