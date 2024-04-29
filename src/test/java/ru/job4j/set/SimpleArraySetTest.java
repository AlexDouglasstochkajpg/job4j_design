package ru.job4j.set;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleArraySetTest {

    @Test
    void whenAddNonNull() {
        SimpleSet<Integer> set = new SimpleArraySet<>();
        assertThat(set.add(1)).isTrue();
        assertThat(set.contains(1)).isTrue();
        assertThat(set.add(1)).isFalse();
    }

    @Test
    void whenAddSomeElementsNonNull() {
        SimpleSet<Integer> set = new SimpleArraySet<>();
        assertThat(set.contains(1)).isFalse();
        assertThat(set.add(1)).isTrue();
        assertThat(set.contains(1)).isTrue();
        assertThat(set.add(1)).isFalse();
        assertThat(set.contains(2)).isFalse();
        assertThat(set.add(2)).isTrue();
        assertThat(set.contains(2)).isTrue();
        assertThat(set.add(2)).isFalse();
        assertThat(set.contains(3)).isFalse();
        assertThat(set.add(3)).isTrue();
        assertThat(set.contains(3)).isTrue();
        assertThat(set.add(3)).isFalse();
    }

    @Test
    void whenAddNull() {
        SimpleSet<Integer> set = new SimpleArraySet<>();
        assertThat(set.add(null)).isTrue();
        assertThat(set.contains(null)).isTrue();
        assertThat(set.add(null)).isFalse();
    }

    @Test
    void whenAddStringElements() {
        SimpleSet<String> set = new SimpleArraySet<>();
        assertThat(set.add("one")).isTrue();
        assertThat(set.add("two")).isTrue();
        assertThat(set.add("one")).isFalse();
        assertThat(set.contains("two")).isTrue();
        assertThat(set.contains("three")).isFalse();
    }

    @Test
    void whenAddListCollections() {
        SimpleSet<List<Integer>> set = new SimpleArraySet<>();
        assertThat(set.add(List.of(1, 2, 3))).isTrue();
        assertThat(set.contains(List.of(1, 2, 3))).isTrue();
        assertThat(set.add(List.of(1, 2, 3))).isFalse();
        assertThat(set.add(List.of(3, 2, 1))).isTrue();
        assertThat(set.contains(List.of(3, 1, 2))).isFalse();
        assertThat(set.contains(List.of(3, 2, 1))).isTrue();
    }
}