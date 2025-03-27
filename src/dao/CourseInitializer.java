/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.DoublyLinkedList;
import adt.ListInterface;
import entity.Course;
/**
 *
 * @author Cham Yee
 */
public class CourseInitializer {
    public ListInterface<Course> initializeCourses() {
    ListInterface<Course> cList = new DoublyLinkedList<>();
    cList.add(new Course("BACS1053", "Database Management", "Main", 3, 777));
    cList.add(new Course("BACS2023", "Object-Oriented Programming", "Main", 3, 777));
    cList.add(new Course("BACS2063", "Data Structure and Algorithm", "Main", 3, 777));
    cList.add(new Course("BAIT1023", "Web Design and Development", "Resit", 3, 90));
    cList.add(new Course("BAIT1043", "System Analysis and Design", "Resit", 3, 90));
    cList.add(new Course("BAIT2203", "Human Computer Interaction", "Repeat", 3, 777));
    cList.add(new Course("ABBL3104", "Commercial Law of Malaysia", "Main", 3, 777));
    cList.add(new Course("BBMF3183", "Strategic Financial Management", "Elective", 3, 777));
    return cList;
  }
}