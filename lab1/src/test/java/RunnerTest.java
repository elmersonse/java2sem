import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RunnerTest {
    static List<Circle> c = new ArrayList<>();

    @BeforeAll
    static void setupTest() {
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
}