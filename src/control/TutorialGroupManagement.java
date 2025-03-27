/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package control;

import adt.ListInterface;
import adt.DoublyLinkedList;
import boundary.StudentRegistrationManagementUI;
import boundary.TutorialGroupManagementUI;
import dao.ProgrammeInitializer;
import dao.StudentTutorialInitializer;
import dao.TutorialGroupInitializer;
import dao.TutorialProgrammeInitializer;
import entity.Programme;
import entity.Student;
import entity.StudentTutorial;
import entity.TutorialGroup;
import entity.TutorialProgramme;
import static java.lang.String.format;
import java.util.InputMismatchException;
import utility.MessageUI;

/**
 *
 * @author Koh Yoke Yieng
 */
public class TutorialGroupManagement {

    private static TutorialGroupManagement instance = null;
    private ListInterface<Student> studentList;
    private ListInterface<Programme> programmeList;
    private ListInterface<TutorialGroup> tutorialGroupList;
    private ListInterface<TutorialProgramme> tutorialProgrammeList;
    private ListInterface<StudentTutorial> studentTutorialList;
    private ListInterface<Student> sortedStudentList;
    private ListInterface<Programme> sortedProgrammeList;
    private ListInterface<TutorialGroup> sortedTutorialGroupList;
    private ListInterface<TutorialProgramme> sortedTutorialProgrammeList;
    private ListInterface<StudentTutorial> sortedStudentTutorialList;
    private StudentRegistrationManagementUI studentUI;
    private TutorialGroupManagementUI tutorialGroupUI;

    private TutorialGroupManagement() {
        studentList = StudentRegistrationManagement.getInstance().getStudentList();
        programmeList = new DoublyLinkedList<>();
        tutorialGroupList = new DoublyLinkedList<>();
        studentTutorialList = new DoublyLinkedList<>();
        sortedStudentList = new DoublyLinkedList<>();
        sortedProgrammeList = new DoublyLinkedList<>();
        sortedTutorialGroupList = new DoublyLinkedList<>();
        sortedTutorialProgrammeList = new DoublyLinkedList<>();
        sortedStudentTutorialList = new DoublyLinkedList<>();
        studentUI = new StudentRegistrationManagementUI();
        tutorialGroupUI = new TutorialGroupManagementUI();

        TutorialGroupInitializer ti = new TutorialGroupInitializer();
        ProgrammeInitializer pi = new ProgrammeInitializer();
        TutorialProgrammeInitializer tpi = new TutorialProgrammeInitializer();
        StudentTutorialInitializer sti = new StudentTutorialInitializer();
        tutorialGroupList = ti.initializeTutorialGroup();
        programmeList = pi.initializeProgramme();
        tutorialProgrammeList = tpi.initializeTutorialProgramme();
        studentTutorialList = sti.initializeStudentTutorial();
    }

    public ListInterface<StudentTutorial> getStudentTutorialList() {
        return studentTutorialList;
    }

    public ListInterface<TutorialGroup> getTutorialGroupList() {
        return tutorialGroupList;
    }

    public void runTutorialGroupManagement() {

        int choice = 0;
        do {
            choice = tutorialGroupUI.getMenuChoice();
            switch (choice) {
                case -999:
                    MessageUI.backToMenu();
                    break;
                case 1:
                    tutorialGroupUI.addNewTutTitle();
                    TutorialProgramme tutProg = addTutorialToProgramme();
                    tutorialProgrammeList.add(tutProg);
                    String tutGroupTutGroup;
                    int tutGroupTutCapacity;
                    String tutGroupTutProg;
                    tutGroupTutGroup = tutProg.getTutorialGroup();
                    tutGroupTutCapacity = tutProg.getCapacity();
                    tutGroupTutProg = tutProg.getProgrammeCode();
                    tutorialGroupList.add(new TutorialGroup(tutGroupTutGroup, tutGroupTutCapacity, tutGroupTutProg));
                    break;
                case 2:
                    tutorialGroupUI.tutRemoveTitle();
                    tutorialGroupUI.listAllProgramme(getSortedAllProgramme());
                    removeTutorialFromProgramme();
                    break;
                case 3:
                    tutorialGroupUI.listAllTutTitle();
                    listaAllTutorialGroupForProgramme();
                    break;
                case 4:
                    tutorialGroupUI.addStudTitle();
                    StudentTutorial studTut = addStudentToTutorial();
                    studentTutorialList.add(studTut);
                    break;
                case 5:
                    tutorialGroupUI.studRemoveTitle();
                    removeStudentFromTutorial();
                    break;
                case 6:
                    int ch = tutorialGroupUI.inputConfirm2();
                    if (ch == -999) {
                        MessageUI.backToMenu();
                    } else {
                        tutorialGroupUI.changeTutTitle();
                        changeTutorialGroupForAStudent();
                    }
                    break;
                case 7:
                    tutorialGroupUI.listAllStudTitle();
                    listAllStudentInATutorial();
                    break;
                case 8:
                    tutorialGroupUI.mergeTutTitle();
                    String tutProgramme;
                    String programmeCode = tutorialGroupUI.inputProgrammeCode();
                    listaAllTutorialGroupForProgramme(programmeCode);
                    String tutGroup1 = tutorialGroupUI.inputMergeTut1();
                    String tutGroup2 = tutorialGroupUI.inputMergeTut2();
                    tutProgramme = mergeTutorialGroupByNoOfStud(tutGroup1, tutGroup2);
                    tutorialGroupList.add(new TutorialGroup(tutProgramme, 40, programmeCode.toUpperCase()));
                    tutorialGroupUI.pressEnterToContinue();
                    break;
                case 9:
                    tutorialGroupUI.summaryTitle();
                    generateSummaryReport();
                    break;
                default:
                    MessageUI.displayInvalidChoiceMessage();

            }
        } while (choice != -999);
    }

