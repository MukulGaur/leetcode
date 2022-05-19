// Solution 2 - runtime - 28ms

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        if(nums.length<3) return new ArrayList<>();
        
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            
            int l=i+1, r=nums.length-1;
            
            while(l<r){
                int threeSum = nums[i]+nums[l]+nums[r];
                if(threeSum>0)
                    r--;
                else if(threeSum<0)
                    l++;
                else{
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    while(nums[l]==nums[l-1] && l<r)
                        l++;
                }
            }
        }
        
        return res;
        
    }
}

// Solution 1 - Time Limit Exceeded for some testcases!

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        if(nums.length<3) return new ArrayList<>();
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                }
            }
        }
        
        res = new ArrayList < List < Integer >> (new LinkedHashSet < List < Integer >> (res));
        
        return res;
        
    }
}
