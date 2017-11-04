package tutorials;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // Shape obj1 = (Shape) context.getBean("triangle");
        // obj1.draw();

        Shape obj2 = (Shape) context.getBean("circle");
        obj2.draw();

        context.registerShutdownHook();
    }
}
