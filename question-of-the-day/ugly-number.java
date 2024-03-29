// 263. Ugly Number
class Solution {
    public boolean isUgly(int n) {
        
        if(n<1) return false;
        
        while(n!=1){
            if(n%2==0 || n%3==0 || n%5==0){
                if(n%2==0) n/=2;
                else if(n%3==0) n/=3;
                else n/=5;
            } else return false;
        }
        
        return true;
        
    }
}
