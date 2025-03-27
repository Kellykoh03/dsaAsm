/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.ListInterface;
import adt.DoublyLinkedList;
import entity.Registered;

/**
 *
 * @author Alex Lee Chia Hau
 */
public class RegisteredInitializer {

    public ListInterface<Registered> initializeRegistered() {
        ListInterface<Registered> rList = new DoublyLinkedList<>();
        rList.add(new Registered("Alex Lee Chia Hau", "M", 20, 1001, "RSW", "BACS2063", "Data Structure and Algorithm", "Main", 3, 777));
        rList.add(new Registered("Jeremy Lee Heng Yue", "M", 20, 1002, "RSW", "BACS2063", "Data Structure and Algorithm", "Main", 3, 777));
        rList.add(new Registered("Ee Yong Feng", "M", 20, 1003, "RSW", "BACS2063", "Data Structure and Algorithm", "Main", 3, 777));
        rList.add(new Registered("Jacky Lee Heng Yue", "M", 20, 1004, "RSW", "BACS2063", "Data Structure and Algorithm", "Main", 3, 777));
        rList.add(new Registered("Wu Jing", "F", 21, 1005, "RSW", "BACS2063", "Data Structure and Algorithm", "Main", 3, 777));
        rList.add(new Registered("Zhao Wei", "M", 20, 1006, "RSW", "BACS2063", "Data Structure and Algorithm", "Main", 3, 777));
        rList.add(new Registered("Feng Yu", "F", 21, 1007, "RSW", "BACS2063", "Data Structure and Algorithm", "Main", 3, 777));
        rList.add(new Registered("Ho Xin", "F", 21, 1008, "RSW", "BACS2063", "Data Structure and Algorithm", "Main", 3, 777));
        rList.add(new Registered("Lim Xu Xin", "F", 21, 1009, "RSW", "BACS2063", "Data Structure and Algorithm", "Main", 3, 777));
        rList.add(new Registered("Wong Fang", "F", 21, 1010, "RSW", "BACS2063", "Data Structure and Algorithm", "Main", 3, 777));
        rList.add(new Registered("Wang Mei", "F", 21, 1011, "RSW", "BACS2063", "Data Structure and Algorithm", "Main", 3, 777));
        rList.add(new Registered("Wong Tao", "M", 25, 1012, "RSW", "BACS2063", "Data Structure and Algorithm", "Main", 3, 777));
        rList.add(new Registered("Yang Hao", "M", 24, 1013, "RSW", "BACS2063", "Data Structure and Algorithm", "Main", 3, 777));
        rList.add(new Registered("Goh Xin", "M", 23, 1014, "RSW", "BACS2063", "Data Structure and Algorithm", "Main", 3, 777));
        rList.add(new Registered("Jenny", "F", 21, 1015, "RSW", "BACS2063", "Data Structure and Algorithm", "Main", 3, 777));
        rList.add(new Registered("Ken", "M", 20, 1016, "RSW", "BACS2063", "Data Structure and Algorithm", "Main", 3, 777));
        return rList;
    }
}
