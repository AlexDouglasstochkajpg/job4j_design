package ru.job4j.iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

class ListUtilsTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBefore2() {
        ListUtils.addBefore(input, 1, 4);
        assertThat(input).hasSize(3).containsSequence(1, 4, 3);
    }

    @Test
    void whenAddAfterWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 4, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenRemoveIf() {
        ListUtils.removeIf(input, (value) -> value % 2 != 0);
        assertThat(input).hasSize(0);
    }

    @Test
    void whenRemoveIfThenNoChange() {
        ListUtils.removeIf(input, (value) -> value % 2 == 0);
        assertThat(input).hasSize(2).containsSequence(1, 3);
    }

    @Test
    void whenReplaceIf() {
        ListUtils.replaceIf(input, (value) -> value % 2 != 0, 2);
        assertThat(input).hasSize(2).containsSequence(2, 2);
    }

    @Test
    void whenReplaceIfThenNotChange() {
        ListUtils.replaceIf(input, (value) -> value % 2 == 0, 5);
        assertThat(input).hasSize(2).containsSequence(1, 3);
    }

    @Test
    void whenRemoveAll() {
        ListUtils.removeAll(input, List.of(1));
        assertThat(input).hasSize(1).containsSequence(3);
    }

    @Test
    void whenRemoveAllThenNoChange() {
        ListUtils.removeAll(input, null);
        assertThat(input).hasSize(2).containsSequence(1, 3);
    }
}