
package org.example.task1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Employees emp = context.getBean(Employees.class);

        emp.display();

        ((AnnotationConfigApplicationContext) context).close();
    }
}
