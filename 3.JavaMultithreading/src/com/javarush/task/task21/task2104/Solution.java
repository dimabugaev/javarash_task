package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    //public boolean equals(Solution n) {
    //    return n.first.equals(first) && n.last.equals(last);
    //}

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Solution)) return false;

        Solution n = (Solution) obj;
        if (n.first != null ? !n.first.equals(first) : first != null) return false;
        return last == null ? n.last == null : last.equals(n.last);
    }

    public int hashCode() {


        return 31 * ((first != null) ? first.hashCode() : 0) + ((last != null) ? last.hashCode() : 0);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
