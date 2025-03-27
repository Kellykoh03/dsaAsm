/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import entity.TutorialGroup;
import static java.lang.String.format;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Koh Yoke Yieng
 */
public class TutorialGroupManagementUI {
    Date date = new Date();
    Scanner scan = new Scanner(System.in);
    
    public int getMenuChoice() {
        System.out.println("          Tutorial Group Management       ");
        System.out.println("----------------------------------------------");
        System.out.println("1. Add tutorial group to a programme.");
        System.out.println("2. Remove tutorial group from a programme.");
        System.out.println("3. List all tutorial group for a programme.");
        System.out.println("4. Add students to a tutorial group.");
        System.out.println("5. Remove a student from a tutorial group.");
        System.out.println("6. Change tutorial group for a student.");
        System.out.println("7. List all students in a tutorial group.");
        System.out.println("8. Merge tutorial group based on criteria.");
        System.out.println("9. Generate summary reports.");
        System.out.print("Enter a choice (-999 to exit) : ");
        int choice = scan.nextInt();
        scan.nextLine();
        System.out.println();
        return choice;
    }
    
    public void listAllTutorialGroup(String str){
        String v1 = "Tutorial Group";
        String v2 = "Capacity";
        String v3 = "Programme Code";
        System.out.print(format("%20s %18s %35s\n", v1, v2, v3));
        System.out.println(str);
    }
    
    
    public void listAllProgramme(String str) {
        String v1 = "Programme Code";
        String v2 = "Programme Name";
        System.out.print(format("%20s %80s\n", v1, v2));
        System.out.println(str);
    }
    
    public void listAllStudents(String str) {
        String v1 = "Student Name";
        String v2 = "Age";
        String v3 = "Gender";
        String v4 = "Student ID";
        String v5 = "Programme Code";
        //String v5 = "Programme Code";
        System.out.print(format("%32s %7s %10s %16s %16s\n", v1, v2, v3, v4, v5));
        System.out.println(str);
    }
    
    public void listAllRegistedStudents(String str){
        String v1 = "Student Name";
        String v2 = "Gender";
        String v3 = "Course Code";
        String v4 = "Course Title";
        String v5 = "Tutorial Group";
        System.out.print(format("%31s %6s %9s %18s %30s\n", v1, v2, v3, v4, v5));
        System.out.println(str);
    }
    
    public void listAllStudentTutorial(String str){
        
        System.out.println(str);
    }  
    
    public String inputTutorialGroup(){
        String i;
        System.out.print("Enter Tutorial Group (RSW5, RSW6, etc): ");
        i = scan.nextLine();
        return i;
    }    
    
    public int inputCapacity(){
        System.out.print("Enter Capacity: ");
        int capacity = scan.nextInt();
        scan.nextLine();
        return capacity;
    }
    
    public String inputProgrammeCode(){
        System.out.print("Enter programme code: ");
        String programmeCode = scan.nextLine();
        return programmeCode;
    }
    
    //can't put here, must do in control
    public TutorialGroup inputTutorialGroupDetails(String tutorialGroup, int capacity, String programmeCode) {
        return new TutorialGroup(tutorialGroup,capacity,programmeCode);
   
    }
    
    public int inputStudentID() {
        int studId = -1;
        System.out.print("Enter the student ID of student (-999 to go back): ");
        studId = scan.nextInt();
        scan.nextLine();
        return studId;
    }
    
    public String removeTutorialGroup(){
        String i;
        System.out.println("Enter the tutorial group to remove: ");
        i = scan.nextLine();
        return i;
    }
    
    public int removeAStudent() {
        int i = -1;
        System.out.print("Enter the student id to remove (-999 to go back): ");
        i = scan.nextInt();
        scan.nextLine();
        return i;
    }
    
    public int tutGrpToAmend(){
        System.out.println("Type the tutorial group to amend: ");
        int tutorialGroup = scan.nextInt();
        scan.nextLine();
        return tutorialGroup;
    }
    
    public void scanNextLine() {
        System.out.print("Press <ENTER> to continue.");
        scan.nextLine();
    }
    
    public void getAStringInput() {
        scan.nextLine();
    }

    public int inputTargetCapacity() {
        int targetCapacity = -1;
        System.out.print("Enter the target capacity: ");
        targetCapacity = scan.nextInt();
        scan.nextLine(); 
        return targetCapacity;
    }
    
    public String inputMergeTut1(){
        String i;
        System.out.print("Enter Tutorial Group 1 to merge: ");
        i = scan.nextLine();
        return i;
    }
    
    public String inputMergeTut2(){
        String i;
        System.out.print("Enter Tutorial Group 2 to merge: ");
        i = scan.nextLine();
        return i;
    }
    
    public int inputAge() {
        System.out.print("Enter age: ");
        int age = scan.nextInt();
        scan.nextLine();
        return age;
    }
    
