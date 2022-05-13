// Solution 1 - Time Limit Exceeded for some test cases.


class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length()!=t.length()) return false;
        
        HashMap<Character, Integer> setS = new HashMap<>();
        HashMap<Character, Integer> setT = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            char[] sa = s.toCharArray();
            char[] ta = t.toCharArray();
            
            if(!setS.containsKey(sa[i])){
                setS.put(sa[i],1);
            }
            else{
                Integer n = setS.get(sa[i]);
                setS.put(sa[i], n+1);
            }
            
            if(!setT.containsKey(ta[i])){
                setT.put(ta[i],1);
            }
            else{
                Integer n = setT.get(ta[i]);
                setT.put(ta[i], n+1);
            }
        }
        
        for(Character c: setS.keySet()){
            if(!setS.get(c).equals(setT.get(c))) return false;
        }
        
        return true;
        
    }
}
