// Solution 3 - Runtime 2ms

class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length()!=t.length()) return false;
        if(s.equals(t)) return true;
        
        char[] res = new char[26];
        
        for(char c: s.toCharArray()) res[c-'a']++;
        
        for(char c: t.toCharArray()){
            if(res[c-'a']--==0) return false;
        }
        
        return true;
        
    }
}

// Solution 2 - Runtime 20ms

// class Solution {
//     public boolean isAnagram(String s, String t) {
        
//         if(s.length()!=t.length()) return false;
        
//         HashMap<Character, Integer> sMap = new HashMap<>();
//         HashMap<Character, Integer> tMap = new HashMap<>();
        
//         for(int i=0; i<s.length(); i++){
//             sMap.merge(s.charAt(i), 1, Integer::sum);
//             tMap.merge(t.charAt(i), 1, Integer::sum);
//         }
        
//         return sMap.equals(tMap);
        
//     }
// }

// Solution 1 - Time Limit Exceeded for some test cases.


// class Solution {
//     public boolean isAnagram(String s, String t) {
        
//         if(s.length()!=t.length()) return false;
        
//         HashMap<Character, Integer> setS = new HashMap<>();
//         HashMap<Character, Integer> setT = new HashMap<>();
        
//         for(int i=0; i<s.length(); i++){
//             char[] sa = s.toCharArray();
//             char[] ta = t.toCharArray();
            
//             if(!setS.containsKey(sa[i])){
//                 setS.put(sa[i],1);
//             }
//             else{
//                 Integer n = setS.get(sa[i]);
//                 setS.put(sa[i], n+1);
//             }
            
//             if(!setT.containsKey(ta[i])){
//                 setT.put(ta[i],1);
//             }
//             else{
//                 Integer n = setT.get(ta[i]);
//                 setT.put(ta[i], n+1);
//             }
//         }
        
//         for(Character c: setS.keySet()){
//             if(!setS.get(c).equals(setT.get(c))) return false;
//         }
        
//         return true;
        
//     }
// }