    public String inputGender() {
        System.out.print("Enter gender (M or F): ");
        String gender = scan.nextLine().toUpperCase();
        return gender;
    }
    
    public String inputProgCode() {
        System.out.print("Enter Programme Code: ");
        String progCode;
        progCode = scan.nextLine();
        return progCode;
    }
    
    public String confirmStringInput(String a1) {
        System.out.println("You entered: " + a1);
        System.out.print("Is this correct? (Y/N): ");
        String input = scan.nextLine().trim();
        return input;
    }
    
    public void genSumReport() {
        System.out.println("1. Summary Report of total students'age which registered to a specified tutorial group.");
        System.out.println("2. Summary Report of total students with selected gender to a specified tutorial group.");
    }
    
    public int selectSumReport() {
        System.out.print("Select a summary report: ");
        int choice = scan.nextInt();
        scan.nextLine();
        return choice;
    }
    
    public String confirmIntInput(int a1) {
        System.out.println("You entered: " + a1);
        System.out.print("Is this correct? (Y/N): ");
        String input = scan.nextLine().trim();
        return input;
    }
    
    public int inputConfirm() {
        System.out.print("Do you wish to add a new tutorial group to the programme? (1 to confirm / -999 to go back): ");
        int confirm = scan.nextInt();
        scan.nextLine();
        return confirm;
    }
    
    public int inputConfirm2() {
        System.out.print("Do you wish to change tutorial group for student? (1 to confirm / -999 to go back): ");
        int confirm = scan.nextInt();
        scan.nextLine();
        return confirm;
    }
    
    public void formatting1(String a1, String a2, String a3, String a4, String a5, String a6) {
        System.out.println(format("%22s %6s %9s %16s %16s %18s ", a1, a2, a3, a4, a5, a6));
    }
    
    public void formatting2(String a1, int a2, String a3, int a4, String a5, String a6) {
        System.out.println(format("%22s %6s %9s %16s %16s %18s ", a1, a2, a3, a4, a5, a6));
    }
    
    public void formatting3(String a1, String a2, String a3, String a4) {
        System.out.println(String.format("%17s %20s %25s %20s", a1, a2, a3, a4));
    }
    
    public void formatting6(String a1, int a2, String a3, String a4) {
        System.out.println(String.format("%17s %20s %25s %20s\n", a1, a2, a3, a4));
    }
    
    public void formatting4(int a1, int a2, String a3, String a4) {
        System.out.println(String.format("%17s %30s %15s %15s",  a1, a2, a3, a4));
    }
     
    public void formatting5(String a1, String a2, String a3, String a4) {
        System.out.println(String.format("%15s %13s %18s %20s",  a1, a2, a3, a4));
    }

    public void formatting7(String a1, String a2, String a3) {
        System.out.print(format("%20s %18s %35s\n", a1, a2, a3));
    }
    
    public void formatting8(String a1, String a2, String a3, String a4, String a5) {
        System.out.println(String.format("%17s %15s %20s %15s %15s", a1, a2, a3, a4, a5));
    }
    
    public void formatting9(String a1, int a2, String a3, String a4, String a5) {
        System.out.println(String.format("%17s %15s %20s %15s %15s",  a1, a2, a3, a4, a5));
    }
    
    public void formatting10(String a1, int a2, String a3, String a4){
        System.out.println(format("%9s %16d/30 %17s %50s\n",a1, a2, a3, a4));
    }
    
    public void totalStudentwithAgeOutput(int a1, String a2, int a3) {
        System.out.println("Total students with age " + a1 + " and are in the tutorial group " + a2 + ": " + a3);
    }
    
    public void totalStudentwithGenderOutput (String a1, String a2, int a3) {
        System.out.println("Total students with gender " + a1 + " and are in the tutorial group " + a2 + ": " + a3);
    }
    
    public void newLine() {
        System.out.println("");
    }
    
    public void newStudAddedTut(int a1) {
        System.out.println("\nNew student has been added to tutorial group " + a1 + "\n");
    }
    
    public void newTutAddedProg(String a1) {
        System.out.println("\nNew tutorial group has been added to programme " + a1 + "\n");
    }
    
    public void changeTutOutput(int a1, String a2) {
        System.out.println("Tutorial group for student with ID " + a1 + " has been changed to " + a2 + "\n");
    }
    
    public void studNotFound(int a1) {
        System.out.println("Student with ID " + a1 + " not found.");
    }
    
    public void removeStud(int a1) {
        System.out.println("The student with ID " + a1 + " has been removed.\n");
    }
    
    public void removeTut(String a1) {
        System.out.println("The tutorial group " + a1 + " has been removed.\n");
    }
    
    public void pressEnterToContinue(){
        System.out.println("Press <ENTER> to continue");
        scan.nextLine();
    }
    
