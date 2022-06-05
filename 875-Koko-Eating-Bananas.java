class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int left = 1, right = 1000000000;
        
        while(left<=right){
            int mid = left + (right-left)/2;
            
            if(canEatInTime(piles, mid, h))
                right=mid-1;
            else
                left=mid+1;
        }
        
        return left;
        
    }
    
    private boolean canEatInTime(int[] piles, int k, int h){
        int hours = 0;
        for(int i: piles){
            int div = i/k;
            hours += div;
            if(i%k != 0) hours++;
        }
        
        return hours<=h;
    }
}
