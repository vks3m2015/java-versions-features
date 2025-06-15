package com.vik.features.general;

//Java 15 (preview) and finalized in Java 17
//A sealed class or interface restricts which other classes or interfaces may extend or implement it.
public class SealedClass {

    public static void main(String[] arg){
        Shape shape = new Circle(1);
        System.out.println(" Area of Circle = "+shape.area());

        Shape shape2 = new Rectangle(1, 1);
        System.out.println(" Area of Rectangle = "+shape2.area());
    }
}

sealed abstract class Shape permits Circle, Rectangle {
    public abstract double area();
}

//sealed, non-sealed or final modifiers expected for child classes
final class Circle extends Shape {
    double radius;
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

non-sealed class Rectangle extends Shape {
    double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

//Compilation error => 'Triangle' is not allowed in the sealed hierarchy
/*
final class Triangle extends Shape{

    @Override
    public double area() {
        return 0;
    }
}*/
