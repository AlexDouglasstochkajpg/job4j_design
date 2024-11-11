package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Disabled("Тесты отключены.")
class GeneratorTemplateTest {

    @Test
    void whenProduceThenGetTemplate() {
        Generator generatorTemplate = new GeneratorTemplate();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Alex");
        args.put("subject", "you");
        String produce = generatorTemplate.produce(template, args);
        assertThat(produce).isEqualTo("I am a Alex, Who are you?");
    }

    @Test
    void whenMapDoesNotHaveKeysThenGetException() {
        Generator generatorTemplate = new GeneratorTemplate();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("subject", "you");
        assertThatThrownBy(() -> generatorTemplate.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenMapHasExtraKeysThenGetException() {
        Generator generatorTemplate = new GeneratorTemplate();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Alex");
        args.put("surname", "Jones");
        args.put("subject", "you");
        assertThatThrownBy(() -> generatorTemplate.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }
}