    public void addNewTutTitle(){
        System.out.println("=====================================================================================");
        System.out.println("=" + format("%83s", " ") + "=");
        System.out.println("=" + format("%27s", " ") + "Add tutorial group to programme" + format("%25s"," ") + "=");
        System.out.println("=" + format("%83s", " ") + "=");
        System.out.println("=====================================================================================");
    }
    
    public void tutRemoveTitle(){
        System.out.println("=====================================================================================================");
        System.out.println("=" + format("%99s", " ") + "=");
        System.out.println("=" + format("%31s", " ") + "Tutorial group removal from programme" + format("%31s"," ") + "=");
        System.out.println("=" + format("%99s", " ") + "=");
        System.out.println("=====================================================================================================");
    }
    
    public void listAllTutTitle(){
        System.out.println("=====================================================================================");
        System.out.println("=" + format("%83s", " ") + "=");
        System.out.println("=" + format("%25s", " ") + "All tutorial group for a programme" + format("%24s"," ") + "=");
        System.out.println("=" + format("%83s", " ") + "=");
        System.out.println("=====================================================================================");
    }
    
    public void addStudTitle(){
        System.out.println("=====================================================================================");
        System.out.println("=" + format("%83s", " ") + "=");
        System.out.println("=" + format("%27s", " ") + "Add student to tutorial group" + format("%27s"," ") + "=");
        System.out.println("=" + format("%83s", " ") + "=");
        System.out.println("=====================================================================================");
    }
    
    public void studRemoveTitle(){
        System.out.println("=====================================================================================================");
        System.out.println("=" + format("%99s", " ") + "=");
        System.out.println("=" + format("%31s", " ") + "Student removal from tutorial group" + format("%33s"," ") + "=");
        System.out.println("=" + format("%99s", " ") + "=");
        System.out.println("=====================================================================================================");
    }
    
    public void changeTutTitle(){
        System.out.println("=====================================================================================");
        System.out.println("=" + format("%83s", " ") + "=");
        System.out.println("=" + format("%25s", " ") + "Change tutorial group for student" + format("%25s"," ") + "=");
        System.out.println("=" + format("%83s", " ") + "=");
        System.out.println("=====================================================================================");
    }
    
    public void listAllStudTitle(){
        System.out.println("=====================================================================================");
        System.out.println("=" + format("%83s", " ") + "=");
        System.out.println("=" + format("%25s", " ") + "All students for a tutorial group" + format("%25s"," ") + "=");
        System.out.println("=" + format("%83s", " ") + "=");
        System.out.println("=====================================================================================");
    }
    
    public void mergeTutTitle(){
        System.out.println("=====================================================================================");
        System.out.println("=" + format("%83s", " ") + "=");
        System.out.println("=" + format("%25s", " ") + "Merge tutorial group by capacity" + format("%26s"," ") + "=");
        System.out.println("=" + format("%83s", " ") + "=");
        System.out.println("=====================================================================================");
    }
    
    public void summaryTitle(){
        System.out.println("======================================================================================");
        System.out.println("=" + format("%84s", " ") + "=");
        System.out.println("=" + format("%34s", " ") + "Summary reports" + format("%35s"," ") + "=");
        System.out.println("=" + format("%84s", " ") + "=");
        System.out.println("======================================================================================");
    }
    
    public void summaryReport1Title(){
        System.out.println("=============================================================================================");
        System.out.println(format("%18s"," ") + "Tunku Abdul Rahman University Of Management And Technology" + format("%7s"," "));
        System.out.println(format("%29s"," ") + "Tutorial Group Management System" + format("%17s"," "));
        System.out.println("");
        System.out.println(format("%30s"," ") + "Tutorial Group Summary Report 1" + format("%17s"," "));
        System.out.println("");
        System.out.printf("%s %tA, %<tB %<te %<tY, %<tT","Generated at:" , date);
        System.out.println("\n");
    }
    
    public void summaryReport1Title2(){
        System.out.println("=============================================================================================");
        System.out.println(format("%18s"," ") + "Tunku Abdul Rahman University Of Management And Technology" + format("%7s"," "));
        System.out.println(format("%29s"," ") + "Tutorial Group Management System" + format("%17s"," "));
        System.out.println("");
        System.out.println(format("%30s"," ") + "Tutorial Group Summary Report 2" + format("%17s"," "));
        System.out.println("");
        System.out.printf("%s %tA, %<tB %<te %<tY, %<tT","Generated at:" , date);
        System.out.println("\n");
    }
    
    public void summaryReportTitle1End(){
        System.out.println(format("%26s"," ") + "END OF THE TUTORIAL GROUP SUMMARY REPORT" + format("%13s"," "));
        System.out.println("=============================================================================================");
    }
}