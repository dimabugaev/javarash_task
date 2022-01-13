package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/

public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public int hashCode() {
            return i + j;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;

            if (!(obj instanceof A)) return false;

            A o = (A) obj;


            return (i == o.i && j == o.j);
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
            //return super.clone();
        }

        @Override
        public int hashCode() {
            return (name != null ? name.length() : 0);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;

            if (!(obj instanceof B)) return false;

            B o = (B) obj;

            return super.equals(obj) && (name != null ? name.equals(o.name) : o.name == null);
        }
    }

    public static class C extends B implements Cloneable{
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected C clone() throws CloneNotSupportedException {
            C clone = new C(getI(),getJ(), getName());
            return clone;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        C first = new C(12, 35, "testing");
        C second = first.clone();

        System.out.println(first);
        System.out.println(second);
        System.out.println(second.equals(first));
    }
}
