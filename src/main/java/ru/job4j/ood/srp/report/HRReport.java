package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.comparators.SalaryComparator;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class HRReport implements Report {

    private final Store store;

    public HRReport(Store store) {
        this.store = store;
    }

    private List<Employee> sortStore(Predicate<Employee> filter) {
        List<Employee> rsl = store.findBy(filter);
        Collections.sort(rsl, new SalaryComparator());
        return rsl;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> listEmployees = sortStore(filter);
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : listEmployees) {
            text.append(employee.getName()).append(" ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
