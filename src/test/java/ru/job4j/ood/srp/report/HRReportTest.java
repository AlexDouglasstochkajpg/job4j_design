package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class HRReportTest {

    @Test
    void whenGenerateForHR() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee workerFirst = new Employee("Jack", now, now, 100);
        Employee workerSecond = new Employee("John", now, now, 200);
        Employee workerThird = new Employee("James", now, now, 150);
        store.add(workerFirst);
        store.add(workerSecond);
        store.add(workerThird);
        Report hrReport = new HRReport(store);
        StringBuilder expected = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(workerSecond.getName()).append(" ")
                .append(workerSecond.getSalary())
                .append(System.lineSeparator())
                .append(workerThird.getName()).append(" ")
                .append(workerThird.getSalary())
                .append(System.lineSeparator())
                .append(workerFirst.getName()).append(" ")
                .append(workerFirst.getSalary())
                .append(System.lineSeparator());
        assertThat(hrReport.generate(employee -> true)).isEqualTo(expected.toString());
    }
}