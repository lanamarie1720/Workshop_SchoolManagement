package se.lexicon;

import se.lexicon.DAO.CourseDaoImpl;
import se.lexicon.DAO.StudentDaoImpl;
import se.lexicon.DAO.StudentDao;
import se.lexicon.model.Course;
import se.lexicon.model.Student;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        StudentDaoImpl studentDao = new StudentDaoImpl();
        Student registeredStudent = studentDao.save(new Student("Lana", "lana.marie@me.com", "Turfgatan 1, 183 74 Täby"));
        System.out.println(registeredStudent.getName());
        System.out.println(studentDao.findAll());

        System.out.println(studentDao.findByEmail("lana.marie@me.com").getName());

        CourseDaoImpl courseDao = new CourseDaoImpl();

        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);
        while (isRunning) {
            System.out.println("Enter a number: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0 ->:
                System.out.println("Enter a course name: ");
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

                case 5 -> {
                    isRunning = false;
                    scanner.close();
                }
            }
        }
    }
    }

