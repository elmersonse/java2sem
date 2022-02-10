import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
//        List<Circle> circles = new ArrayList<Circle>();
//        circles.add(new Circle(0, 0, 2));
//        circles.add(new Circle(3, 1, 4));
//        circles.add(new Circle(1.5, 0.5, 1));
//        circles.add(new Circle(-1, 5, 3));
//        circles.add(new Circle(-2, -2, 3.5));
//        String out;
//        for (Circle c: circles) {
//            out = String.format("X = %.2f; Y = %.2f; Area = %.2f; Length = %.2f", c.getX(), c.getY(), c.getArea(), c.getLength());
//            System.out.println(out);
//        }
//        Circle temp1;
//        temp1 = biggestCircle(circles.get(0), circles.get(1), circles.get(2), circles.get(3), circles.get(4));
//        out = String.format("Biggest circle:\nX = %.2f; Y = %.2f; Area = %.2f; Length = %.2f", temp1.getX(), temp1.getY(), temp1.getArea(), temp1.getLength());
//        System.out.println(out);
//        temp1 = longestCircle(circles.get(0), circles.get(2), circles.get(3), circles.get(4));
//        out = String.format("Longest circle:\nX = %.2f; Y = %.2f; Area = %.2f; Length = %.2f", temp1.getX(), temp1.getY(), temp1.getArea(), temp1.getLength());
//        System.out.println(out);
//        if(checkCircleLine(circles.get(0), circles.get(1), circles.get(2))) {
//            System.out.println("Circles are on one line!");
//        }
//        if(!checkCircleLine(circles.get(0), circles.get(1), circles.get(3))) {
//            System.out.println("Circles are not on one line!");
//        }
    }


    static boolean checkCircleLine(Circle c1, Circle c2, Circle... circles) {
        int n = circles.length;
        if(n == 0) {
            return true;
        }
        double k, b;
        k = (c1.getY() - c2.getY()) / (c1.getX() - c2.getX());
        b = c2.getY() - k * c2.getX();
        for (Circle c: circles) {
            if(c.getY() != k * c.getX() + b) {
                return false;
            }
        }
        return true;
    }

    static Circle biggestCircle(Circle... circles) {
        Circle temp = new Circle(0, 0, 0);
        for (Circle c: circles) {
            if(c.getArea() > temp.getArea()) {
                temp = c;
            }
        }
        return temp;
    }

    static Circle longestCircle(Circle... circles) {
        Circle temp = new Circle(0, 0, 0);
        for (Circle c: circles) {
            if(c.getLength() > temp.getLength()) {
                temp = c;
            }
        }
        return temp;
    }
}
