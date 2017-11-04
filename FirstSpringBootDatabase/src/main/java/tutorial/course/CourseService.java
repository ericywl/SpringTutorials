package tutorial.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private CourseRepository courseRepo;

    @Autowired
    public CourseService(CourseRepository CourseRepo) {
        this.courseRepo = CourseRepo;
    }

    public List<Course> getAllCourses(String topicId) {
        return courseRepo.findByTopicId(topicId);
    }

    public Course getCourse(String id) {
        return courseRepo.findOne(id);
    }

    public void addCourse(Course course) {
        courseRepo.save(course);
    }

    public void updateCourse(Course course) {
        courseRepo.save(course);
    }

    public void deleteCourse(String id) {
        courseRepo.delete(id);
    }
}
