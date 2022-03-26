//public class Shape {
//    public static void main(String[] args) {
//        Shape[] shapes = new Shape[]{
//                new Square(Point.random(), 10),
//                new Triangle(Point.random(), 10, 20),
//                new Rectangle(Point.random(), 10, 20)};
//        for (Shape s : shapes) {
//            printShape(s);
//        }
//        void printShape (Shape s){
//            Point p = s.getPosition();
//            System.out.println("position: x=" + p.x + ", y=" + p.y);
//            System.out.println("area: " + ?);
//        }
//    }
//    }
//    public int getArea() {
//        return 0;}
//}
//
//class Triangle extends Shape {
//    private final int width;
//    private final int height;
//    public Triangle(int width, int height) {
//        this.width = width;
//        this.height = height;}
//    @Override
//    public int getArea() {
//        return width * height / 2;}
//}
//class Rectangle extends Shape {
//    private final int width;
//    private final int height;
//    public Rectangle(int width, int height) {
//        this.width = width;
//        this.height = height;}
//    @Override
//    public int getArea() {
//        return width * height;}
//}
//class Circle extends Shape {
//    private final int radius; // 반지름
//    public Circle(int radius) {
//        this.radius = radius;}
//    @Override
//    public int getArea() {
//        return (int) (radius * radius * Math.PI);}
//}
//class Square extends Shape {
//    Point position; // 정사각형의 위치
//    int width;  // 정사각형의 변의 길이
//    public Square(int x, int y, int width) {
//        this.position = new Point(x, y);
//        this.width = width;}
//    public int getArea() {
//        return width * width;}
//}
//class Point {
//    int x;
//    int y;
//    public Point(int x, int y) {
//        this.x = x;
//        this.y = y;}
//}
//
//
