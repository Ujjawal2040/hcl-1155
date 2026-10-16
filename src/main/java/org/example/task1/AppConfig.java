
package org.example.task1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Address address() {
        return new Address();
    }

    @Bean
    public Salary salary() {
        return new Salary();
    }

    @Bean
    public Employees employees(Address address, Salary salary) {
        return new Employees(address, salary);
    }
}
