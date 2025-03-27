/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.DoublyLinkedList;
import adt.ListInterface;
import entity.CourseProgramme;

/**
 *
 * @author Cham Yee
 */
public class CourseProgrammeInitializer {
    public ListInterface<CourseProgramme> initializeCoursesProgramme() {
    ListInterface<CourseProgramme> cpList = new DoublyLinkedList<>();
    cpList.add(new CourseProgramme("BACS1053", "Database Management", "Main", 3, 777, "RSW", "Bachelor of Software Engineering (Honours)"));
    cpList.add(new CourseProgramme("BACS2023", "Object-Oriented Programming", "Main", 3, 777, "RSW", "Bachelor of Software Engineering (Honours)"));
    cpList.add(new CourseProgramme("BACS2063", "Data Structure and Algorithm", "Main", 3, 777,"RSW", "Bachelor of Software Engineering (Honours)"));
    cpList.add(new CourseProgramme("BAIT1023", "Web Design and Development", "Resit", 3, 90,"RSW", "Bachelor of Software Engineering (Honours)"));
    cpList.add(new CourseProgramme("BAIT1043", "System Analysis and Design", "Resit", 3, 90,"RSW", "Bachelor of Software Engineering (Honours)"));
    cpList.add(new CourseProgramme("BAIT2203", "Human Computer Interaction", "Repeat", 3, 777, "RSW", "Bachelor of Software Engineering (Honours)"));
    cpList.add(new CourseProgramme("ABBL3104", "Commercial Law of Malaysia", "Main", 3, 777,"RAC", "Bachelor of Accounting (Honours)"));
    cpList.add(new CourseProgramme("BBMF3183", "Strategic Financial Management", "Main", 3, 777,"RAC", "Bachelor of Accounting (Honours)"));
    return cpList;
  }
}