    public String getAllTutorialGroup() {
        String str = "";
        String count;
        tutorialGroupList.mergeSort();
        for (int i = 1; i <= tutorialGroupList.getNumberOfEntries(); i++) {
            count = String.valueOf(i);
            str += count + tutorialGroupList.getEntry(i) + "\n";
        }
        return str;
    }

    public String getSortedAllStudentTutorial() {
        String str = "";
        sortedStudentTutorialList.clear();
        for (int i = 1; i <= studentTutorialList.getNumberOfEntries(); i++) {
            sortedStudentTutorialList.add(studentTutorialList.getEntry(i));
        }
        sortedStudentTutorialList.mergeSort();

        for (int i = 1; i <= studentTutorialList.getNumberOfEntries(); i++) {
            str += String.valueOf(i) + sortedStudentTutorialList.getEntry(i) + "\n";
        }
        return str;
    }

    public String getAllProgramme() {
        String str = "";
        String count;
        programmeList.mergeSort();
        for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
            count = String.valueOf(i);
            str += count + programmeList.getEntry(i) + "\n";
        }
        return str;
    }

    public String getSortedAllProgramme() {
        String str = "";
        sortedProgrammeList.clear();
        for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
            sortedProgrammeList.add(programmeList.getEntry(i));
        }
        sortedProgrammeList.mergeSort();
        String count;
        for (int i = 1; i <= sortedProgrammeList.getNumberOfEntries(); i++) {
            count = String.valueOf(i);
            str += sortedProgrammeList.getEntry(i) + "\n";
        }
        return str;
    }

    public String getAllStudents() {
        String str = "";
        String count;
        studentList.mergeSort();
        for (int i = 1; i <= studentList.getNumberOfEntries(); i++) {
            count = String.valueOf(i);
            str += count + studentList.getEntry(i) + "\n";
        }
        return str;
    }

    public String getSortedAllStudents() {
        String str = "";
        sortedStudentTutorialList.clear();
        for (int i = 1; i <= studentTutorialList.getNumberOfEntries(); i++) {
            sortedStudentTutorialList.add(studentTutorialList.getEntry(i));
        }
        sortedStudentTutorialList.mergeSort();

        for (int i = 1; i <= sortedStudentTutorialList.getNumberOfEntries(); i++) {
            str += String.valueOf(i) + sortedStudentTutorialList.getEntry(i) + "\n";
        }
        return str;
    }

    public String getSortedAllStudents2() {
        String str = "";
        sortedStudentList.clear();
        for (int i = 1; i <= studentList.getNumberOfEntries(); i++) {
            sortedStudentList.add(studentList.getEntry(i));
        }
        sortedStudentList.mergeSort();

        for (int i = 1; i <= sortedStudentList.getNumberOfEntries(); i++) {
            str += String.valueOf(i) + sortedStudentList.getEntry(i) + "\n";
        }
        return str;
    }

    public String getSortedTutorialProgrammeList() {
        String str = "";
        sortedTutorialProgrammeList.clear();
        for (int i = 1; i <= tutorialProgrammeList.getNumberOfEntries(); i++) {
            sortedTutorialProgrammeList.add(tutorialProgrammeList.getEntry(i));
        }
        sortedTutorialProgrammeList.mergeSort();

        for (int i = 1; i <= sortedTutorialProgrammeList.getNumberOfEntries(); i++) {
            str += String.valueOf(i) + sortedTutorialProgrammeList.getEntry(i) + "\n";
        }
        return str;
    }

    public String getSortedStudentTutorialList() {
        String str = "";
        sortedStudentTutorialList.clear();
        for (int i = 1; i <= studentTutorialList.getNumberOfEntries(); i++) {
            sortedStudentTutorialList.add(studentTutorialList.getEntry(i));
        }
        sortedStudentTutorialList.mergeSort();
        for (int i = 1; i <= sortedStudentTutorialList.getNumberOfEntries(); i++) {
            str += String.valueOf(i) + sortedStudentTutorialList.getEntry(i) + "\n";
        }
        return str;
    }

    private TutorialProgramme addTutorialToProgramme() {
        String tutorialGroup = "";
        int capacity = -1;

        String pProgrammeCode;
        String programmeCode = "XXX";
        String programmeName = "XXXX";

        int inputConfirm = tutorialGroupUI.inputConfirm();
        if (inputConfirm == -999) {
            MessageUI.backToMenu();
        } else {
            do {
                tutorialGroup = tutorialGroupUI.inputTutorialGroup();
                String input = tutorialGroupUI.confirmStringInput(tutorialGroup);
                if (input.toUpperCase().equals("Y")) {
                    break;
                }
            } while (true);
            do {
                capacity = tutorialGroupUI.inputCapacity();
                String input = tutorialGroupUI.confirmIntInput(capacity);
                if (input.toUpperCase().equals("Y")) {
                    break;
                }
            } while (true);

            tutorialGroupUI.listAllProgramme(getSortedAllProgramme());
            do {
                pProgrammeCode = tutorialGroupUI.inputProgrammeCode();
                String input = tutorialGroupUI.confirmStringInput(pProgrammeCode);
                if (input.toUpperCase().equals("Y")) {
                    break;
                }
            } while (true);
            for (int i = 1; i < programmeList.getNumberOfEntries(); i++) {
                if (getProgrammeCode(i).toLowerCase().equals(pProgrammeCode.toLowerCase())) {
                    programmeName = getProgrammeName(i);
                    programmeCode = getProgrammeCode(i);
                }
            }
            for (int i = 1; i <= tutorialProgrammeList.getNumberOfEntries(); i++) {
                if ((getTutProgTutorialGroup(i).toLowerCase().equals(tutorialGroup.toLowerCase())) && (getTutProgProgrammeCode(i).equals(programmeCode))) {
                    MessageUI.tutProgExist();
                    return new TutorialProgramme("", -1, "", "");
                }
            }
            tutorialGroupUI.newTutAddedProg(programmeCode);
            return new TutorialProgramme(tutorialGroup.toUpperCase(), capacity, programmeCode, programmeName);
        }
        return new TutorialProgramme("", -1, "", "");
    }

    private StudentTutorial addStudentToTutorial() {
        int tId;
        String name = "XXX";
        String gender = "X";
        int studId = -1;
        int age = -1;
        String progCode = "";

        String tTutorialGroup;
        String tutorialGroup = "";
        int capacity = -1;
        String cProgrammeCode = "";
        boolean groupFull = false;

        int count = 0;
        int count2 = 0;

        tutorialGroupUI.listAllStudents(getSortedAllStudents2());
        do {

            tId = tutorialGroupUI.inputStudentID();
            String input = tutorialGroupUI.confirmIntInput(tId);
            if (input.toUpperCase().equals("Y")) {
                break;
            }
        } while (true);

        if (tId == -999) {
            MessageUI.backToMenu();
        } else {
            for (int i = 1; i <= studentList.getNumberOfEntries(); i++) {
                if (String.valueOf(getStudID(i)).equals(String.valueOf(tId))) {
                    name = getStudentName(i);
                    gender = getStudentGender(i);
                    age = getStudentAge(i);
                    studId = getStudID(i);
                    progCode = getProgCode(i);
                }
            }

            sortedTutorialGroupList.clear();
            System.out.print(format("%s %16s %25s/%s %20s\n", "No.", "Tutorial Group", "Number Of Students", "Capacity", "Programme Code"));
            for (int index = 1; index <= tutorialGroupList.getNumberOfEntries(); index++) {
                sortedTutorialGroupList.add(tutorialGroupList.getEntry(index));
            }

            for (int i = 1; i <= sortedTutorialGroupList.getNumberOfEntries(); i++) {
                for (int j = 1; j <= studentTutorialList.getNumberOfEntries(); j++) {
                    if (sortedTutorialGroupList.getEntry(i).getTutorialGroupID().toLowerCase().equals(studentTutorialList.getEntry(j).getTutorialGroup().toLowerCase())) {
                        count++;
                    }
                }
                count2++;
                System.out.println(format("%-5d %10s %25d/%d %25s", count2, sortedTutorialGroupList.getEntry(i).getTutorialGroupID(), count, sortedTutorialGroupList.getEntry(i).getCapacity(), sortedTutorialGroupList.getEntry(i).getProgrammeCode()));
                count = 0;
            }

            do {
                tTutorialGroup = tutorialGroupUI.inputTutorialGroup().toUpperCase();
                String input = tutorialGroupUI.confirmStringInput(tTutorialGroup);
                if (input.toUpperCase().equals("Y")) {
                    break;
                }
            } while (true);

            do {
                cProgrammeCode = tutorialGroupUI.inputProgrammeCode();
                String input = tutorialGroupUI.confirmStringInput(cProgrammeCode.toUpperCase());
                if (input.toUpperCase().equals("Y")) {
                    break;
                }
            } while (true);

            if (!cProgrammeCode.toUpperCase().equals(progCode.toUpperCase())) {
                MessageUI.studNotThisProg(cProgrammeCode.toUpperCase());
                return new StudentTutorial("", "", -1, -1, "", -1, "");
            } else {
                for (int i = 1; i <= tutorialGroupList.getNumberOfEntries(); i++) {
                    if (String.valueOf(getTutorialGroup(i)).equals(String.valueOf(tTutorialGroup))) {
                        capacity = getCapacity(i);
                        tutorialGroup = getTutorialGroup(i);
                    }
                    if (getProgrammeCode(i).toUpperCase().equals(cProgrammeCode.toUpperCase()) && capacity >= 30) {
                        groupFull = true;
                        //return new StudentTutorial("", "", -1, -1, -1, -1, "");
                        break;
                    } else {
                        //(String.valueOf(getTutGrpStudentId(i)).equals(String.valueOf(studId))) && (String.valueOf(getTutGrpStudentTutorialGroup(i)).equals(String.valueOf(tutorialGroup)))) {
                        groupFull = false;

                    }
                }
            }
            if (groupFull == false) {
                MessageUI.studAddSuccess();
                return new StudentTutorial(name, gender, age, studId, tutorialGroup, capacity, cProgrammeCode.toUpperCase());
            } else {
                MessageUI.tutFullExist();
            }
        }
        return new StudentTutorial("", "", -1, -1, "", -1, "");
    }

    private TutorialGroup removeTutorialFromProgramme() {
        String str = "";
        int count = 0;
        int count2 = 0;
        sortedTutorialProgrammeList.clear();
        String programmeCode = tutorialGroupUI.inputProgrammeCode();
        boolean found = false;

        sortedTutorialGroupList.clear();
        System.out.print(format("%s %16s %25s/%s %20s\n", "No.", "Tutorial Group", "Number Of Students", "Capacity", "Programme Code"));
        for (int index = 1; index <= tutorialGroupList.getNumberOfEntries(); index++) {
            sortedTutorialGroupList.add(tutorialGroupList.getEntry(index));
        }

        for (int i = 1; i <= sortedTutorialGroupList.getNumberOfEntries(); i++) {
            if (sortedTutorialGroupList.getEntry(i).getProgrammeCode().toLowerCase().equals(programmeCode.toLowerCase())) {
                for (int j = 1; j <= studentTutorialList.getNumberOfEntries(); j++) {
                    if (sortedTutorialGroupList.getEntry(i).getTutorialGroupID().toLowerCase().equals(studentTutorialList.getEntry(j).getTutorialGroup().toLowerCase())) {
                        count++;
                    }
                }
                count2++;
                System.out.println(format("%-5d %10s %25d/%d %25s", count2, sortedTutorialGroupList.getEntry(i).getTutorialGroupID(), count, sortedTutorialGroupList.getEntry(i).getCapacity(), sortedTutorialGroupList.getEntry(i).getProgrammeCode()));
                count = 0;
            }
        }

        while (true) {
            TutorialGroup tutProg = new TutorialGroup();
            String tutProgTutorialGroup = "";
            do {
                tutProgTutorialGroup = tutorialGroupUI.removeTutorialGroup();
                String input = tutorialGroupUI.confirmStringInput(tutProgTutorialGroup);
                if (input.toUpperCase().equalsIgnoreCase("Y")) {
                    break;
                }
            } while (true);

            if (String.valueOf(tutProgTutorialGroup).equals(String.valueOf(-999))) {
                MessageUI.backToMenu();
            } else {
                for (int i = 1; i <= tutorialProgrammeList.getNumberOfEntries(); i++) {
                    sortedTutorialProgrammeList.add(tutorialProgrammeList.getEntry(i));
                }
                for (int index = 1; index <= sortedTutorialGroupList.getNumberOfEntries(); index++) {
                    if (tutProgTutorialGroup.toLowerCase().equals(getTutorialGroup(index).toLowerCase())) {
                        tutProg = tutorialGroupList.remove(index);
                        tutorialGroupUI.removeTut(tutProgTutorialGroup);
                        return tutProg;
                    }
                }
            }
            return tutProg;
        }
    }

    private StudentTutorial removeStudentFromTutorial() {
        String str = "";
        sortedStudentTutorialList.clear();
        String tutorialGroup = "";
        do {
            tutorialGroup = tutorialGroupUI.inputTutorialGroup();
            String input = tutorialGroupUI.confirmStringInput(tutorialGroup);
            if (input.toUpperCase().equals("Y")) {
                break;
            }
        } while (true);
        boolean found = false;
        tutorialGroupUI.formatting8("Tutorial Group", "Student ID", "Student Name", "Gender", "Programme Code");
        for (int i = 1; i <= studentTutorialList.getNumberOfEntries(); i++) {
            sortedStudentTutorialList.add(studentTutorialList.getEntry(i));
        }

        sortedStudentTutorialList.mergeSort();

        for (int i = 1; i <= sortedStudentTutorialList.getNumberOfEntries(); i++) {
            StudentTutorial studentTutorial = sortedStudentTutorialList.getEntry(i);
            if (String.valueOf(studentTutorial.getTutorialGroup()).equalsIgnoreCase(String.valueOf(tutorialGroup))) {
                tutorialGroupUI.formatting9(studentTutorial.getTutorialGroup(), studentTutorial.getStudId(), studentTutorial.getName(), studentTutorial.getGender(), studentTutorial.getProgrammeCode());
                found = true;
            }
        }
        if (!found) {
            return null;
        }
        while (true) {
            StudentTutorial studTut = new StudentTutorial();
            int studTutStudId = -1;
            do {
                studTutStudId = tutorialGroupUI.removeAStudent();
                String input = tutorialGroupUI.confirmIntInput(studTutStudId);
                if (input.toUpperCase().equalsIgnoreCase("Y")) {
                    break;
                }
            } while (true);
            if (studTutStudId == -999) {
                MessageUI.backToMenu();
            } else {
                for (int i = 1; i <= studentTutorialList.getNumberOfEntries(); i++) {
                    if (String.valueOf(studTutStudId).equals(String.valueOf(getStudTutStudentId(i)))) {
                        studTut = studentTutorialList.remove(i);
                        tutorialGroupUI.removeStud(studTutStudId);
                        return studTut;
                    }
                }

            }

            return studTut;
        }
    }

    public boolean listaAllTutorialGroupForProgramme() {
        String programmeCode = tutorialGroupUI.inputProgrammeCode();
        boolean found = false;
        boolean backToMenu = false;
        int count = 0;
        int count2 = 0;

        if (programmeCode.equals("-999")) {
            backToMenu = true;
            return backToMenu;
        } else {
            sortedTutorialGroupList.clear();
            System.out.print(format("%s %16s %25s/%s %20s\n", "No.", "Tutorial Group", "Number Of Students", "Capacity", "Programme Code"));
            for (int index = 1; index <= tutorialGroupList.getNumberOfEntries(); index++) {
                sortedTutorialGroupList.add(tutorialGroupList.getEntry(index));
            }

            for (int i = 1; i <= sortedTutorialGroupList.getNumberOfEntries(); i++) {
                if (sortedTutorialGroupList.getEntry(i).getProgrammeCode().toLowerCase().equals(programmeCode.toLowerCase())) {
                    for (int j = 1; j <= studentTutorialList.getNumberOfEntries(); j++) {
                        if (sortedTutorialGroupList.getEntry(i).getTutorialGroupID().toLowerCase().equals(studentTutorialList.getEntry(j).getTutorialGroup().toLowerCase())) {
                            count++;
                        }
                    }
                    count2++;
                    System.out.println(format("%-5d %10s %25d/%d %25s", count2, sortedTutorialGroupList.getEntry(i).getTutorialGroupID(), count, sortedTutorialGroupList.getEntry(i).getCapacity(), sortedTutorialGroupList.getEntry(i).getProgrammeCode()));
                    count = 0;
                    found = true;
                }
            }

            if (!found) {
                MessageUI.studNotFound3();
            }
        }
        return backToMenu;
    }

    public boolean listaAllTutorialGroupForProgramme(String progCode) {
        boolean found = false;
        boolean backToMenu = false;
        int count = 0;
        int count2 = 0;

        sortedTutorialGroupList.clear();
        System.out.print(format("%s %16s %25s/%s %20s\n", "No.", "Tutorial Group", "Number Of Students", "Capacity", "Programme Code"));
        for (int index = 1; index <= tutorialGroupList.getNumberOfEntries(); index++) {
            sortedTutorialGroupList.add(tutorialGroupList.getEntry(index));
        }

        for (int i = 1; i <= sortedTutorialGroupList.getNumberOfEntries(); i++) {
            if (sortedTutorialGroupList.getEntry(i).getProgrammeCode().toLowerCase().equals(progCode.toLowerCase())) {
                for (int j = 1; j <= studentTutorialList.getNumberOfEntries(); j++) {
                    if (sortedTutorialGroupList.getEntry(i).getTutorialGroupID().toLowerCase().equals(studentTutorialList.getEntry(j).getTutorialGroup().toLowerCase())) {
                        count++;
                    }
                }
                count2++;
                System.out.println(format("%-5d %10s %25d/%d %25s", count2, sortedTutorialGroupList.getEntry(i).getTutorialGroupID(), count, sortedTutorialGroupList.getEntry(i).getCapacity(), sortedTutorialGroupList.getEntry(i).getProgrammeCode()));
                count = 0;
                found = true;
            }
        }

        if (!found) {
            MessageUI.studNotFound3();
        }

        return backToMenu;
    }

    public void listAllStudentInATutorial() {
        String tutorialGroup = "";
        do {
            tutorialGroup = tutorialGroupUI.inputTutorialGroup();
            String input = tutorialGroupUI.confirmStringInput(tutorialGroup);
            if (input.toUpperCase().equals("Y")) {
                break;
            }
        } while (true);
        boolean found = false;
        tutorialGroupUI.formatting3("Tutorial Group", "Student ID", "Student Name", "Gender");
        //System.out.println(String.format("\n%17s %30s %15s %15s", "Tutorial Group", "Student ID", "Student Name", "Gender"));

        for (int i = 1; i <= studentTutorialList.getNumberOfEntries(); i++) {
            StudentTutorial studentTutorial = studentTutorialList.getEntry(i);
            if (String.valueOf(studentTutorial.getTutorialGroup()).equalsIgnoreCase(String.valueOf(tutorialGroup))) {
                tutorialGroupUI.formatting6(studentTutorial.getTutorialGroup(), studentTutorial.getStudId(), studentTutorial.getName(), studentTutorial.getGender());
                found = true;
            }
        }
        if (!found) {
            MessageUI.studNotFound2();
        }
    }

    public void changeTutorialGroupForAStudent() {
        int studentId = -1;
        do {
            studentId = studentUI.inputStudentID();
            String input = tutorialGroupUI.confirmIntInput(studentId);
            if (input.toUpperCase().equals("Y")) {
                break;
            }
        } while (true);

        String newTutorialGroup = "";
        do {
            newTutorialGroup = tutorialGroupUI.inputTutorialGroup();
            String input = tutorialGroupUI.confirmStringInput(newTutorialGroup);
            if (input.toUpperCase().equals("Y")) {
                break;
            }
        } while (true);
        boolean studentFound = false;

        if (studentId == -999) {
            MessageUI.backToMenu();
        } else {
            for (int i = 1; i <= studentTutorialList.getNumberOfEntries(); i++) {
                StudentTutorial studentTutorial = studentTutorialList.getEntry(i);
                if (studentTutorial.getStudId() == studentId) {
                    studentTutorial.setTutorialGroup(newTutorialGroup.toUpperCase());
                    studentFound = true;
                    tutorialGroupUI.changeTutOutput(studentId, newTutorialGroup);
                    break;
                }
            }
            if (!studentFound) {
                tutorialGroupUI.studNotFound(studentId);
            }
        }
    }

    public String mergeTutorialGroupByNoOfStud(String tutGroup1, String tutGroup2) {
        String tutGroup;
        String tutProgramme = "";
        int count = 0;
        int count2 = 0;

        sortedTutorialGroupList.clear();
        for (int index = 1; index <= tutorialGroupList.getNumberOfEntries(); index++) {
            sortedTutorialGroupList.add(tutorialGroupList.getEntry(index));
        }

        for (int i = 1; i <= sortedTutorialGroupList.getNumberOfEntries(); i++) {
            for (int j = 1; j <= studentTutorialList.getNumberOfEntries(); j++) {
                if (sortedTutorialGroupList.getEntry(i).getTutorialGroupID().toLowerCase().equals(studentTutorialList.getEntry(j).getTutorialGroup().toLowerCase())) {
                    count++;
                }
            }
            if (sortedTutorialGroupList.getEntry(i).getTutorialGroupID().toLowerCase().equals(tutGroup1.toLowerCase()) || sortedTutorialGroupList.getEntry(i).getTutorialGroupID().toLowerCase().equals(tutGroup2.toLowerCase())) {
                tutGroup = sortedTutorialGroupList.getEntry(i).getTutorialGroupID();
                tutProgramme = sortedTutorialGroupList.getEntry(i).getProgrammeCode();
                for (int j = 1; j <= studentTutorialList.getNumberOfEntries(); j++) {
                    if (tutGroup.toLowerCase().equals(studentTutorialList.getEntry(j).getTutorialGroup().toLowerCase())) {
                        studentTutorialList.getEntry(j).setTutorialGroup(tutProgramme + "M");
                    }
                }
            }
            count2++;
            count = 0;
        }
        MessageUI.mergeSuccess();
        return (tutProgramme + "M").toUpperCase();
    }

    private void summaryReport1() {
        int tAge;
        String name;
        String gender;
        int studId;
        int age = -1;
        int count = 0;
        String tutorialGroup;

        do {
            try {
                tAge = tutorialGroupUI.inputAge();
                break;
            } catch (InputMismatchException ime) {
                MessageUI.intErrorMsg();
                tutorialGroupUI.getAStringInput();
            }
        } while (true);

        do {
            tutorialGroup = tutorialGroupUI.inputTutorialGroup();
            String input = tutorialGroupUI.confirmStringInput(String.valueOf(tutorialGroup));
            if (input.toUpperCase().equals("Y")) {
                break;
            }
        } while (true);

        String programmeCode;
        tutorialGroupUI.summaryReport1Title();
        tutorialGroupUI.formatting1("Student Name", "Age", "Gender", "Student ID", "Programme Code", "Tutorial Group");
        for (int i = 1; i <= studentTutorialList.getNumberOfEntries(); i++) {
            StudentTutorial student = studentTutorialList.getEntry(i);
            if ((String.valueOf(getStudentTutorialAge(i)).equals(String.valueOf(tAge))) && (getStudTutorialTutorialGroupID(i).toLowerCase().equals(tutorialGroup))) {
                name = getStudentTutorialName(i);
                gender = getStudentTutorialGender(i);
                age = getStudentTutorialAge(i);
                studId = getStudTutorialID(i);
                tutorialGroup = getStudTutorialTutorialGroupID(i);
                programmeCode = getSTudTutProgrammeCode(i);

                tutorialGroupUI.formatting2(name, age, gender, studId, programmeCode, tutorialGroup);
                count++;
            }
        }
        tutorialGroupUI.newLine();
        tutorialGroupUI.totalStudentwithAgeOutput(age, tutorialGroup, count);
        tutorialGroupUI.newLine();
        tutorialGroupUI.newLine();
        tutorialGroupUI.summaryReportTitle1End();
    }

    public void summaryReport2() {
        String tGender;
        String name;
        int studId;
        int age;
        String gender = "";
        int count = 0;
        String tutorialGroup;

        do {
            tGender = tutorialGroupUI.inputGender();
            if (!tGender.toUpperCase().equals("M") && !tGender.toUpperCase().equals("F")) {
                MessageUI.genderErrorMsg();
            } else {
                String input = studentUI.confirmStringInput(tGender);
                if (input.toUpperCase().equals("Y")) {
                    break;

                }

            }
        } while (true);

        do {
            tutorialGroup = tutorialGroupUI.inputTutorialGroup();
            String input = tutorialGroupUI.confirmStringInput(String.valueOf(tutorialGroup));
            if (input.toUpperCase().equals("Y")) {
                break;
            }
        } while (true);

        String programmeCode;
        tutorialGroupUI.summaryReport1Title2();
        tutorialGroupUI.formatting1("Student Name", "Age", "Gender", "Student ID", "Programme Code", "Tutorial Group");
        for (int i = 1; i <= studentTutorialList.getNumberOfEntries(); i++) {
            if (getStudentTutorialGender(i).toLowerCase().equals(tGender.toLowerCase()) && (getStudTutorialTutorialGroupID(i).toLowerCase().equals(tutorialGroup.toLowerCase()))) {
                name = getStudentTutorialName(i);
                gender = getStudentTutorialGender(i);
                age = getStudentTutorialAge(i);
                studId = getStudTutorialID(i);
                tutorialGroup = getStudTutorialTutorialGroupID(i);
                programmeCode = getSTudTutProgrammeCode(i);

                tutorialGroupUI.formatting2(name, age, gender, studId, programmeCode, tutorialGroup);
                count++;
            }
        }
        tutorialGroupUI.newLine();
        tutorialGroupUI.totalStudentwithGenderOutput(gender, tutorialGroup, count);
        tutorialGroupUI.newLine();
        tutorialGroupUI.newLine();
        tutorialGroupUI.summaryReportTitle1End();
    }

    public int getStudTutStudentId(int i) {
        if (i >= 0 && i <= studentTutorialList.getNumberOfEntries()) {
            StudentTutorial studTut = studentTutorialList.getEntry(i);
            return studTut.getStudId();
        } else {
            return 0;
        }
    }

    public int getStudTutStudentAge(int i) {
        if (i >= 0 && i <= studentTutorialList.getNumberOfEntries()) {
            StudentTutorial studTut = studentTutorialList.getEntry(i);
            return studTut.getAge();
        } else {
            return 0;
        }
    }

    public String getStudTutTutorialGroup(int i) {
        if (i >= 0 && i <= studentTutorialList.getNumberOfEntries()) {
            StudentTutorial studTut = studentTutorialList.getEntry(i);
            return studTut.getTutorialGroup();
        } else {
            return null;
        }
    }

    public void setStudTutTutorialGroup(int i, String tutorialGroup) {
        if (i >= 0 && i < studentTutorialList.getNumberOfEntries()) {
            StudentTutorial studTut = studentTutorialList.getEntry(i);
            studTut.setTutorialGroup(tutorialGroup);
        } else {
            // Handle the case where the index is out of bounds
            MessageUI.setStudTutTutGrp();
            //System.out.println("Index out of bounds");
        }
    }

    public String getStudTutStudentName(int i) {
        if (i >= 0 && i <= studentTutorialList.getNumberOfEntries()) {
            StudentTutorial studTut = studentTutorialList.getEntry(i);
            return studTut.getName();
        } else {
            return null;
        }
    }

    public String getStudTutStudentGender(int i) {
        if (i >= 0 && i <= studentTutorialList.getNumberOfEntries()) {
            StudentTutorial studTut = studentTutorialList.getEntry(i);
            return studTut.getGender();
        } else {
            return null;
        }
    }

    public String getSTudTutProgrammeCode(int i) {
        if (i >= 0 && i <= studentTutorialList.getNumberOfEntries()) {
            StudentTutorial studTut = studentTutorialList.getEntry(i);
            return studTut.getProgrammeCode();
        } else {
            return null;
        }
    }

    public String getTutorialGroup(int i) {
        if (i >= 0 && i <= tutorialGroupList.getNumberOfEntries()) {
            TutorialGroup tutorialGroup = tutorialGroupList.getEntry(i);
            return tutorialGroup.getTutorialGroupID();
        } else {
            return null;
        }
    }

    public String getProgCode(int i) {
        if (i >= 0 && i <= studentList.getNumberOfEntries()) {
            Student student = studentList.getEntry(i);
            return student.getProgrammeCode();
        } else {
            return null;
        }
    }

    public String getStudTutProgCode(int i) {
        if (i >= 0 && i <= studentTutorialList.getNumberOfEntries()) {
            StudentTutorial student = studentTutorialList.getEntry(i);
            return student.getProgrammeCode();
        } else {
            return null;
        }
    }

    public String getTutProgTutorialGroup(int i) {
        if (i >= 0 && i <= tutorialProgrammeList.getNumberOfEntries()) {
            TutorialProgramme tutProg = tutorialProgrammeList.getEntry(i);
            return tutProg.getTutorialGroup();
        } else {
            return null;
        }
    }

    public void setTutorialGroup(int i, String tutorialGroupValue) {
        if (i >= 0 && i < tutorialGroupList.getNumberOfEntries()) {
            TutorialGroup tutorialGroup = tutorialGroupList.getEntry(i);
            tutorialGroup.setTutorialGroup(tutorialGroupValue);
        }
    }

    public String getTutGrpStudentTutorialGroup(int i) {
        if (i >= 0 && i <= tutorialGroupList.getNumberOfEntries()) {
            TutorialGroup tutorialGroup = tutorialGroupList.getEntry(i);
            return tutorialGroup.getTutorialGroupID();
        } else {
            return null;
        }
    }

    public int getCapacity(int i) {
        if (i >= 0 && i <= tutorialGroupList.getNumberOfEntries()) {
            TutorialGroup tutorialGroup = tutorialGroupList.getEntry(i);
            return tutorialGroup.getCapacity();
        } else {
            return 0;
        }
    }

    public int getStudID(int i) {
        if (i >= 0 && i <= studentList.getNumberOfEntries()) {
            Student student = studentList.getEntry(i);
            return student.getId();
        } else {
            return 0;
        }
    }

    public int getStudTutorialID(int i) {
        if (i >= 0 && i <= studentTutorialList.getNumberOfEntries()) {
            StudentTutorial student = studentTutorialList.getEntry(i);
            return student.getStudId();
        } else {
            return 0;
        }
    }

    public String getStudTutorialTutorialGroupID(int i) {
        if (i >= 0 && i <= studentTutorialList.getNumberOfEntries()) {
            StudentTutorial student = studentTutorialList.getEntry(i);
            return student.getTutorialGroup();
        } else {
            return null;
        }
    }

    public String getProgrammeCode(int i) {
        if (i >= 0 && i <= programmeList.getNumberOfEntries()) {
            Programme programme = programmeList.getEntry(i);
            return programme.getProgrammeCode();
        } else {
            return null;
        }
    }

    public String getTutProgProgrammeCode(int i) {
        if (i >= 0 && i <= programmeList.getNumberOfEntries()) {
            TutorialProgramme tutProg = tutorialProgrammeList.getEntry(i);
            return tutProg.getProgrammeCode();
        } else {
            return null;
        }
    }

    public String getProgrammeName(int i) {
        if (i >= 0 && i <= programmeList.getNumberOfEntries()) {
            Programme programme = programmeList.getEntry(i);
            return programme.getProgrammeName();
        } else {
            return null;
        }
    }

    public String getStudentName(int i) {
        if (i >= 0 && i <= studentList.getNumberOfEntries()) {
            Student student = studentList.getEntry(i);
            return student.getName();
        } else {
            return null;
        }
    }

    public String getStudentTutorialName(int i) {
        if (i >= 0 && i <= studentTutorialList.getNumberOfEntries()) {
            StudentTutorial student = studentTutorialList.getEntry(i);
            return student.getName();
        } else {
            return null;
        }
    }

    public String getStudentTutorialGender(int i) {
        if (i >= 0 && i <= studentTutorialList.getNumberOfEntries()) {
            StudentTutorial student = studentTutorialList.getEntry(i);
            return student.getGender();
        } else {
            return null;
        }
    }

    public String getStudentGender(int i) {
        if (i >= 0 && i <= studentList.getNumberOfEntries()) {
            Student student = studentList.getEntry(i);
            return student.getGender();
        } else {
            return null;
        }
    }

    public int getStudentAge(int i) {
        if (i >= 0 && i <= studentList.getNumberOfEntries()) {
            Student student = studentList.getEntry(i);
            return student.getAge();
        } else {
            return 0;
        }
    }

    public int getStudentTutorialAge(int i) {
        if (i >= 0 && i <= studentTutorialList.getNumberOfEntries()) {
            StudentTutorial student = studentTutorialList.getEntry(i);
            return student.getAge();
        } else {
            return 0;
        }
    }

    public static TutorialGroupManagement getInstance() {
        if (instance == null) {
            instance = new TutorialGroupManagement();
        }
        return instance;
    }

    private void generateSummaryReport() {
        int ch;
        tutorialGroupUI.genSumReport();
        ch = tutorialGroupUI.selectSumReport();
        switch (ch) {
            case 1:
                summaryReport1();
                tutorialGroupUI.newLine();
                break;
            case 2:
                summaryReport2();
                tutorialGroupUI.newLine();
                break;
        }
    }
}