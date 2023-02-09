package ru.kartashov;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kartashov.model.TestModel;

public class SpringWebApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        TestModel model = context.getBean("testModel", TestModel.class);
        System.out.println(model.getName());
    }
}
