// 860. Lemonade Change

class Solution {
    public boolean lemonadeChange(int[] bills) {
        
        if(bills[0]==10 || bills[0]==20) return false;
        
        int[] arr = new int[3];
        
        for(int i:bills){
            if(i==5)
                arr[0]++;
            else if(i==10){
                arr[1]++;
                arr[0]--;
                if(arr[0]<0) return false;
            }
            else{
                arr[2]++;
                if(arr[1]>=1 && arr[0]>=1){
                    arr[1]--;
                    arr[0]--;
                } else if(arr[0]>=3){
                    arr[0] -= 3;
                } else return false;
            }
        }
        
        return true;
        
    }
}
