/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import java.util.Scanner;

/**
 *
 * @author Alex Lee Chia Hau
 * @author Koh Yoke Yieng
 * @author Cham Yee
 * @author Tang Yi Jun
 */
public class MainMenuUI {
    
    Scanner scan = new Scanner(System.in);
    
    public int getMenuChoice() {
        System.out.println("\nLists of Subsystems.");
        System.out.println("1. Student Registration Management System.");
        System.out.println("2. Course Management System.");
        System.out.println("3. Tutorial Group Management System.");
        System.out.println("4. Teaching Management System.");
        System.out.print("Enter a choice (-999 to exit) : ");
        int choice = scan.nextInt();
        scan.nextLine();
        System.out.println();
        return choice;
    }
}
