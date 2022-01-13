package com.javarush.task.jdk13.task05.task0520;

/* 
Заполнить класс прямоугольник (Rectangle)
*/


public class Rectangle {
    //напишите тут ваш код

    private int top, left, width, height;

    public Rectangle(int top, int left){
        this.top = top;
        this.left = left;
        this.width = 10;
        this.height = 10;
    }

    public Rectangle(int top, int left, int width){
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = width;
    }

    public Rectangle(int width){
        this.top = 0;
        this.left = 0;
        this.width = width;
        this.height = width;
    }

    public Rectangle(Rectangle rect){
        this.top = rect.top;
        this.left = rect.left;
        this.width = rect.width;
        this.height = rect.height;
    }

    public static void main(String[] args) {

    }
}
