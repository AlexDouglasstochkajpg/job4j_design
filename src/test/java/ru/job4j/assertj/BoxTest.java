package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube")
                .containsIgnoringCase("cube");
    }

    @Test
    void isThisUnknown() {
        Box box = new Box(-1, 0);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object")
                .doesNotContain("Tetrahedron");
    }

    @Test
    void numberOfVerticesIsPositive() {
        Box box = new Box(4, 10);
        int number = box.getNumberOfVertices();
        assertThat(number).isPositive()
                .isEven()
                .isEqualTo(4);
    }

    @Test
    void numberOfVerticesIsNegative() {
        Box box = new Box(-1, 0);
        int number = box.getNumberOfVertices();
        assertThat(number).isNegative()
                .isNotZero()
                .isEqualTo(-1);
    }

    @Test
    void checkBooleanIsTrue() {
        Box box = new Box(0, 10);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }

    @Test
    void checkBooleanIsFalse() {
        Box box = new Box(-1, 0);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }

    @Test
    void areaIsPositive() {
        Box box = new Box(0, 10);
        double area = box.getArea();
        assertThat(area).isEqualTo(1256.6d, withPrecision(0.6d))
                .isCloseTo(1256.6d, Percentage.withPercentage(1.0d))
                .isGreaterThan(1255.5d);
    }

    @Test
    void areaIsZero() {
        Box box = new Box(1, 10);
        double area = box.getArea();
        assertThat(area).isEqualTo(0.0d)
                .isLessThan(0.1d);
    }
}