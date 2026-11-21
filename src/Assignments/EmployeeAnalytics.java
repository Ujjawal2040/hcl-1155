package Assignments;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

public class EmployeeAnalytics {

    record Employee(
            int id,
            String name,
            String dept,
            BigDecimal salary,
            LocalDate hireDate,
            Set<String> skills
    ) {}

    static Employee e(
            int id, String name, String dept,
            int salary, String date, String... skills
    ) {
        return new Employee(
                id, name, dept,
                BigDecimal.valueOf(salary),
                LocalDate.parse(date),
                Set.of(skills)
        );
    }

    public static void main(String[] args) {

        List<Employee> emps = List.of(
                e(1, "Asha", "Engineering", 90000,
                        "2019-03-01", "Java", "SQL"),
                e(2, "Ravi", "Engineering", 120000,
                        "2016-07-15", "Java", "Spring", "AWS"),
                e(3, "Meera", "HR", 60000,
                        "2020-01-10", "Recruiting"),
                e(4, "John", "Sales", 70000,
                        "2018-11-20", "Negotiation", "CRM"),
                e(5, "Priya", "Engineering", 105000,
                        "2021-05-05", "Java", "React"),
                e(6, "Karan", "Sales", 65000,
                        "2022-02-14", "CRM"),
                e(7, "Sara", "HR", 62000,
                        "2017-09-09", "Recruiting", "Payroll"),
                e(8, "Vikram", "Finance", 80000,
                        "2015-04-30", "Excel", "SQL")
        );

        // Q1: Engineering employees by salary descending
        List<String> q1 = emps.stream()
                .filter(e -> e.dept().equals("Engineering"))
                .sorted(Comparator.comparing(Employee::salary).reversed())
                .map(Employee::name)
                .toList();
        System.out.println("Q1: " + q1);

        // Q2: Top 3 earners overall
        List<String> q2 = emps.stream()
                .sorted(Comparator.comparing(Employee::salary).reversed())
                .limit(3)
                .map(Employee::name)
                .toList();
        System.out.println("Q2: " + q2);

        // Q3: Hired before 2018, oldest hire first
        List<String> q3 = emps.stream()
                .filter(e -> e.hireDate().isBefore(
                        LocalDate.parse("2018-01-01")))
                .sorted(Comparator.comparing(Employee::hireDate))
                .map(e -> e.name() + " (" +
                        e.hireDate().getYear() + ")")
                .toList();
        System.out.println("Q3: " + q3);

        // Q4: All names in one comma-separated string
        String q4 = emps.stream()
                .map(Employee::name)
                .collect(Collectors.joining(", "));
        System.out.println("Q4: " + q4);

        // Q5: Total payroll using reduce
        BigDecimal q5 = emps.stream()
                .map(Employee::salary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Q5: " + q5);

        // Q6: Match operations
        boolean anyAWS = emps.stream()
                .anyMatch(e -> e.skills().contains("AWS"));

        boolean allAbove50k = emps.stream()
                .allMatch(e -> e.salary().compareTo(
                        BigDecimal.valueOf(50000)) > 0);

        boolean noneAbove150k = emps.stream()
                .noneMatch(e -> e.salary().compareTo(
                        BigDecimal.valueOf(150000)) > 0);

        System.out.println("Q6: " + anyAWS + ", "
                + allAbove50k + ", " + noneAbove150k);

        // Q7: Highest-paid employee using Optional
        Optional<Employee> q7 = emps.stream()
                .max(Comparator.comparing(Employee::salary));

        System.out.println("Q7: " +
                q7.map(Employee::name).orElse("none"));

        // Q8: Average salary by department
        Map<String, Double> q8 = emps.stream()
                .collect(Collectors.groupingBy(
                        Employee::dept,
                        TreeMap::new,
                        Collectors.averagingDouble(
                                e -> e.salary().doubleValue()
                        )
                ));
        System.out.println("Q8: " + q8);

        // Q9: Highest-paid employee name per department
        Map<String, String> q9 = emps.stream()
                .collect(Collectors.groupingBy(
                        Employee::dept,
                        TreeMap::new,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(
                                        Comparator.comparing(Employee::salary)
                                ),
                                opt -> opt.map(Employee::name).orElse("none")
                        )
                ));
        System.out.println("Q9: " + q9);

        // Q10: Partition employees by salary >= 75000
        Map<Boolean, List<String>> q10 = emps.stream()
                .collect(Collectors.partitioningBy(
                        e -> e.salary().compareTo(
                                BigDecimal.valueOf(75000)) >= 0,
                        Collectors.mapping(Employee::name,
                                Collectors.toList())
                ));
        System.out.println("Q10: " + q10);

        // Q11: Sorted, distinct skills
        List<String> q11 = emps.stream()
                .flatMap(e -> e.skills().stream())
                .distinct()
                .sorted()
                .toList();
        System.out.println("Q11: " + q11);

        // Q12: Skill frequency and most common skill
        Map<String, Long> q12 = emps.stream()
                .flatMap(e -> e.skills().stream())
                .collect(Collectors.groupingBy(
                        skill -> skill,
                        Collectors.counting()
                ));

        Optional<Map.Entry<String, Long>> mostCommon =
                q12.entrySet().stream()
                        .max(Map.Entry.comparingByValue());

        System.out.println("Q12 frequency: " + q12);
        mostCommon.ifPresent(entry ->
                System.out.println("Q12 most common: "
                        + entry.getKey() + " = " + entry.getValue())
        );

        // E1: Map employee ID to name
        Map<Integer, String> idToName = emps.stream()
                .collect(Collectors.toMap(
                        Employee::id, Employee::name
                ));
        System.out.println("E1: " + idToName);

        // E1: Demonstrate duplicate-key failure and fix
        try {
            Stream.of(
                    new AbstractMap.SimpleEntry<>(1, "Asha"),
                    new AbstractMap.SimpleEntry<>(1, "Ravi")
            ).collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue
            ));
        } catch (IllegalStateException ex) {
            System.out.println("Duplicate key detected");
        }

        Map<Integer, String> merged = Stream.of(
                new AbstractMap.SimpleEntry<>(1, "Asha"),
                new AbstractMap.SimpleEntry<>(1, "Ravi")
        ).collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (oldValue, newValue) -> oldValue + "/" + newValue
        ));
        System.out.println("E1 merged: " + merged);

        // E3: Lazy evaluation
        Stream<String> lazy = emps.stream()
                .map(Employee::name)
                .filter(name -> {
                    System.out.println("Processing: " + name);
                    return name.startsWith("A");
                });

        System.out.println("Pipeline created; nothing processed yet.");
        System.out.println("Lazy result: " + lazy.toList());
    }
}
