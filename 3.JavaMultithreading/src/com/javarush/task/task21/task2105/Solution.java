package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Solution))
            return false;
        Solution n = (Solution) o;
        //if (o == n)
        //return n.first == this.first && n.last == this.last;
        return n.first.equals(first) && n.last.equals(last);
    }

    @Override
    public int hashCode() {
        int len1 = 0;
        int len2 = 0;
        if (this.first != null) len1 = this.first.length();
        if (this.last != null) len2 = this.last.length();
        return len1 + len2;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
