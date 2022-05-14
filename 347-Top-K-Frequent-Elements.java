// Solution 1 - Runtime 20ms

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> res = new HashMap<>();
        
        int count=0;
        
        for(Integer i: nums){
            res.put(i, res.getOrDefault(i,0)+1);
        }
        
        Integer[][] arr = new Integer[res.size()][2];
        
        int c=0;
        
        for(int i: res.keySet()){
            arr[c][0]=i;
            arr[c][1]=res.get(i);
            c++;
        }
        
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
        
        int[] ans = new int[k];
        int index=arr.length-1;
        
        k--;
        while(k>=0){
            ans[k] = arr[index][0];
            k--;
            index--;
        }
        
        return ans;
        
    }
}
