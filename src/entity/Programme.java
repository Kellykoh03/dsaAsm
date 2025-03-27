/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import static java.lang.String.format;

/**
 *
 * @author Cham Yee
 */
public class Programme implements Comparable<Programme> {
    private String programmeCode;
    private String programmeName;

    public Programme(String programmeCode, String programmeName) {
        this.programmeCode = programmeCode;
        this.programmeName = programmeName;
    }

    public String getProgrammeCode() {
        return programmeCode;
    }

    public void setProgrammeCode(String programmeCode) {
        this.programmeCode = programmeCode;
    }

    public String getProgrammeName() {
        return programmeName;
    }

    public void setProgrammeName(String programmeName) {
        this.programmeName = programmeName;
    }

    @Override
    public String toString() {
        return String.format("%20s %80s", programmeCode, programmeName);
    }

    @Override
    public int compareTo(Programme o) {
        return this.programmeCode.compareTo(o.programmeCode);
    }

    
}
