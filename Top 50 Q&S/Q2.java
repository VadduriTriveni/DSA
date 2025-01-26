242. Valid Anagram
==============================================================================================
class Solution {
    public boolean isAnagram(String s, String t) {
      
        if(s.length() != t.length()){
            return false;
        }
        
        int[] count = new int[26];
        
        for(int i=0; i<s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for(int i=0; i<26; i++){
            if(count[i] != 0){
                return false;
            }
        }
        return true; 
    }
}
---------------------------------------------------------------------------------------------
class Solution {
    public boolean isAnagram(String s, String t) {

         if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character,Integer> hs = new HashMap<>();
        for(char ch : s.toCharArray())
        {
            hs.put(ch,hs.getOrDefault(ch, 0)+1);
        }

        for( char ch : t.toCharArray())
        {
            if(!hs.containsKey(ch))
            {
                return false;

            }
            hs.put(ch,hs.get(ch)-1);

            if(hs.get(ch)<0)
            {
                return false;
            }
        }
        
        return true;
    }
}
