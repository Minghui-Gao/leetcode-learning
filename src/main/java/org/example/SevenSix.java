package org.example;

import java.util.HashMap;
import java.util.Map;

public class SevenSix {
    /*
    Given two strings s and t of lengths m and n respectively, return the minimum window
    substring of s such that every character in t (including duplicates) is included in the window.
    If there is no such substring, return the empty string "".

    The testcases will be generated such that the answer is unique.
     */

    private static String minWindow(String s, String t) {
            if(s == null || s.length() < t.length() || s.length() == 0)
            {
                return "";
            }
            Map<Character, Integer> map = new HashMap<>();
            for(char c: t.toCharArray())
            {
                if(map.containsKey(c))
                    map.put(c, map.get(c)+1);
                else
                    map.put(c, 1);
            }
            // mapCounter = 0 denotes condition is satiffied and we got solution
            int mapCounter = map.size();
            int n = s.length();
            int l = 0, r = 0;  // two pointers
            int start = 0, maxLen = 0;
            for(r = 0; r < n; r++)
            {
                char curR = s.charAt(r);
                if(map.containsKey(curR))
                {
                    map.put(curR, map.get(curR)-1);
                    if(map.get(curR) == 0)
                        mapCounter--;

                    // got soltion
                    if(mapCounter == 0)
                    {
                        // finding better solution by shifting left pointer
                        while(l < n && mapCounter == 0)
                        {
                            char curL = s.charAt(l);
                            if(map.containsKey(curL))
                            {
                                map.put(curL, map.get(curL)+1);
                                if(map.get(curL) > 0)
                                    mapCounter++;
                            }
                            l++;
                        }
                        // getting best solution
                        if(maxLen > r-l+2 || maxLen == 0)
                        {
                            maxLen = (r-l) + 2;
                            start = l-1;
                        }
                    }
                }
            }
            return s.substring(start, start+maxLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        minWindow(s, t);
    }
}
