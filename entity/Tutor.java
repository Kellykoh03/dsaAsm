/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import static java.lang.String.format;

/**
 *
 * @author Tang Yi Jun
 */
public class Tutor implements Comparable<Tutor> {
    private int id;
    private String name;
    private String gender;

    public Tutor() {
    }

    public Tutor(String name) {
        this.name = name;
    }

    public Tutor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Tutor(int id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }
    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return format(" %-28d %-30s %-10s", this.id, this.name, this.gender);
    }

    @Override
    public int compareTo(Tutor t) {
           return this.name.compareTo(t.name);
    }
}

