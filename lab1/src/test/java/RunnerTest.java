import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RunnerTest {
    List<Circle> c = new ArrayList<Circle>();

    RunnerTest() {
        c.add(new Circle(0, 0, 2));
        c.add(new Circle(3, 1, 4));
        c.add(new Circle(1.5, 0.5, 1));
        c.add(new Circle(-1, 5, 3));
        c.add(new Circle(-2, -2, 3.5));
    }

    @Test
    @DisplayName("Line test")
    void checkCircleLine() {
        assertAll(() -> assertEquals(true, Runner.checkCircleLine(c.get(0), c.get(1), c.get(2))),
                () -> assertEquals(false, Runner.checkCircleLine(c.get(0), c.get(1), c.get(3))));
    }

    @Test
    @DisplayName("Biggest circle test")
    void biggest() {
        assertEquals(c.get(1), Runner.biggestCircle(c.get(0), c.get(1), c.get(2), c.get(3), c.get(4)));
    }

    @Test
    @DisplayName("Longest circle test")
    void longest() {
        assertEquals(c.get(1), Runner.longestCircle(c.get(0), c.get(1), c.get(2), c.get(3), c.get(4)));
    }

    @Test
    @DisplayName("Area test")
    void getArea() {
        assertEquals(Math.PI, c.get(2).getArea());
    }

    @Test
    @DisplayName("Length test")
    void getLength() {
        assertEquals(Math.PI * 2, c.get(2).getLength());
    }

    @Test
    @DisplayName("Add test")
    void add() {
        Circle c0 = new Circle(0, 0, 0);
        c0.add(c.get(0));
        assertEquals(2, c0.getR());
    }

    @Test
    @DisplayName("Multiple test")
    void mul() {
        Circle c0 = new Circle(0, 0, 2);
        c0.mul(c.get(0));
        assertEquals(4, c0.getR());
    }

    @Test
    @DisplayName("Sub test")
    void sub() {
        Circle c0 = new Circle(0, 0, 10);
        c0.sub(c.get(0));
        assertEquals(8, c0.getR());
    }

    @Test
    @DisplayName("Division test")
    void div() {
        Circle c0 = new Circle(0, 0, 6);
        c0.div(c.get(0));
        assertEquals(3, c0.getR());
    }
}