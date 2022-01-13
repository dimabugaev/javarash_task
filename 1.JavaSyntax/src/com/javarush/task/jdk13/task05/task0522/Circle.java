package com.javarush.task.jdk13.task05.task0522;

/* 
Максимум конструкторов
*/

public class Circle {
    public double x;
    public double y;
    public double radius;

    //напишите тут ваш код
    public Circle(double x, double y, double radius){
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    public Circle(double x, double y){
        this.radius = 10;
        this.x = x;
        this.y = y;
    }

    public Circle(double x){
        this.radius = 10;
        this.x = x;
        this.y = 5;
    }

    public Circle(){
        this.radius = 10;
        this.x = 10;
        this.y = 5;
    }

    public Circle(Circle circle){
        this.radius = circle.radius;
        this.x = circle.x;
        this.y = circle.y;
    }

    public static void main(String[] args) {

    }
}