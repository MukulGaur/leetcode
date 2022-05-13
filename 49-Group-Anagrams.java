Solution 1 - Runtime 6ms

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> res = new ArrayList<>();
        
        if(strs.length==0) return res;
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String s: strs){
            char[] chars = new char[26];
            
            for(char c: s.toCharArray()){
                chars[c-'a']++;
            }
            
            String str = new String(chars);
            
            if(map.get(str)==null){
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(s);
        }
        
        res.addAll(map.values());
        
        return res;
        
    }
}
