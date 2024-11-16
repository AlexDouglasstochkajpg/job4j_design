package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ITReportTest {

    @Test
    void whenGenerateForIT() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("John", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        Report itReport = new ITReport(store, parser);
        StringBuilder expected = new StringBuilder()
                .append("name;hired;fired;salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(parser.parse(worker.getHired())).append(";")
                .append(parser.parse(worker.getFired())).append(";")
                .append(worker.getSalary())
                .append(System.lineSeparator());
        assertThat(itReport.generate(employee -> true)).isEqualTo(expected.toString());
    }
}