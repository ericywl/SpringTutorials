package tutorials;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component("circle")
public class Circle implements Shape, ApplicationEventPublisherAware {
    private int radius;
    private Point center;
    private MessageSource messageSource;
    private ApplicationEventPublisher publisher;

    public int getRadius() {
        return radius;
    }

    @Resource
    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    @Resource
    public void setCenter(Point center) {
        this.center = center;
    }

    @Resource
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @PostConstruct
    public void init() {
        System.out.println("Initializing circle...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroying circle...");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.publisher = eventPublisher;
    }

    @Override
    public void draw() {
        DrawEvent drawEvent = new DrawEvent(this);
        publisher.publishEvent(drawEvent);

        Object[] args = {getCenter(), getRadius()};
        String drawMessage = messageSource.getMessage("draw.circle", args, "Message not found.", null);
        System.out.println(drawMessage);
        // System.out.println(messageSource.getMessage("greeting", null, "Message not found.", null));
    }
}
