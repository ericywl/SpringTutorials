package tutorials.BPP;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import tutorials.Point;
import tutorials.Triangle;

public class DisplayNameBPP implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Before init method, bean name is " + beanName);

        Point newPointA = new Point();
        newPointA.setX(10);
        newPointA.setY(26);

        if (bean.getClass() == Triangle.class) {
            Triangle tri = (Triangle) bean;
            tri.setPointA(newPointA);

            return tri;
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("After init method, bean name is " + beanName);
        return bean;
    }
}
