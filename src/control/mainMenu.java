/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import boundary.MainMenuUI;
import utility.MessageUI;

/**
 *
 * @author Alex Lee Chia Hau
 * @author Koh Yoke Yieng
 * @author Cham Yee
 * @author Tang Yi Jun
 */
public class mainMenu {

    private MainMenuUI menuUI = new MainMenuUI();

    public static void main(String[] args) {
        mainMenu menu = new mainMenu();
        menu.runMainMenu();
    }

    public void runMainMenu() {
        int choice = 0;
        do {
            choice = menuUI.getMenuChoice();
            switch (choice) {
                case -999:
                    MessageUI.displayExitMessage();
                    break;
                case 1:
                    StudentRegistrationManagement.getInstance().runStudentRegistrationManagement();
                    break;
                case 2:
                    CourseManagement.getInstance().runCourseManagement();
                    break;
                case 3:
                    TutorialGroupManagement.getInstance().runTutorialGroupManagement();
                    break;
                case 4:
                    TeachingAssignment.getInstance().runTeachingAssignment();
                    break;

                default:
                    MessageUI.displayInvalidChoiceMessage();
            }
        } while (choice != -999);
    }

}
