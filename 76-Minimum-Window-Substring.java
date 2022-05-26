// Solution 2 - runtime 2ms | time - O(n)

class Solution {
    public String minWindow(String s, String t) {
        int[] need = new int[123];
        int miss = t.length();
        char[] have = s.toCharArray();
        for(char c : t.toCharArray()) need[c]++;
        int i = 0, j = 0, l = 0, r = 0;
        
        while(r < s.length()){
            if(need[have[r]] > 0) miss--;
            need[have[r]]--;
            r++;
            
            while(miss == 0){
                if(j == 0 || (r-l) < (j-i)){
                    j = r;
                    i = l;
                } 
                need[have[l]]++;
                if(need[have[l]] > 0)miss++;
                l++;
            }
        }
        return s.substring(i,j);
    }
}

// Solution 1 - runtime 26ms | time O(n)

class Solution {
    //sliding window
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char x : t.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int matched = 0;
        int start = 0;
        int minLen = s.length() + 1;
        int subStr = 0;
        for (int endWindow = 0; endWindow < s.length(); endWindow++) {
            char right = s.charAt(endWindow);
            if (map.containsKey(right)) {
                map.put(right, map.get(right) - 1);
                if (map.get(right) == 0) matched++;
            }

            while (matched == map.size()) {
                if (minLen > endWindow - start + 1) {
                    minLen = endWindow - start + 1;
                    subStr = start;
                }
                char deleted = s.charAt(start++);
                if (map.containsKey(deleted)) {
                    if (map.get(deleted) == 0) matched--;
                    map.put(deleted, map.get(deleted) + 1);
                }
            }
        }
        return minLen > s.length() ? "" : s.substring(subStr, subStr + minLen);
    }
}
