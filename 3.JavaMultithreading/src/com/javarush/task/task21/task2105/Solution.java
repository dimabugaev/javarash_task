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

//    public boolean equals(Object o) {
//        if (!(o instanceof Solution))
//            return false;
//        Solution n = (Solution) o;
//        return n.first.equals(first) && n.last.equals(last);
//    }


    @Override
    public boolean equals(Object obj) {
        //return super.equals(obj);
        if (this == obj) return true;
        if (!(obj instanceof Solution))
            return false;
        Solution n = (Solution) obj;
        if (n.first != null ? !n.first.equals(first) : n.first != first) return false;
        return (n.last != null ? n.last.equals(last) : last == null);
    }

    @Override
    public int hashCode() {

        return 1;//super.hashCode();
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
        //System.out.println(s.equals(new Solution("Mickey", "Mouse")));
    }
}
