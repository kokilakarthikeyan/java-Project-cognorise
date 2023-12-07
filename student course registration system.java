import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String studentId;
    private String name;
    private List<Course> registeredCourses;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", registeredCourses=" + registeredCourses +
                '}';
    }
}

class Course {
    private String courseId;
    private String courseName;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}

class RegistrationSystem {
    private List<Student> students;
    private List<Course> courses;

    public RegistrationSystem() {
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void displayStudents() {
        System.out.println("Registered Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void displayCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    public void registerStudentForCourse() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Enter course ID: ");
        String courseId = scanner.nextLine();

        Student student = findStudentById(studentId);
        Course course = findCourseById(courseId);

        if (student != null && course != null) {
            student.registerCourse(course);
            System.out.println("Registration successful.");
        } else {
            System.out.println("Invalid student ID or course ID. Please try again.");
        }
    }

    private Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    private Course findCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getCourseId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        RegistrationSystem registrationSystem = new RegistrationSystem();

        // Adding sample students
        registrationSystem.addStudent(new Student("S001", "Alice"));
        registrationSystem.addStudent(new Student("S002", "Bob"));

        // Adding sample courses
        registrationSystem.addCourse(new Course("C001", "Java Programming"));
        registrationSystem.addCourse(new Course("C002", "Data Structures"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Course Registration System");
            System.out.println("1. Display Students");
            System.out.println("2. Display Courses");
            System.out.println("3. Register Student for Course");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registrationSystem.displayStudents();
                    break;
                case 2:
                    registrationSystem.displayCourses();
                    break;
                case 3:
                    registrationSystem.registerStudentForCourse();
                    break;
                case 4:
                    System.out.println("Exiting the Student Course Registration System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
