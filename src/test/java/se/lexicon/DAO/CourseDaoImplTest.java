package se.lexicon.DAO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Course;

import java.time.LocalDate;
import java.util.ArrayList;

class CourseDaoImplTest {
    @Test
    void save() {

        Course course = new Course("Music", LocalDate.now(), 10);

        course.setId();

        CourseDaoImpl courseDao = new CourseDaoImpl();
        Course course1 = courseDao.save(course);

        Assertions.assertEquals(course, course1);
    }

    @Test
    void findByNameTest() {
        ArrayList<Course> courses = new ArrayList<>();
        Course course = new Course("Music", LocalDate.now(), 10);
        courses.add(course);
        CourseDaoImpl courseDao = new CourseDaoImpl();
        ArrayList<Course> arrayList = courseDao.findByName("Music");

        Assertions.assertEquals(courses, arrayList);
    }
}
