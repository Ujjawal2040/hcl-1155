
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;
import java.util.stream.*;

public class OrderSalesPipeline {

    record OrderLine(
            String product,
            String category,
            int qty,
            BigDecimal unitPrice
    ) {
        BigDecimal total() {
            return unitPrice.multiply(BigDecimal.valueOf(qty));
        }
    }

    record Order(
            int id,
            String customer,
            LocalDate date,
            String status,
            List<OrderLine> lines
    ) {
        BigDecimal total() {
            return lines.stream()
                    .map(OrderLine::total)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
    }

    record Summary(long count, BigDecimal revenue) {}

    static OrderLine l(String product, String category,
                       int qty, int price) {
        return new OrderLine(
                product, category, qty, BigDecimal.valueOf(price)
        );
    }

    // Cancelled-order rule exists in one place.
    static Stream<Order> valid(List<Order> orders) {
        return orders.stream()
                .filter(o -> !o.status().equals("CANCELLED"));
    }

    public static void main(String[] args) {

        List<Order> orders = List.of(
                new Order(1, "Asha",
                        LocalDate.parse("2026-01-05"), "DELIVERED",
                        List.of(
                                l("Laptop", "Electronics", 1, 50000),
                                l("Mouse", "Electronics", 2, 500)
                        )
                ),
                new Order(2, "Ravi",
                        LocalDate.parse("2026-01-12"), "DELIVERED",
                        List.of(
                                l("Book", "Books", 3, 400),
                                l("Pen", "Stationery", 10, 20)
                        )
                ),
                new Order(3, "Asha",
                        LocalDate.parse("2026-02-03"), "CANCELLED",
                        List.of(
                                l("Phone", "Electronics", 1, 30000)
                        )
                ),
                new Order(4, "Meera",
                        LocalDate.parse("2026-02-10"), "DELIVERED",
                        List.of(
                                l("Book", "Books", 2, 400),
                                l("Laptop", "Electronics", 1, 50000)
                        )
                ),
                new Order(5, "Ravi",
                        LocalDate.parse("2026-02-18"), "DELIVERED",
                        List.of(
                                l("Mouse", "Electronics", 1, 500),
                                l("Pen", "Stationery", 5, 20)
                        )
                )
        );

        // R1: Total revenue
        BigDecimal r1 = valid(orders)
                .map(Order::total)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("R1 Revenue: " + r1);

        // R2: Revenue per customer, highest first
        Map<String, BigDecimal> customerRevenue =
                valid(orders).collect(Collectors.groupingBy(
                        Order::customer,
                        Collectors.reducing(
                                BigDecimal.ZERO,
                                Order::total,
                                BigDecimal::add
                        )
                ));

        Map<String, BigDecimal> r2 = customerRevenue.entrySet()
                .stream()
                .sorted(Map.Entry.<String, BigDecimal>
                        comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));

        System.out.println("R2 Customer revenue: " + r2);

        // R3: Revenue per category
        Map<String, BigDecimal> r3 = valid(orders)
                .flatMap(o -> o.lines().stream())
                .collect(Collectors.groupingBy(
                        OrderLine::category,
                        TreeMap::new,
                        Collectors.reducing(
                                BigDecimal.ZERO,
                                OrderLine::total,
                                BigDecimal::add
                        )
                ));

        System.out.println("R3 Category revenue: " + r3);

        // R4: Units sold per product
        Map<String, Integer> r4 = valid(orders)
                .flatMap(o -> o.lines().stream())
                .collect(Collectors.groupingBy(
                        OrderLine::product,
                        TreeMap::new,
                        Collectors.summingInt(OrderLine::qty)
                ));

        System.out.println("R4 Units sold: " + r4);

        // R5: Best-selling product by units
        Optional<Map.Entry<String, Integer>> r5 =
                r4.entrySet().stream()
                        .max(Map.Entry.comparingByValue());

        System.out.println("R5 Best seller: " +
                r5.map(e -> e.getKey() + " (" + e.getValue() + ")")
                        .orElse("none"));

        // R6: Monthly revenue, sorted by month
        Map<YearMonth, BigDecimal> r6 = valid(orders)
                .collect(Collectors.groupingBy(
                        o -> YearMonth.from(o.date()),
                        TreeMap::new,
                        Collectors.reducing(
                                BigDecimal.ZERO,
                                Order::total,
                                BigDecimal::add
                        )
                ));

        System.out.println("R6 Monthly revenue: " + r6);

        // R7: Average order value
        List<Order> validOrders = valid(orders).toList();

        Optional<BigDecimal> r7 = validOrders.isEmpty()
                ? Optional.empty()
                : Optional.of(
                validOrders.stream()
                        .map(Order::total)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                        .divide(
                                BigDecimal.valueOf(validOrders.size()),
                                2,
                                java.math.RoundingMode.HALF_UP
                        )
        );

        System.out.println("R7 Average order value: " +
                r7.map(BigDecimal::toPlainString).orElse("N/A"));

        // R8: Cancellation rate across all orders
        long cancelled = orders.stream()
                .filter(o -> o.status().equals("CANCELLED"))
                .count();

        double r8 = orders.isEmpty()
                ? 0.0
                : cancelled * 100.0 / orders.size();

        System.out.println("R8 Cancellation rate: " + r8 + "%");

        // R9: Count and revenue in one pass using teeing
        Summary r9 = valid(orders).collect(Collectors.teeing(
                Collectors.counting(),
                Collectors.reducing(
                        BigDecimal.ZERO,
                        Order::total,
                        BigDecimal::add
                ),
                Summary::new
        ));

        System.out.println("R9 Delivered count: " + r9.count());
        System.out.println("R9 Delivered revenue: " + r9.revenue());

        // R10: Distinct sorted categories per customer
        Map<String, List<String>> r10 = valid(orders)
                .collect(Collectors.groupingBy(
                        Order::customer,
                        TreeMap::new,
                        Collectors.flatMapping(
                                o -> o.lines().stream()
                                        .map(OrderLine::category),
                                Collectors.collectingAndThen(
                                        Collectors.toCollection(TreeSet::new),
                                        ArrayList::new
                                )
                        )
                ));

        System.out.println("R10 Customer categories: " + r10);

        // Plain assertions: verify important results.
        assert r1.compareTo(BigDecimal.valueOf(103800)) == 0;
        assert r2.keySet().iterator().next().equals("Asha");
        assert r4.get("Pen") == 15;
        assert r5.isPresent() && r5.get().getKey().equals("Pen");
        assert r7.isPresent()
                && r7.get().compareTo(BigDecimal.valueOf(25950)) == 0;
        assert Math.abs(r8 - 20.0) < 0.0001;
        assert r9.count() == 4;
        assert r9.revenue().compareTo(BigDecimal.valueOf(103800)) == 0;

        // Empty-list edge cases
        List<Order> empty = List.of();

        BigDecimal emptyRevenue = valid(empty)
                .map(Order::total)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Optional<BigDecimal> emptyAverage =
                valid(empty).map(Order::total)
                        .reduce(BigDecimal::add);

        Map<String, Integer> emptyUnits =
                valid(empty)
                        .flatMap(o -> o.lines().stream())
                        .collect(Collectors.groupingBy(
                                OrderLine::product,
                                Collectors.summingInt(OrderLine::qty)
                        ));

        Optional<Map.Entry<String, Integer>> emptyBestSeller =
                emptyUnits.entrySet().stream()
                        .max(Map.Entry.comparingByValue());

        assert emptyRevenue.compareTo(BigDecimal.ZERO) == 0;
        assert emptyAverage.isEmpty();
        assert emptyBestSeller.isEmpty();

        System.out.println("Empty revenue: " + emptyRevenue);
        System.out.println("Empty average: " +
                emptyAverage.map(BigDecimal::toPlainString).orElse("N/A"));
        System.out.println("Empty best seller: " +
                emptyBestSeller.map(Map.Entry::getKey).orElse("none"));

        System.out.println("All assertions passed.");
    }
}
