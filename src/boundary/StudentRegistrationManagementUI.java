/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boundary;

import entity.Student;
import static java.lang.String.format;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Alex Lee Chia Hau
 */
public class StudentRegistrationManagementUI {
    Date date = new Date();
    //SimpleDateFormat sdf = new SimpleDateFormat("E, dd M yyyy, hh:mm:ss a");
    Scanner scan = new Scanner(System.in);

    /**
     * @return
     */
    public int getMenuChoice() {
        System.out.println("Student Registration Management");
        System.out.println("1. Add new students.");
        System.out.println("2. Remove a student.");
        System.out.println("3. Amend student details.");
        System.out.println("4. Search students for registered courses.");
        System.out.println("5. Add students to a few courses (main, elective, resit, repeat).");
        System.out.println("6. Remove a student from a course (main, elective) registration.");
        System.out.println("7. Calculate fee paid for registered courses.");
        System.out.println("8. Filters students for courses based on criteria.");
        System.out.println("9. Generate summary reports.");
        System.out.print("Enter a choice (-999 to exit) : ");
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

    public void listAllRegistered(String str) {
        String v1 = "Student Name";
        String v2 = "Age";
        String v3 = "Gender";
        String v4 = "Student ID";
        String v5 = "Programme Code";
        String v6 = "Course Code";
        String v7 = "Course Title";
        String v8 = "Course Type";
        String v9 = "Credit Hour";
        String v10 = "Course Fee";
        System.out.print(format("%31s %6s %9s %16s %16s %18s %30s %15s %15s %15s\n", v1, v2, v3, v4, v5, v6, v7, v8, v9, v10));
        System.out.println(str);
    }

    public String inputCourseCode() {
        System.out.print("Enter Course Code (-999 to go back): ");
        String courseCode;
        courseCode = scan.nextLine();
        return courseCode;
    }

    public String confirmStringInput(String a1) {
        System.out.println("You entered: " + a1);
        System.out.print("Is this correct? (Y/N): ");
        String input = scan.nextLine().trim();
        return input;
    }

    public void getAStringInput() {
        scan.nextLine();
    }

    public void listAllStudents(String str) {
        String v1 = "Student Name";
        String v2 = "Age";
        String v3 = "Gender";
        String v4 = "Student ID";
        String v5 = "Programme Code";
        System.out.print(format("%32s %7s %10s %16s %16s\n", v1, v2, v3, v4, v5));
        System.out.println(str);
    }

    public int inputStudentID() {
        int id = -1;
        System.out.print("Enter the student ID of student (-999 to go back): ");
        id = scan.nextInt();
        scan.nextLine();
        return id;
    }

    public String confirmIntInput(int a1) {
        System.out.println("You entered: " + a1);
        System.out.print("Is this correct? (Y/N): ");
        String input = scan.nextLine().trim();
        return input;
    }

    public int inputStudentID2() {
        int id = -1;
        System.out.print("Enter the student ID of student: ");
        id = scan.nextInt();
        scan.nextLine();
        return id;
    }

    public String inputName() {
        System.out.print("Enter name: ");
        String name = scan.nextLine();
        return name;
    }

    public String inputName2() {
        System.out.print("Enter name (-999 to go back to menu): ");
        String name = scan.nextLine();
        return name;
    }

    public String inputGender() {
        System.out.print("Enter gender (M or F): ");
        String gender = scan.nextLine().toUpperCase();
        return gender;
    }

    public int inputAge() {
        System.out.print("Enter age: ");
        int age = scan.nextInt();
        scan.nextLine();
        return age;
    }

    public String inputProgrammeCode() {
        System.out.print("Enter the programme code the student is enrolling (RSW, RSD, etc): ");
        String progCode = scan.nextLine();
        return progCode.toUpperCase();
    }

    public int inputConfirm() {
        System.out.print("Do you wish to add a new student? (1 to confirm / -999 to go back): ");
        int confirm = scan.nextInt();
        scan.nextLine();
        return confirm;
    }

    public int inputConfirm2() {
        System.out.print("Do you wish to amend student details? (1 to confirm / -999 to go back): ");
        int confirm = scan.nextInt();
        scan.nextLine();
        return confirm;
    }

    public Student inputStudentDetails(String name, String gender, int age, String programmeCode) {
        return new Student(name, gender, age, programmeCode);
    }

    public void selectFilter() {
        System.out.println("1. Filter by course.");
        System.out.println("2. Filter by gender.");
    }

    public int inputChoice() {
        System.out.print("Enter a choice (-999 to go back to menu): ");
        int choice = scan.nextInt();
        scan.nextLine();
        return choice;
    }

    public int removeAStudent() {
        System.out.print("Enter the student id to remove (-999 to go back): ");
        int i = scan.nextInt();
        return i;
    }

    public int studToAmend() {
        int id = inputStudentID2();
        return id;
    }

    public int amendAge() {
        System.out.println("Enter age: ");
        int age = scan.nextInt();
        scan.nextLine();
        return age;
    }

    public String amendGender() {
        System.out.println("Enter gender (M or F): ");
        String gender = scan.nextLine();
        return gender;
    }

    public void genSumReport() {
        System.out.println("1. Summary Report of total students with selected gender enrolled to the specified programme.");
        System.out.println("2. Summary Report of total students of that age which registered to a specific course");
    }

    public int selectSumReport() {
        System.out.print("Select a summary report: ");
        int choice = scan.nextInt();
        scan.nextLine();
        return choice;
    }

    public void scanNextLine() {
        System.out.print("Press <ENTER> to continue.");
        scan.nextLine();
    }

    public void formatting1(String a1, String a2, String a3, String a4, String a5, String a6, String a7, String a8, String a9, String a10) {
        System.out.println(format("%22s %6s %9s %16s %16s %18s %30s %15s %15s %15s", a1, a2, a3, a4, a5, a6, a7, a8, a9, a10));
    }
    
    public void formattingB1(String a6, String a7, String a8, String a9, String a10) {
        System.out.println(format("%18s %30s %15s %15s %15s",a6, a7, a8, a9, a10));
    }

    public void amendStudDetailsOutput(String a1, int a2) {
        System.out.println("Student " + a1 + " with student ID " + a2 + " found.");
    }

    public void searchResultOutput(String a1) {
        System.out.println("\nSearch result of student registered for course: " + a1);
    }

    public void formatting2(String a1, int a2, String a3, int a4, String a5, String a6, String a7, String a8, int a9, double a10) {
        System.out.println(format("%22s %6d %9s %16d %16s %18s %30s %15s %15d %15.2f", a1, a2, a3, a4, a5, a6, a7, a8, a9, a10));
    }
    
    public void formattingB2(String a6, String a7, String a8, int a9, double a10) {
        System.out.println(format("%18s %30s %15s %15d %15.2f",a6, a7, a8, a9, a10));
    }

    public void newStudAdded(String a1) {
        System.out.println("\nNew student has been added to course " + a1 + "\n");
    }

    public void studBill(int a1) {
        System.out.println("\nStudent Bill");
        System.out.println("Courses have been registered for student with id: " + a1);
    }

    public void totalFeeOutput(String a1, double a2) {
        System.out.printf("\nTotal fee should be paid for student " + a1.toUpperCase() + ": RM " + format("%.2f", a2) + "\n\n");
    }

    public void filterCourseOutput(String a1) {
        System.out.println("Result for student that is taking course " + a1);
    }

    public void filterGenderOutput(String a1) {
        System.out.println("Result for student with gender " + a1.toUpperCase());
    }

    public void formatting3(String a1, String a2, String a3, String a4, String a5) {
        System.out.println(format("%22s %6s %9s %16s %16s", a1, a2, a3, a4, a5));
    }

    public void formatting4(String a1, int a2, String a3, int a4, String a5) {
        System.out.println(format("%22s %6d %9s %16d %16s", a1, a2, a3, a4, a5));
    }

    public void totalStudentwithGenderOutput(String a1, String a2, int a3) {
        System.out.println("Total students with gender " + a1.toUpperCase() + " enrolled in programme with programme code " + a2 + ": " + a3);
    }

    public void totalStudentwithAgeOutput(int a1, String a2, int a3) {
        System.out.println("Total students with age " + a1 + " and are in the course with course code " + a2.toUpperCase() + ": " + a3);
    }

    public void newLine() {
        System.out.println("");
    }
    
    public void addNewStudentTitle(){
        System.out.println("=====================================================================================");
        System.out.println("=" + format("%83s", " ") + "=");
        System.out.println("=" + format("%34s", " ") + "Add new student" + format("%34s"," ") + "=");
        System.out.println("=" + format("%83s", " ") + "=");
        System.out.println("=====================================================================================");
    }
    
    public void studentRemovalTitle(){
        System.out.println("=====================================================================================");
        System.out.println("=" + format("%83s", " ") + "=");
        System.out.println("=" + format("%34s", " ") + "Student Removal" + format("%34s"," ") + "=");
        System.out.println("=" + format("%83s", " ") + "=");
        System.out.println("=====================================================================================");
    }
    
    public void amendStudentDetailsTitle(){
        System.out.println("=====================================================================================");
        System.out.println("=" + format("%83s", " ") + "=");
        System.out.println("=" + format("%31s", " ") + "Amend Student Details" + format("%31s"," ") + "=");
        System.out.println("=" + format("%83s", " ") + "=");
        System.out.println("=====================================================================================");
    }
    
    public void searchStudentRegisteredTitle(){
        System.out.println("=================================================================================================");
        System.out.println("=" + format("%95s", " ") + "=");
        System.out.println("=" + format("%35s", " ") + "Search student registered" + format("%35s"," ") + "=");
        System.out.println("=" + format("%95s", " ") + "=");
        System.out.println("=================================================================================================");
    }
    
    public void addStudentToCourseTitle(){
        System.out.println("=====================================================================================");
        System.out.println("=" + format("%83s", " ") + "=");
        System.out.println("=" + format("%31s", " ") + "Add student to course" + format("%31s"," ") + "=");
        System.out.println("=" + format("%83s", " ") + "=");
        System.out.println("=====================================================================================");
    }
    
    public void removeStudentFromCourseTitle(){
        System.out.println("====================================================================================================================================================================================");
        System.out.println("=" + format("%178s", " ") + "=");
        System.out.println("=" + format("%76s", " ") + "Remove student from course" + format("%76s"," ") + "=");
        System.out.println("=" + format("%178s", " ") + "=");
        System.out.println("====================================================================================================================================================================================");
    }
    
    public void studentFilterTitle(){
        System.out.println("====================================================================================================================================================================================");
        System.out.println("=" + format("%178s", " ") + "=");
        System.out.println("=" + format("%82s", " ") + "Filter student" + format("%82s"," ") + "=");
        System.out.println("=" + format("%178s", " ") + "=");
        System.out.println("====================================================================================================================================================================================");
    }
    
    public void filterByCourseTitle(){
        System.out.println("====================================================================================================================================================================================");
        System.out.println("=" + format("%178s", " ") + "=");
        System.out.println("=" + format("%77s", " ") + "Filter student By Course" + format("%78s"," ") + "=");
        System.out.println("=" + format("%178s", " ") + "=");
        System.out.println("====================================================================================================================================================================================");
    }
    
    public void filterByGenderTitle(){
        System.out.println("====================================================================================================================================================================================");
        System.out.println("=" + format("%178s", " ") + "=");
        System.out.println("=" + format("%76s", " ") + "Filter student By Gender" + format("%76s"," ") + "=");
        System.out.println("=" + format("%178s", " ") + "=");
        System.out.println("====================================================================================================================================================================================");
    }
    
    public void summaryReport1Title(){
        System.out.println("=============================================================================");
        System.out.println(format("%6s"," ") + "Tunku Abdul Rahman University Of Management And Technology" + format("%7s"," "));
        System.out.println(format("%16s"," ") + "Student Registration Management System" + format("%17s"," "));
        System.out.println("");
        System.out.println(format("%17s"," ") + "Student Registration Summary Report 1" + format("%17s"," "));
        System.out.println("");
        System.out.printf("%s %tA, %<tB %<te %<tY, %<tT","Generated at:" , date);
        System.out.println("\n");
    }
    
    public void summaryReportTitle1End(){
        System.out.println(format("%12s"," ") + "END OF THE STUDENT REGISTRATION SUMMARY REPORT" + format("%13s"," "));
        System.out.println("=============================================================================");
    }
    
    public void summaryReport2Title(){
        System.out.println("====================================================================================================================================================================================");
        System.out.println(format("%60s"," ") + "Tunku Abdul Rahman University Of Management And Technology" + format("%60s"," "));
        System.out.println(format("%70s"," ") + "Student Registration Management System" + format("%70s"," "));
        System.out.println("");
        System.out.println(format("%70s"," ") + "Student Registration Summary Report 2" + format("%71s"," "));
        System.out.println("");
        System.out.printf("%s %tA, %<tB %<te %<tY, %<tT","Generated at:" , date);
        System.out.println("\n");
    }
    
    public void summaryReportTitle2End(){
        System.out.println(format("%66s"," ") + "END OF THE STUDENT REGISTRATION SUMMARY REPORT" + format("%66s"," "));
        System.out.println("====================================================================================================================================================================================");
    }
    
    public void pressEnterToContinue(){
        System.out.println("Press <ENTER> to continue");
        scan.nextLine();
    }
    
    public void listAllProgramme(String str) {
        String v1 = "Programme Code";
        String v2 = "Programme Name";
        System.out.printf("%-5s %15s %80s\n", "No.", v1, v2);
        System.out.println(str);
    }
}
