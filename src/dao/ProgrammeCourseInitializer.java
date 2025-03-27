/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.DoublyLinkedList;
import adt.ListInterface;
import entity.ProgrammeCourse;

/**
 *
 * @author Cham Yee
 */
public class ProgrammeCourseInitializer {
    public ListInterface<ProgrammeCourse> initializeProgrammeCourse() {
    ListInterface<ProgrammeCourse> pcList = new DoublyLinkedList<>();
    //FOCS
    pcList.add(new ProgrammeCourse("RSW", "Bachelor of Software Engineering (Honours)", "BACS1053", "Database Management", "Main", 3, 777));
    pcList.add(new ProgrammeCourse("RSW", "Bachelor of Software Engineering (Honours)", "BACS2023", "Object-Oriented Programming", "Main", 3, 777));
    pcList.add(new ProgrammeCourse("RSW", "Bachelor of Software Engineering (Honours)", "BACS2063", "Data Structure and Algorithm", "Main", 3, 777));
    pcList.add(new ProgrammeCourse("RSW", "Bachelor of Software Engineering (Honours)", "BAIT1023", "Web Design and Development", "Resit", 3, 90));
    //FAFB
    pcList.add(new ProgrammeCourse("RBF", "Bachelor of Banking and Finance (Honours)", "ABBL3104", "Commercial Law of Malaysia", "Main", 3, 777));
    pcList.add(new ProgrammeCourse("RAC", "Bachelor of Accounting (Honours)", "BBMF3183", "Strategic Financial Management", "Main", 3, 777));
    
    return pcList;
  }
}
