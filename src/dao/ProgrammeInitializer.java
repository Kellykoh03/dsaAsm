/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.DoublyLinkedList;
import adt.ListInterface;
import entity.Programme;
/**
 *
 * @author Cham Yee
 */
public class ProgrammeInitializer {
    public ListInterface<Programme> initializeProgramme() {
    ListInterface<Programme> pList = new DoublyLinkedList<>();
    //FOCS
    pList.add(new Programme("RSW", "Bachelor of Software Engineering (Honours)"));
    pList.add(new Programme("RMM", "Bachelor of Science (Honours) in Management Mathematics with Computing"));
    pList.add(new Programme("REI", "Bachelor of Information Systems (Honours) in Enterprise Information Systems"));
    pList.add(new Programme("RST", "Bachelor of Computer Science (Honours) in Interactive Software Technology"));
    pList.add(new Programme("RIS", "Bachelor of Information Technology (Honours) in Information Security"));
    pList.add(new Programme("RDS", "Bachelor of Computer Science (Honours) in Data Science"));
    pList.add(new Programme("RSD", "Bachelor of Information Technology (Honours) in Software Systems Development"));
    //FAFB
    pList.add(new Programme("RBF", "Bachelor of Banking and Finance (Honours)"));
    pList.add(new Programme("RAC", "Bachelor of Accounting (Honours)"));
    pList.add(new Programme("RAF", "Bachelor of Business (Honours) Accounting and Finance"));
    
    return pList;
  }
}
