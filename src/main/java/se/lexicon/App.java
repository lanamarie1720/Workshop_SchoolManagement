package se.lexicon;

import org.w3c.dom.ls.LSOutput;
import se.lexicon.DAO.CourseDaoImpl;
import se.lexicon.DAO.StudentDaoImpl;
import se.lexicon.model.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    CourseDaoImpl courseDao;
    StudentDaoImpl studentDao;
    Scanner scanner = new Scanner(System.in);

    public App() {
        courseDao = new CourseDaoImpl();
        studentDao = new StudentDaoImpl();
    }

    public static void main(String[] args) {
        App app = new App();
        boolean isRunning = true;

        while (isRunning) {
            int choice1 = app.chooseFromMainCourseRegistry();
            switch (choice1){
                case 0 -> app.registerCourse();
                case 1 -> app.showAllCourses();
                case 2 -> {
                    int choice2 = app.chooseFromSpecificCourseMenu();
                    switch (choice2){
                        case 0 -> app.showCourseById();
                        case 1 -> app.showCoursesByName();
                        case 2 -> app.showCoursesByDate();
                    }
                }
                case 8 -> {
                    isRunning = false;
                    app.scanner.close();
                }
            }
        }
    }

    private int chooseFromMainCourseRegistry(){
        System.out.println("""
        0. Register Course
        1. Show All Courses
        2. Show Specific Courses
        3. Delete Course
        4. Register Student
        5. Show All Students
        6. Show Specific Student
        7. Delete Student
        8. Exit""");
        System.out.println("Enter a number: ");
        int choice = scanner.nextInt();
        scanner.nextInt();
        return choice;
    }

    private void registerCourse(){
        System.out.println("Enter name of course: ");
        String name = scanner.nextLine();
        System.out.println("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter month: ");
        int month = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter day: ");
        int day = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter week duration: ");
        int duration = scanner.nextInt();
        scanner.nextLine();
        Course course = new Course(name, LocalDate.of(year, month, day), duration);
        System.out.println(course);
        courseDao.save(course);
    }

    private void showAllCourses(){
        if (courseDao.findAll().isEmpty()){
            System.out.println("No courses registered");

            return;
        }

        System.out.println("*** All Courses ***");
        for (Course course : courseDao.findAll()){
            System.out.println(course);
            System.out.println(-------------------);
        }

        System.out.println("*******************");
    }

    private int chooseFromSpecificCourseMenu(){
        System.out.println("*** Search Course Menu ***");
        System.out.println("""
        0. Show Course by Id
        1. Show Courses by Name
        2. Show Courses by Date""");

        System.out.println("**************************");
        int choice = scanner.nextInt();
        scanner.nextInt();
        return choice;
    }

    private void showCourseById(){
        System.out.println("Enter Course Id: ");

        System.out.println("*** Courses found: ***");

        System.out.println(courseDao.findById(scanner.nextInt()));

        System.out.println("*****************");
    }

    private void showCoursesByName(){
        System.out.println("Search by Start Date: ");
        System.out.println("Enter Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Month: ");
        int month = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Day: ");
        int day = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Course> courses = courseDao.findByDate(LocalDate.of(year, month, day));
        if (courses.isEmpty()) {
            System.out.println("No Such Registered Course");
            return;
        }
        System.out.println("*** Courses found: ***");
        for (Course course : courses){
            System.out.println(course);
            System.out.println("-----------------");
    }
        System.out.println("*****************");
        }

        private void closeScanner(){
            scanner.close();
        }

}
