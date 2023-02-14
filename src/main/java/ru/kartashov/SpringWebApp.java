package ru.kartashov;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kartashov.computer.Computer;

public class SpringWebApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        Computer computer = context.getBean("computer", Computer.class);
        System.out.println(computer);

        context.close();
    }
}
