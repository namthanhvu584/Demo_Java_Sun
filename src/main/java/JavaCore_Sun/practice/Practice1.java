package JavaCore_Sun.practice;

class Shape {
    protected double width;
    protected double height;

    public Shape(double width, double height) {
        this.width = width;
        this.height = height;
    }
}

class Rectangle extends Shape {

    public Rectangle(double width, double height) {
        super(width, height);
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public void display() {
        System.out.println("== Rectangle ==");
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
        System.out.println();
    }
}

class Circle extends Shape {

    public Circle(double diameter) {
        super(diameter, 0); // height không dùng
    }

    public double getRadius() {
        return width / 2;
    }

    public double getArea() {
        double r = getRadius();
        return Math.PI * r * r;
    }

    public double getCircumference() {
        return Math.PI * width; // π*d
    }

    public void display() {
        System.out.println("== Circle ==");
        System.out.println("Diameter: " + width);
        System.out.println("Radius: " + getRadius());
        System.out.println("Area: " + getArea());
        System.out.println("Circumference: " + getCircumference());
        System.out.println();
    }
}

public class Practice1 {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5, 3);
        Circle circle = new Circle(10); // đường kính = 10

        rect.display();
        circle.display();
    }
}
