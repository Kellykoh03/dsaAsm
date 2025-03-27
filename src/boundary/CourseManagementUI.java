/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Cham Yee
 */
package boundary;

import entity.Course;
import entity.CourseProgramme;
import entity.Faculty;
import entity.Semester;
import static java.lang.String.format;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class CourseManagementUI {

    Date date = new Date();
    Scanner scan = new Scanner(System.in);

    public int getMenuChoice() {
        System.out.println("");
        System.out.println("------------------------------------------------");
        System.out.println("Course Management");
        System.out.println("------------------------------------------------");
        System.out.println("1. Add a programme to course.");
        System.out.println("2. Remove a programme from a course.");
        System.out.println("3. Add a new course to programme");
        System.out.println("4. Remove a course from a programme.");
        System.out.println("5. Search courses offered in a semester.");
        System.out.println("6. Amend course details.");
        System.out.println("7. List courses taken by different faculties.");
        System.out.println("8. List all courses for a programme.");
        System.out.println("9. Generate summary reports.");
        System.out.println("------------------------------------------------");
        System.out.print("Enter a choice (-999 to exit): ");
        int choice = scan.nextInt();
        scan.nextLine();
        System.out.println();
        return choice;
    }

    public void listAllCourses(String str) {
        String v1 = "Course Code";
        String v2 = "Course Title";
        String v3 = "Course Type";
        String v4 = "Credit Hour";
        String v5 = "Course Fee";
        System.out.print(format("%18s %30s %15s %15s %15s\n", v1, v2, v3, v4, v5));
        System.out.println(str);
    }

    public void listAllProgramme(String str) {
        String v1 = "Programme Code";
        String v2 = "Programme Name";
        System.out.printf("%-5s %15s %80s\n", "No.", v1, v2);
        System.out.println(str);
    }

    public void listAllProgrammeCourse(String str) {
        String v1 = "Programme Code";
        String v2 = "Programme Name";
        String v3 = "Course Code";
        String v4 = "Course Title";
        String v5 = "Course Type";
        String v6 = "Credit Hour";
        String v7 = "Course Fee";
        System.out.print(format("%15s %50s %18s %30s %15s %15s %15s\n", v1, v2, v3, v4, v5, v6, v7));
        System.out.println(str);
    }

    public void listAllCourseProgramme(String str) {
        String v1 = "Course Code";
        String v2 = "Course Title";
        String v3 = "Course Type";
        String v4 = "Credit Hour";
        String v5 = "Course Fee";
        String v6 = "Programme Code";
        String v7 = "Programme Name";
        System.out.print(format("%18s %30s %15s %15s %15s %6s %31s\n", v1, v2, v3, v4, v5, v6, v7));
        System.out.println(str);
    }

    public void listAllFacultyCourses(String str) {
        String v1 = "Faculty Code";
        String v2 = "Faculty Name";
        String v3 = "Course Code";
        String v4 = "Course Title";
        String v5 = "Course Type";
        String v6 = "Credit Hour";
        String v7 = "Course Fee";
        System.out.print(format("%6s %31s %18s %30s %15s %15s %15s\n", v1, v2, v3, v4, v5, v6, v7));
        System.out.println(str);
    }

    public String inputCourseCode() {
        System.out.print("Enter Course Code (-999 to go back): ");
        String courseCode = scan.nextLine();
        return courseCode;
    }

    public String inputCourseCode2() {
        System.out.print("Enter Course Code: ");
        String courseCode = scan.nextLine();
        return courseCode;
    }

    public String inputCourseTitle() {
        System.out.print("Enter Course Title: ");
        String courseTitle = scan.nextLine();
        return courseTitle;
    }

    public String inputCourseType() {
        System.out.print("Enter Course Type (Main / Repeat / Resit / Elective): ");
        String courseType = scan.nextLine();
        return courseType;
    }

    public int inputCourseCreditHour() {
        System.out.print("Enter Course Credit Hour (1, 2, 3, 4): ");
        int creditHour = scan.nextInt();
        scan.nextLine();
        return creditHour;
    }

    public double inputCourseFee() {
        System.out.print("Enter Course Fee(RM90 for repeat, 1 credit hour = RM 259): RM ");
        double courseFee = scan.nextDouble();
        scan.nextLine();
        return courseFee;
    }

    public void getAStringInput() {
        scan.nextLine();
    }

    public CourseProgramme inputCourseProgrammeDetails(String courseCode, String courseTitle, String courseType, int creditHour, double courseFee, String programmeCode, String programmeName) {
        return new CourseProgramme(courseCode, courseTitle, courseType, creditHour, courseFee, programmeCode, programmeName);
    }

    public int inputConfirm() {
        System.out.print("Do you wish to add a new course? (1 to confirm / -999 to go back): ");
        int confirm = scan.nextInt();
        scan.nextLine();
        return confirm;
    }

    public int inputConfirm2() {
        System.out.print("Do you wish to amend a course? (1 to confirm / -999 to go back): ");
        int confirm = scan.nextInt();
        scan.nextLine();
        return confirm;
    }

    public String confirmStringInput(String a1) {
        System.out.println("You entered: " + a1);
        System.out.print("Is this correct? (Y/N): ");
        String input = scan.nextLine().trim();
        return input;
    }

    public String confirmStringInput2(String a1) {
        System.out.println("You entered: " + a1);
        System.out.print("Is this correct? (Y/N): ");
        String input = scan.nextLine().trim();
        return input;
    }

    public Course inputCourseDetails() {
        String code;
        String title;
        String type;
        int creditHour;
        double courseFee;

        code = inputCourseCode();
        title = inputCourseTitle();
        type = inputCourseType();
        creditHour = inputCourseCreditHour();
        courseFee = inputCourseFee();
        scanNextLine();
        return new Course(code, title, type, creditHour, (int) courseFee);
    }

    public Course inputCourseDetails2(String courseCode, String courseTitle, String courseType, int creditHour, double courseFee) {
        return new Course(courseCode, courseTitle, courseType, creditHour, (int) courseFee);
    }

    public String removeACourse() {
        System.out.print("Enter the course code to remove (-999 to go back): ");
        String ccourseCode = scan.nextLine();
        return ccourseCode;
    }

    public String removeAProgramme() {
        System.out.print("\nEnter the programme code to remove (-999 to go back): ");
        String pCode = scan.nextLine();
        return pCode;
    }

    public String courseToAmend() {
        System.out.print("Enter the course code to amend (-999 to go back): ");
        String courseCode = scan.nextLine().toUpperCase();
        return courseCode;
    }

    public void amendCourseDetailsOutput(String courseTitle, String code) {
        System.out.println("\nCourse to amend: " + courseTitle);
        System.out.println("Course Code: " + code);
        System.out.println("Please provide the updated details:");
    }

    public int chooseAmendOption() {
        System.out.println("Choose an option to amend (Course Code cannot be edit):");
        System.out.println("1. Course Title");
        System.out.println("2. Course Type");
        System.out.println("3. Credit Hour");
        System.out.println("4. Course Fee");
        System.out.println("5. Cancel");
        System.out.print("Enter your choice: ");
        int choice = scan.nextInt();
        scan.nextLine();
        return choice;
    }

    public String inputProgrammeName() {
        System.out.print("Enter Programme Name: ");
        String programmeName = scan.nextLine();
        return programmeName;
    }

    public String inputProgrammeCode() {
        System.out.print("Enter Programme Code (RSW, RSD, etc): ");
        String programmeCode = scan.nextLine();
        return programmeCode.toUpperCase();
    }

    public String inputSemester() {
        System.out.println("Enter Semester(202401 / 202310): ");
        String semesterCode = scan.nextLine();
        return semesterCode;
    }

    public void addProgrammeToCourses() {
        System.out.print("Enter Programme Name: ");
        String programmeName = scan.nextLine();

        System.out.print("Enter Course Title: ");
        String courseTitle = scan.nextLine();

        System.out.println("Programme Name: " + programmeName);
        System.out.println("Course Title: " + courseTitle);
    }

    public int chooseProgramme() {
        int choice = 0;
        System.out.print("Enter a choice: ");
        choice = scan.nextInt();
        scan.nextLine();
        return choice;
    }

    public String removeProgrammeFromCourse() {
        System.out.println("Enter the course to remove (-999 to go back): ");
        String ccourseCode = scan.nextLine();
        return ccourseCode;
    }

    public void listOfProgramme() {
        System.out.println("");
        System.out.println("List of Programmes:");
        System.out.println("===================================");
        System.out.printf("%-15s %-70s\n", "Programme Code", "Programme Name");
    }

    public void displayProgramme(String programmeCode, String programmeName) {
        System.out.printf("%-15s %-70s\n", programmeCode, programmeName);
    }

    public void displayCourseHeading() {
        System.out.println("");
        System.out.println("List of Course:");
        System.out.println("===================================");
        System.out.printf("%-20s %-70s\n", "Course Code", "Course Title");
    }

    public void displayCourse(String courseCode, String courseTitle) {
        System.out.printf("%-20s %-70s\n", courseCode, courseTitle);
    }

    public void addNewCourseToProgrammes() {
        System.out.print("Enter Course Title: ");
        String courseTitle = scan.nextLine();

        System.out.print("Enter Programme Name: ");
        String programmeName = scan.nextLine();

        System.out.println("Course Title: " + courseTitle);
        System.out.println("Programme Name: " + programmeName);
    }

    public String removeCourseFromProgramme() {
        System.out.println("Enter the course to remove (-999 to go back): ");
        String pprogrammeCode = scan.nextLine();
        return pprogrammeCode;
    }

    public String inputFaculty() {
        System.out.print("Enter Faculty Code (FOCS, FAFB): ");
        String facultyCode = scan.nextLine();
        return facultyCode;
    }

    public int chooseFaculty() {
        int choice = 0;
        System.out.print("Enter a choice: ");
        choice = scan.nextInt();
        scan.nextLine();
        return choice;
    }

    public void listAllCoursesForProgramme() {
        System.out.print("Enter Programme Name: ");
        String programmeName = scan.nextLine();

        System.out.println("All courses for programme '" + programmeName + "':");
    }

    public void availableCourse() {
        System.out.println("Available course:");
        System.out.println("===================================");
    }

    public void availableFaculty() {
        System.out.println("Available Faculties:");
        System.out.println("1. FOCS");
        System.out.println("2. FAFB");
    }

    public void getSumReport() {
        System.out.println("1. Summary Report of Total Course Fees of Each Faculty");
        System.out.println("2. Summary Report of Course Type Distribution");
    }

    public int selectSumReport() {
        System.out.print("Select a summary report: ");
        int choice = scan.nextInt();
        scan.nextLine();
        return choice;
    }

    public void scanNextLine() {
        System.out.print("\nPress <ENTER> to continue.\n");
        scan.nextLine();
    }

    public void searchsem(String semesterCode) {
        System.out.println("\nSearch result of courses for semester: " + semesterCode.toUpperCase());
    }

    public void listFacultyCourses(String courseCode, String courseTitle, String courseType, int creditHour, double courseFee) {
        System.out.println(String.format("%17s %30s %15s %15d %15.2f",
                courseCode, courseTitle, courseType, creditHour, courseFee));
    }

    public void listProgrammeCourses(String programmeCode, String courseCode, String courseTitle, String courseType, int creditHour, double courseFee) {
        System.out.println(String.format("%17s %30s %15s %15d %15.2f",
                courseCode, courseTitle, courseType, creditHour, courseFee));
    }

    public void printCourseHeader(String programmeCode) {
        System.out.println("All courses for programme '" + programmeCode + "':");
        System.out.println(String.format("\n%17s %30s %15s %15s %15s", "Course Code", "Course Title", "Course Type", "Credit Hour", "Course Fee"));
    }

    public void displayCourseTypeDistributionHeader() {
        System.out.println("");
        System.out.println("Course Type Distribution Report:");
        System.out.println("--------------------------------");
        System.out.println(String.format("%-15s %-15s %-15s", "Course Type", "Count", "Percentage"));
    }

    public void displayCourseTypeDistribution(String courseType, int count, double percentage) {
        System.out.println(String.format("%-15s %-15s %-15.2f%%", courseType, count, percentage));
    }

    public void facultyOutput() {
        System.out.println("\nFaculty Fees Summary Report:");
        System.out.println("----------------------------");
    }

    public void courseFacultyHeading() {
        System.out.printf("%10s %30s %30s", "Faculty Code", "Total Number of Courses", "Total Fees Collected (RM)");
    }

    public void printTotalCoursesForFaculty(String facultyCode, int totalCourses, double totalFees) {
        System.out.printf("\n%10s %30d %30.2f", facultyCode, totalCourses, totalFees);
    }

    public void format1() {
        System.out.println(String.format("\n%15s %30s %15s %15s %15s", "Course Code", "Course Title", "Course Type", "Credit Hour", "Course Fee"));
    }

    public void format2(String a2, String a3, String a4, int a5, double a6) {
        System.out.println(String.format("%15s %30s %15s %15d %15.2f", a2, a3, a4, a5, a6));
    }

    public void format3() {
        System.out.println(String.format("\n%10s %50s %10s %30s %15s %15s %15s", "Faculty Code", "Faculty Name", "Course Code", "Course Title", "Course Type", "Credit Hour", "Course Fee"));
    }

    public Semester inputSemCourseDetails(String semester, String courseCode, String courseTitle, String courseType, int creditHour, double courseFee) {
        return new Semester(semester, courseCode, courseTitle, courseType, creditHour, courseFee);
    }

    public Faculty inputFacultyCourseDetails(String facultyCode, String facultyName, String courseCode, String courseTitle, String courseType, int creditHour, double courseFee) {
        return new Faculty(facultyCode, facultyName, courseCode, courseTitle, courseType, creditHour, courseFee);
    }

    public void format4() {
        System.out.printf("%-15s %-50s %-20s %-30s %-20s %-20s %-10s\n",
                "Faculty Code", "Faculty Name", "Course Code", "Course Title", "Course Type", "Credit Hour", "Course Fee");
    }

    public void newLine() {
        System.out.println("");
    }

    public void addProgrammeCourseTitle() {
        System.out.println("======================================================================================================");
        System.out.println("=" + format("%100s", " ") + "=");
        System.out.println("=" + format("%39s", " ") + "Add Programme To Course" + format("%38s", " ") + "=");
        System.out.println("=" + format("%100s", " ") + "=");
        System.out.println("======================================================================================================");
    }

    public void removeProgrammeCourseTitle() {
        System.out.println("=================================================================================================");
        System.out.println("=" + format("%95s", " ") + "=");
        System.out.println("=" + format("%34s", " ") + "Remove Programme From Course" + format("%33s", " ") + "=");
        System.out.println("=" + format("%95s", " ") + "=");
        System.out.println("=================================================================================================");
    }

    public void addCourseProgrammeTitle() {
        System.out.println("======================================================================================================");
        System.out.println("=" + format("%100s", " ") + "=");
        System.out.println("=" + format("%37s", " ") + "Add New Course To Prgramme" + format("%37s", " ") + "=");
        System.out.println("=" + format("%100s", " ") + "=");
        System.out.println("======================================================================================================");
    }

    public void removeCourseProgrammeTitle() {
        System.out.println("======================================================================================================");
        System.out.println("=" + format("%100s", " ") + "=");
        System.out.println("=" + format("%36s", " ") + "Remove Course From Programme" + format("%36s", " ") + "=");
        System.out.println("=" + format("%100s", " ") + "=");
        System.out.println("======================================================================================================");
    }

    public void searchCourseSemTitle() {
        System.out.println("============================================================================================================");
        System.out.println("=" + format("%106s", " ") + "=");
        System.out.println("=" + format("%36s", " ") + "Search Courses Offered In Semester" + format("%36s", " ") + "=");
        System.out.println("=" + format("%106s", " ") + "=");
        System.out.println("============================================================================================================");
    }

    public void amendCourseTitle() {
        System.out.println("=================================================================================================");
        System.out.println("=" + format("%95s", " ") + "=");
        System.out.println("=" + format("%37s", " ") + "Amend Course Details" + format("%38s", " ") + "=");
        System.out.println("=" + format("%95s", " ") + "=");
        System.out.println("=================================================================================================");
    }

    public void listCourseFacultyTitle() {
        System.out.println("==========================================================================================================================================================");
        System.out.println("=" + format("%152s", " ") + "=");
        System.out.println("=" + format("%64s", " ") + "List Courses By Faculties" + format("%63s", " ") + "=");
        System.out.println("=" + format("%152s", " ") + "=");
        System.out.println("==========================================================================================================================================================");
    }

    public void listCourseProgrammeTitle() {
        System.out.println("=================================================================================================");
        System.out.println("=" + format("%95s", " ") + "=");
        System.out.println("=" + format("%33s", " ") + "List All Courses For Programme" + format("%32s", " ") + "=");
        System.out.println("=" + format("%95s", " ") + "=");
        System.out.println("=================================================================================================");
    }

    public void summaryReport1Title() {
        System.out.println("====================================================================================================================================================================================");
        System.out.println(format("%60s", " ") + "Tunku Abdul Rahman University Of Management And Technology" + format("%60s", " "));
        System.out.println(format("%75s", " ") + "Course Management System" + format("%75s", " "));
        System.out.println("\n");
        System.out.println(format("%76s", " ") + "Course Summary Report 1" + format("%76s", " "));
        System.out.println("\n");
        System.out.printf("%s %tA, %<tB %<te %<tY, %<tT", "Generated at:", date);
        System.out.println("\n");
    }

    public void summaryReport2Title() {
        System.out.println("====================================================================================================================================================================================");
        System.out.println(format("%60s", " ") + "Tunku Abdul Rahman University Of Management And Technology" + format("%60s", " "));
        System.out.println(format("%75s", " ") + "Course Management System" + format("%75s", " "));
        System.out.println("\n");
        System.out.println(format("%76s", " ") + "Course Summary Report 2" + format("%76s", " "));
        System.out.println("\n");
        System.out.printf("%s %tA, %<tB %<te %<tY, %<tT", "Generated at:", date);
        System.out.println("\n");
    }

    public void displayFinalSentence(String facultyCode, int totalCourses, double totalFees) {
        System.out.println("Total courses for faculty " + facultyCode.toUpperCase() + ": " + totalCourses);
        System.out.println("");
        System.out.println("Total fees collected for faculty " + facultyCode.toUpperCase() + ": RM " + totalFees);
    }

    public void displayCourseDetails(String facultyCode, String facultyName, String courseCode, String courseTitle, String courseType, int creditHour, double courseFee) {
        System.out.printf("%-15s %-50s %-20s %-30s %-20s %-20s %-10.2f\n", facultyCode, facultyName, courseCode, courseTitle, courseType, creditHour, courseFee);
    }

    public void displayFacultyHeader1(String selectedFaculty) {
        System.out.println("All Course in " + selectedFaculty.toUpperCase() + ":");
        System.out.println("--------------------------------");
        System.out.printf("%17s %30s %15s %15s %15s\n", "Course Code", "Course Title", "Course Type", "Credit Hour", "Course Fee");
    }
    
    public void displayCourseTypeHeader(String courseType, String facultyCode) {
        System.out.println("All Course in " + facultyCode.toUpperCase() + ":");
        System.out.println("--------------------------------");
        System.out.printf("%17s %30s %15s %15s %15s\n", "Course Code", "Course Title", "Course Type", "Credit Hour", "Course Fee");
    }

    public void displayCourseDetails(String courseCode, String courseTitle, String courseType, int creditHour, double courseFee) {
        System.out.printf("%17s %30s %15s %15s %15s\n", courseCode, courseTitle, courseType, creditHour, courseFee);
    }

    public void displayDistributionSummary(String courseType, String facultyCode, int totalCourses, int chosenCourseTypeCount, double calculatePercentage) {
        System.out.println();

    }

    public void summaryReportTitle1End() {
        System.out.printf("%110s\n", "END OF THE COURSE MANAGEMENT SUMMARY REPORT");
        System.out.println("====================================================================================================================================================================================");
    }
}