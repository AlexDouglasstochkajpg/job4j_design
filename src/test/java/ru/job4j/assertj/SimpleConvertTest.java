package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import org.assertj.core.data.Index;
import java.util.List;
import java.util.Set;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkArray2() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("one", "two", "three");
        assertThat(array).hasSize(3)
                .contains("one", "two")
                .containsOnly("two", "three", "one")
                .startsWith("one")
                .endsWith("three");
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("one", "two", "three");
        assertThat(list).hasSize(3)
                .containsExactly("one", "two", "three")
                .containsSequence("two", "three")
                .allMatch(e -> e.length() < 7)
                .first().isEqualTo("one");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("one", "two", "three");
        assertThat(set).hasSize(3)
                .doesNotContain("four")
                .anyMatch(e -> e.equals("two"))
                .filteredOn(e -> e.length() > 3).first().isEqualTo("three");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("one","two", "three");
        assertThat(map).hasSize(3)
                .containsKey("one")
                .containsValue(2)
                .doesNotContainKeys("four", "five")
                .doesNotContainValue(4)
                .containsEntry("one", 0);
    }
}