package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkParseEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("array is empty");
    }

    @Test
    void checkParse() {
        NameLoad nameLoad = new NameLoad();
        String names = "key:value";
        assertThatThrownBy(() -> nameLoad.parse(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(names)
                .hasMessageContaining("key:value");
    }

    @Test
    void checkValidateName() {
        NameLoad nameLoad = new NameLoad();
        String names = "name";
        assertThatThrownBy(() -> nameLoad.parse(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(names)
                .hasMessageContaining("name");
    }

    @Test
    void checkValidateStart() {
        NameLoad nameLoad = new NameLoad();
        String names = "=name";
        assertThatThrownBy(() -> nameLoad.parse(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(names)
                .hasMessageContaining("=");
    }

    @Test
    void checkValidateIndex() {
        NameLoad nameLoad = new NameLoad();
        String names = "name=";
        assertThatThrownBy(() -> nameLoad.parse(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(names)
                .hasMessageContaining("name=");
    }
}