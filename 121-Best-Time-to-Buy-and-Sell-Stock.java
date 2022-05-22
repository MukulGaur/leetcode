// Solution 3 - Runtime - 1ms | Time - O(n)

class Solution {
    public int maxProfit(int[] prices) {
        
        int profit=0;
        int minPrice = 1000000;
        
        for(int i=0; i<prices.length; i++){
            if(prices[i]<minPrice)
                minPrice=prices[i];
            else if(prices[i]-minPrice>profit)
                profit=prices[i]-minPrice;
        }
        
        return profit;
        
    }
}

// Solution 2 - Runtime - 4ms | Time - O(n)

class Solution {
    public int maxProfit(int[] prices) {
        
        int left=0, right=1;
        int maxProfit=0;
        
        while(right<prices.length){
            if(prices[left]<prices[right]){
                int profit = prices[right]-prices[left];
                maxProfit=Math.max(maxProfit, profit);
            }
            else
                left=right;
            right++;
        }
        
        return maxProfit;
        
    }
}

// Solution 1 - Time limit exceeded for some test cases | Brute force

class Solution {
    public int maxProfit(int[] prices) {
        
        int res=0;
        
        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j<prices.length; j++){
                int profit = prices[j]-prices[i];
                if(profit>res)
                    res=profit;
            }
        }
        
        return res;
        
    }
}
