
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StudentManagement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<String> courses = new LinkedHashSet<>();

        System.out.println("=== HashSet ===");

        while (courses.size() < 4) {
            System.out.print("Enter course " + (courses.size() + 1) + ":");
            String course = readRequiredText(sc, "Course code");
            if (courses.add(course)) {
                System.out.println("Course added.");
            } else {
                System.out.println("Course already exists. Please enter a different course.");
            }
        }

        System.out.println("Courses: " + courses);
        System.out.println();

        System.out.print("Search course: ");
        String courseSearch = readRequiredText(sc, "Course code");

        if (courses.contains(courseSearch)) {
            System.out.println(courseSearch + " is available");
        } else {
            System.out.println(courseSearch + " is not available");
        }

        System.out.print("Remove course: ");
        String courseRemove = readRequiredText(sc, "Course code");

        if (courses.remove(courseRemove)) {
            System.out.println("Course removed successfully.");
        } else {
            System.out.println("Course not found.");
        }

        System.out.println("Courses after removal: " + courses);
        System.out.println();

        Map<String, Integer> grades = new LinkedHashMap<>();

        System.out.println("=== HashMap ===");

        for (int i = 1; i <= 3; i++) {
            System.out.print("Enter student " + i + " name: ");
            String name = readRequiredText(sc, "Student name");

            System.out.print("Enter " + name + "'s grade: ");
            int grade = readGrade(sc);

            grades.put(name, grade);
        }

        System.out.println("Grades: " + grades);
        System.out.println();

        System.out.print("Search student: ");
        String searchName = readRequiredText(sc, "Student name");

        if (grades.containsKey(searchName)) {
            System.out.println(searchName + "'s grade: " + grades.get(searchName));
        } else {
            System.out.println("Student not found.");
        }

        System.out.print("Update student: ");
        String updateName = readRequiredText(sc, "Student name");

        if (grades.containsKey(updateName)) {
            System.out.print("New grade: ");
            int newGrade = readGrade(sc);

            grades.put(updateName, newGrade);
            System.out.println("Grades after update: " + grades);
        } else {
            System.out.println("Student not found.");
        }

        System.out.print("Remove student: ");
        String removeName = readRequiredText(sc, "Student name");

        if (grades.remove(removeName) != null) {
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }

        System.out.println("Grades after removal: " + grades);

        sc.close();
    }

    private static String readRequiredText(Scanner sc, String fieldName) {
        String value;
        do {
            value = sc.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.print(fieldName + " cannot be empty. Please enter again: ");
        } while (true);
    }

    private static int readGrade(Scanner sc) {
        int grade;
        while (true) {
            String input = sc.nextLine().trim();
            try {
                grade = Integer.parseInt(input);
                if (grade >= 0 && grade <= 100) {
                    return grade;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.print("Invalid grade. Enter a number from 0 to 100: ");
        }
    }
}
