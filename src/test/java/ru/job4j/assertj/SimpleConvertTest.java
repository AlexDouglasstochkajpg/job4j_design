package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three");
        assertThat(list).hasSize(3)
                .contains("three")
                .containsAnyOf("zero", "seven", "five", "first")
                .first().isEqualTo("first");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "second", "three");
        assertThat(set).hasSize(3)
                .containsExactlyInAnyOrder("second", "first", "three")
                .anyMatch(e -> e.startsWith("th"))
                .filteredOnAssertions(e -> assertThat(e).startsWith("f"))
                .containsSequence("first");
    }
    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("first", "second", "three");
        assertThat(map).hasSize(3)
                .containsKeys("first", "second")
                .doesNotContainKey("ten")
                .containsEntry("three", 2)
                .doesNotContainValue(9)
                .containsValue(1);
    }
}