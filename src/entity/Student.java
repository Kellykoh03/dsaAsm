/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import static java.lang.String.format;

/**
 *
 * @author Alex Lee Chia Hau
 */
public class Student implements Comparable<Student>{
    private String name;
    private String gender;
    private int age;
    private int id;
    private String programmeCode;
    private static int studentID = 1001;

    public Student() {
        
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, String gender, int age, String programmeCode) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.programmeCode = programmeCode;
        this.id = studentID++;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getProgrammeCode() {
        return programmeCode;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProgrammeCode(String programmeCode) {
        this.programmeCode = programmeCode;
    }
    
    @Override
    public String toString(){
        return format("%31s %7d %10s %16d %16s",this.name , this.age ,this.gender, this.id, this.programmeCode);
    }

    @Override
    public int compareTo(Student s) {
        return this.name.compareTo(s.name);
    }
}
