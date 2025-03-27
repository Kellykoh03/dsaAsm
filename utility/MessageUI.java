/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

/**
 *
 * @author Alex Lee Chia Hau
 * @author Koh Yoke Yieng
 * @author Cham Yee
 * @author Tang Yi Jun
 */
public class MessageUI {

    public static void displayInvalidChoiceMessage() {
        System.err.println("\nInvalid choice");
    }

    public static void displayStudentNotFound() {
        System.err.println("\nStudent not found.");
    }

    public static void displayExitMessage() {
        System.out.println("\nExiting system");
    }

    public static void backToMenu() {
        System.out.println("\nGoing back to menu.");
    }

    public static void studExist() {
        System.out.println("\nThe student is already exists in the course.\n");
    }

    public static void nameErrorMsg() {
        System.err.println("No numeric letter should be in name and name cannot be empty.");
    }

    public static void intErrorMsg() {
        System.err.println("Enter numeric letters only.");
    }
    
    public static void genderErrorMsg(){
        System.out.println("Please type M or F for gender only.");
    }
    
    public static void displayCourseNotFound(){
        System.out.println("\nCourse not found.");
    }
    
    public static void courseTypeErrorMsg() {
        System.out.println("\nMain, Repeat, Resit only.");
    }
    
    public static void courseCreditHourErrorMsg() {
        System.out.println("\n1, 2, 3, 4 only.");
    }
    
    public static void courseFeesErrorMsg() {
        System.out.println("\nEnter numeric letters only.");
    }
    
    public static void courseTitleErrorMsg() {
        System.out.println("\nNo numeric letter should be in course name.");
    }
    
    public static void programmeNameErrorMsg(){
        System.out.println("\nNo numeric letter should be in programme name.");
    }
    
    public static void displaySuccessMessage(){
        System.out.println("\nAdded successfully.");
    }
    
    public static void displayRemoveSuccessMessage(){
        System.out.println("\nRemove successfully.");
    }
    
    public static void displayAmendSuccessMessage(){
        System.out.println("\nAmend successfully.");
    }
    
    public static void displayErrorMessage(){
        System.out.println("\nCourse not added. Invalid input.");
    }
    
    public static void displayCourseExist(){
        System.out.println("Course already exists in the programme.");
    }
    
    public static void displayCourseSuccessMessage(){
        System.out.println("\nCourse removed successfully.");
    }
    
    public static void displayCourseErrorMessage(){
        System.out.println("\nInvalid index. Course not removed.");
    }

    public static void displayFacultyErrorMessage(){
        System.out.println("\nInvalid faculty choice.");
    }
    
    public static void displayTutorSuccessMessage(){
        System.out.println("\nTutor assigned successfully to the course!\n");
    }
    
    public static void displaySuccessMessage2(){
        System.out.println("\nTutorial group assigned successfully to the tutor!\n");
    }
    
    public static void displaySuccessMessage3(){
        System.out.println("\nTutor added successfully to the tutorial group for this course!\n");
    }

    public static void displaySessionMsg() {
        System.err.print("Plese enter P T or L only: ");
    }
    
    public static void studTutExist() {
        System.out.println("The student for the tutorial group has already exists.\n");
    }
    
    public static void tutFullExist() {
        System.out.println("The tutorial group is fulled.\n");
    }
    
    public static void tutProgExist() {
        System.out.println("The tutorial group for the programme has already exists. \n");
    }
    
    public static void studNotFound2() {
        System.out.println("No student for the specified tutorial group.");
    }
    
    public static void studNotFound3() {
        System.out.println("No tutorial group for the specified programme.");
    }
    
    public static void setStudTutTutGrp() {
        System.out.println("Index out of bounds");
    }
    
    public static void mergeNotFound() {
        System.out.println("No suitable groups found for merging.");
    }
    
    public static void displayMerge() {
        System.out.println("Tutorial Groups after merging:\n");
    }
    
    public static void mergeExceed() {
        System.out.println("Total capacity of groups to merge exceeds the target capacity.");
    }
    
    public static void studAddSuccess(){
        System.out.println("The student has been added to the tutorial group");
    }
    
    public static void notRemovable(){
        System.out.println("This student taking this course is not main or elective, could not remove / The student is not registered in this course.");
    }
    
    public static void studentSuccessfullyRemoved(){
        System.out.println("Student has been removed from this course successfully.");
    }
    
    public static void studNotThisProg(String a1){
        System.out.println("This student is not from " + a1);
    }
    
    public static void mergeSuccess() {
        System.out.println("Groups merged successfully.\n");
    }
}
