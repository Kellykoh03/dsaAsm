package boundary;

import entity.TutorCourse;
import entity.TutorTutorialGroupCourse;
import entity.TutorialGroupTutor;
import static java.lang.String.format;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Tang Yi Jun
 */

public class TeachingAssignmentUI {

    Scanner scan = new Scanner(System.in);

    public int getMenuChoice() {
        System.out.println("\nTeaching Assignment");
        System.out.println("1. Assign tutor to courses.");
        System.out.println("2. Assign tutorial groups to a tutor.");
        System.out.println("3. Add tutors to a tutorial group for a course.");
        System.out.println("4. Search courses under a tutor.");
        System.out.println("5. Search tutors for a course(T,P,L).");
        System.out.println("6. List tutors and tutorial groups for a course.");
        System.out.println("7. List courses for each tutor.");
        System.out.println("8. Filter tutors based on criteria.");
        System.out.println("9. Generate summary reports.");
        System.out.print("Enter a choice (-999 to exit) : ");
        int choice = scan.nextInt();
        scan.nextLine();
        System.out.println();
        return choice;
    }

    public void listAllTutors(String str) {
        String v1 = "Tutor ID";
        String v2 = "Tutor Name";
        String v3 = "Gender";
        System.out.print(format("%10s %30s %26s\n", v1, v2, v3));
        System.out.println(str);
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

    public void listAllTutorialGroup(String str) {
        String v1 = "Tutorial Group";
        String v2 = "Capacity";
        System.out.print(format(" %7s %24s \n", v1, v2));
        System.out.println(str);
    }
    
    public void listAllProgramme(String str) {
        String v1 = "Programme Code";
        String v2 = "Programme Name";
        System.out.print(format("%20s %80s\n", v1, v2));
        System.out.println(str);
    }

    public String inputCourseCode() {
        System.out.print("Enter Course Code: ");
        String courseTitle;
        courseTitle = scan.nextLine();
        return courseTitle;
    }

    public String inputTutorName() {
        System.out.print("Enter Tutor Name: ");
        String tutorName;
        tutorName = scan.nextLine();
        return tutorName;
    }
    
    public String inputTutorialGroup() {
        System.out.print("Enter Tutorial Group: ");
        String tutorialGroup = scan.nextLine();
        return tutorialGroup;
    }
    
    public String inputProgrammeCode(){
        System.out.print("Enter programme code: ");
        String programmeCode = scan.nextLine();
        return programmeCode;
    }

    public int inputTutorID() {
        int id;
        System.out.print("Enter the Tutor ID of tutor: ");
        id = scan.nextInt();
        scan.nextLine();
        return id;
    }

    public String confirmStringInput(String a1) {
        System.out.println("You entered: " + a1);
        System.out.print("Is this correct? (Y/N): ");
        String input = scan.nextLine().trim();
        return input;
    }

    public String confirmIntInput(int a1) {
        System.out.println("You entered: " + a1);
        System.out.print("Is this correct? (Y/N): ");
        String input = scan.nextLine().trim();
        return input;
    }

    public String inputSession() {
        System.out.println("\nP:Pratical");
        System.out.println("T:Tutorial");
        System.out.println("L:Lecture");
        System.out.print("Enter Session (P/T/L or -999 to go back): ");
        String session;

        session = scan.nextLine();

        return session.toUpperCase();
    }
    
    public int inputChoice() {
        System.out.print("Enter a choice (-999 to go back to menu): ");
        int choice = scan.nextInt();
        scan.nextLine();
        return choice;
    }

    public int selectFilterOption() {
        System.out.println("Select Filtering Option:");
        System.out.println("1. Filter by Gender");
        System.out.println("2. Filter by Assigned Tutorial Group");
        System.out.print("Enter your choice: ");

        int choice = scan.nextInt();
        scan.nextLine(); // Consume the newline character

        return choice;
    }
    
    public String inputGender() {
        System.out.print("Please enter gender (e.g., M/F): ");
        String gender = scan.nextLine().trim(); // Read user input and trim any extra spaces
        return gender;
    }
    
    public void genSumReport() {
        System.out.println("1. Summary Report of total tutors with courses that are assigned to.");
        System.out.println("2. Summary Report of total tutors with tutorial group with assigned courses.");
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
    
    public void formatting3(int tutorId, String tutorName) {
        System.out.println(String.format("%-10d %-20s", tutorId, tutorName));
    }
    
    public void formatting4(int tutorialGroup) {
        System.out.println(String.format("%-12d", tutorialGroup));
    }
    
    public void formatting5(String courseCode) {
        System.out.println(String.format("%-12s", courseCode));
    }
    
    public void displayHeader(){
        System.out.println("--------------------------------");
        System.out.println(String.format("%-10s %-20s", "Tutor ID", "Tutor Name"));
        System.out.println("--------------------------------");
    }
    
    public void displayHeader2(){
        System.out.println("--------------------------------------------------");
        System.out.println(format("%-10s %-20s %-10s %-10s", "Tutor ID", "Tutor Name", "Gender", "Session"));
        System.out.println("--------------------------------------------------");
    }
    
    public void displayHeader3(){
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(format("%-10s %-20s %-10s %-12s %-30s %-12s %-12s %-12s %-12s",
                "Tutor ID", "Tutor Name", "Gender", "Course Code", "Course Title", "Course Type",
                "Credit Hour", "Course Fee", "Session"));
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

    }
    
    public void displayHeader4(){
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println(format("%-10s %-20s %-10s %-15s %-10s %-20s", "Tutor ID", "Tutor Name", "Gender", "Tutorial Group", "Capacity", "Programme Code"));
        System.out.println("-----------------------------------------------------------------------------------");
    }
    
    public void displayHeader5(){
        System.out.println("List of Tutors with Assigned Courses");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println(String.format("%-10s %-20s %-10s %-12s %-30s", "Tutor ID", "Tutor Name", "Gender", "Course Code", "Course Title"));
        System.out.println("----------------------------------------------------------------------------------------------------");
    }
    
    public void displayReportHeader(){
        System.out.println("\n=============================================================================================================="); //110
        System.out.println("                          TUNKU ABDUL RAHMAN UNIVERSITY OF MANAGEMENT AND TECHNOLOGY                          ");
        System.out.println("                                        TEACHING ASSIGNMENT SUBSYSTEM                                        ");
        System.out.println("");
        System.out.println("                                           TEACHING SUMMARY REPORT                                           ");
        System.out.println("                                        ------------------------------                                        \n"); //30
        displayDate();
        System.out.println("");
        
        // Display header for tutor information including Course Title
        System.out.println(String.format("%-10s %-20s %-12s %-30s", "Tutor ID", "Tutor Name", "Course Code", "Course Title"));
        System.out.println("--------   ----------           -----------  ------------");
    }
    
    public void displayReportHeader2(){
        System.out.println("\n=============================================================================================================="); //110
        System.out.println("                          TUNKU ABDUL RAHMAN UNIVERSITY OF MANAGEMENT AND TECHNOLOGY                          ");
        System.out.println("                                        TEACHING ASSIGNMENT SUBSYSTEM                                        ");
        System.out.println("");
        System.out.println("                                           TEACHING SUMMARY REPORT                                           ");
        System.out.println("                                        ------------------------------                                        \n"); //30
        displayDate();
        System.out.println("");
        
        // Display header for tutor, tutorial group, course code, and course title information
        System.out.println(String.format("%-10s %-20s %-20s %-15s %-30s", "Tutor ID", "Tutor Name", "Tutorial Group", "Course Code", "Course Title"));
        //System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("--------   ----------           --------------       -----------     ------------");
    }
    
    public void displayReportBottom(){
        System.out.println("\n\n\n\n\n                                      END OF THE TEACHING SUMMARY REPORT                                      ");
        System.out.println("=============================================================================================================="); //110

    }
    
    public void displayDate(){
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Define the desired date and time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, d MMMM uuuu, h:mma");

        // Format the current date and time using the formatter
        String formattedDateTime = currentDateTime.format(formatter);

        // Display the formatted date and time
        System.out.println("Generated at: " + formattedDateTime);
    }

    public TutorCourse assignTutorToCourse(int tutorId, String tutorName, String gender, String courseCode, String courseTitle, String courseType, int creditHour, double courseFee) {
        return new TutorCourse(tutorId, tutorName, gender, courseCode, courseTitle, courseType, creditHour, courseFee);
    }
    
    public TutorialGroupTutor assignTutorialGroupsToTutor(String tutorialGroup, int capacity, String programmeCode, int tutorId, String tutorName, String gender) {
        return new TutorialGroupTutor(tutorialGroup, capacity, programmeCode, tutorId, tutorName, gender);
    }
    
    public TutorTutorialGroupCourse addTutorsToATutorialGroupForACourse(int tutorId, String tutorName, String gender, String tutorialGroup, int capacity, String programmeCode, String courseCode, String courseTitle, String courseType, int creditHour, double courseFee, String session) {
        return new TutorTutorialGroupCourse(tutorId, tutorName, gender, tutorialGroup, capacity, programmeCode, courseCode, courseTitle, courseType, creditHour, courseFee, session);
    }

    public void listAllTutorAssigned(String allTutorCourse) {
        System.out.println(allTutorCourse);
    }
    
    public void listAllTutorialGroupAssigned(String allTutorialGroupTutor) {
        System.out.println(allTutorialGroupTutor);
    }
    
    public void listAllTutorsAndTutorialGroupsForACourse(String allTutorTutorialGroupCourse) {
        System.out.println(allTutorTutorialGroupCourse);
    }

    public void listAllTutors(String tutorIdHeader, String tutorNameHeader) {
        System.out.print(format("%10s %30s\n", tutorIdHeader, tutorNameHeader));
    }
    
    public void listAllTutorsAndTutorialGroups(String header1, String header2, String header3) {
        System.out.println(String.format("%-10s %-20s %-12s", header1, header2, header3));
    }
}
