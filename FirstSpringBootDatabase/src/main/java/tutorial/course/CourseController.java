package tutorial.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tutorial.topic.Topic;

import java.util.List;

@RestController
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService CourseService) {
        this.courseService = CourseService;
    }

    @GetMapping("/topics/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable String topicId) {
        return courseService.getAllCourses(topicId);
    }

    @GetMapping("/topics/{topicId}/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId) {
        return courseService.getCourse(courseId);
    }

    // Use Postman app to send POST/PUT/DELETE request
    @PostMapping(value="/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }

    @PutMapping(value="/topics/{topicId}/courses")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);
    }

    @DeleteMapping(value="/topics/{topicId}/courses/{courseId}")
    public void deleteCourse(@PathVariable String courseId) {
        courseService.deleteCourse(courseId);
    }
}
