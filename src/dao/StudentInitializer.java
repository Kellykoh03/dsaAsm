/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.ListInterface;
import adt.DoublyLinkedList;
import entity.Student;

/**
 *
 * @author Alex Lee Chia Hau
 */
public class StudentInitializer {

    public ListInterface<Student> initializeStudents() {
        ListInterface<Student> sList = new DoublyLinkedList<>();
        sList.add(new Student("Alex Lee Chia Hau", "M", 20, "RSW"));
        sList.add(new Student("Jeremy Lee Heng Yue", "M", 20, "RDS"));
        sList.add(new Student("Ee Yong Feng", "M", 20, "RAC"));
        sList.add(new Student("Jacky Lee Heng Yue", "M", 20, "RST"));
        sList.add(new Student("Wu Jing", "F", 21, "RDS"));
        sList.add(new Student("Zhao Wei", "M", 20, "RDS"));
        sList.add(new Student("Feng Yu", "F", 21, "RDS"));
        sList.add(new Student("Ho Xin", "F", 21, "RDS"));
        sList.add(new Student("Lim Xu Xin", "F", 21, "RDS"));
        sList.add(new Student("Wong Fang", "F", 21, "RDS"));
        sList.add(new Student("Wang Mei", "F", 21, "RDS"));
        sList.add(new Student("Wong Tao", "M", 25, "RDS"));
        sList.add(new Student("Yang Hao", "M", 24, "RDS"));
        sList.add(new Student("Goh Xin", "M", 23, "RDS"));
        sList.add(new Student("Jenny", "F", 21, "RDS"));
        sList.add(new Student("Ken", "M", 20, "RDS"));
        return sList;
    }
}
