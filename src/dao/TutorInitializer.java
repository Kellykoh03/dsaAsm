/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.ListInterface;
import adt.DoublyLinkedList;
import entity.Tutor;

/**
 *
 * @author Tang Yi Jun
 */
public class TutorInitializer {
    public ListInterface<Tutor> initializeTutors() {
    ListInterface<Tutor> tutorList = new DoublyLinkedList<>();
    tutorList.add(new Tutor(8001,"Lim Kok Loeng", "M"));
    tutorList.add(new Tutor(8002,"Lee Xin Joo", "F"));
    tutorList.add(new Tutor(8003,"Ong Yee Jin", "F"));
    tutorList.add(new Tutor(8004,"Ee Feng Yong", "M"));
    return tutorList;
  }
}
