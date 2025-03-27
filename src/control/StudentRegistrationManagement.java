/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.ListInterface;
import boundary.StudentRegistrationManagementUI;
import dao.RegisteredInitializer;
import dao.StudentInitializer;
import entity.Course;
import entity.Programme;
import entity.Registered;
import entity.Student;
import java.util.InputMismatchException;
import utility.MessageUI;

/**
 *
 * @author Alex Lee Chia Hau
 */
public class StudentRegistrationManagement {

    private static StudentRegistrationManagement instance = null;

    private ListInterface<Student> studentList;
    private ListInterface<Course> courseList;
    private ListInterface<Registered> registeredList;
    private ListInterface<Student> sortedStudentList;
    private ListInterface<Course> sortedCourseList;
    private ListInterface<Registered> sortedRegisteredList;
    private ListInterface<Programme> programmeList;
    private ListInterface<Programme> sortedProgrammeList;
    private StudentRegistrationManagementUI studentUI;

    private StudentRegistrationManagement() {
        studentList = new DoublyLinkedList<>();
        courseList = CourseManagement.getInstance().getCourseList();
        registeredList = new DoublyLinkedList<>();
        sortedStudentList = new DoublyLinkedList<>();
        sortedCourseList = new DoublyLinkedList<>();
        sortedRegisteredList = new DoublyLinkedList<>();
        programmeList = CourseManagement.getInstance().getProgrammeList();
        sortedProgrammeList = new DoublyLinkedList<>();
        studentUI = new StudentRegistrationManagementUI();

        StudentInitializer si = new StudentInitializer();
        RegisteredInitializer ri = new RegisteredInitializer();
        studentList = si.initializeStudents();
        registeredList = ri.initializeRegistered();
    }

    public static StudentRegistrationManagement getInstance() {
        if (instance == null) {
            instance = new StudentRegistrationManagement();
        }
        return instance;
    }
    
    public ListInterface<Student> getStudentList(){
        return studentList;
    }

    public void runStudentRegistrationManagement() {

        int choice = 0;
        do {
            while (true) {
                try {
                    choice = studentUI.getMenuChoice();
                    break;
                } catch (InputMismatchException ime) {
                    MessageUI.intErrorMsg();
                    studentUI.getAStringInput();
                }
            }

            switch (choice) {
                case -999:
                    MessageUI.backToMenu();
                    break;
                case 1:
                    studentUI.addNewStudentTitle();
                    addNewStudents();
                    break;
                case 2:
                    studentUI.studentRemovalTitle();
                    studentUI.listAllStudents(getSortedAllStudents());
                    removeStudent();
                    break;
                case 3:
                    int ch = studentUI.inputConfirm2();
                    if (ch == -999) {
                        MessageUI.backToMenu();
                    } else {
                        studentUI.amendStudentDetailsTitle();
                        amendStudDetails();
                    }
                    break;
                case 4:
                    studentUI.searchStudentRegisteredTitle();
                    searchStudentRegistered();
                    break;
                case 5:
                    studentUI.addStudentToCourseTitle();
                    Registered reg = addStudentToCourse();
                    registeredList.add(reg);
                    break;
                case 6:
                    studentUI.removeStudentFromCourseTitle();
                    studentUI.listAllRegistered(getSortedAllRegistered());
                    removeStudentFromCourse();
                    break;
                case 7:
                    calFeePaid();
                    break;
                case 8:
                    studentUI.studentFilterTitle();
                    filterStudentForCourses();
                    break;
                case 9:
                    generateSummaryReport();
                    break;
                default:
                    MessageUI.displayInvalidChoiceMessage();
            }
        } while (choice != -999);
    }

    public void addNewStudents() {
        String name;
        String gender;
        int age;
        String programmeCode;
        boolean programmeFound = false;
        int inputConfirm = studentUI.inputConfirm();
        if (inputConfirm == -999) {
            MessageUI.backToMenu();
        } else if (inputConfirm == 1) {
            do {
                name = studentUI.inputName();
                if (name.matches(".*\\d.*") || name.matches("")) {
                    MessageUI.nameErrorMsg();
                    continue; // Repeat the loop to input name again
                }
                String input = studentUI.confirmStringInput(name);
                if (input.toUpperCase().equalsIgnoreCase("Y")) {
                    break; // Break the loop if name is confirmed
                }
            } while (true);

            do {
                gender = studentUI.inputGender();
                if (!gender.toUpperCase().equals("M") && !gender.toUpperCase().equals("F")) {
                    MessageUI.genderErrorMsg();
                } else {
                    String input = studentUI.confirmStringInput(gender);
                    if (input.toUpperCase().equals("Y")) {
                        break;
                    }
                }
            } while (true);

            while (true) {
                try {
                    age = studentUI.inputAge();
                    break;
                } catch (InputMismatchException ime) {
                    MessageUI.intErrorMsg();
                    studentUI.getAStringInput();
                }
            }

            studentUI.listAllProgramme(getSortedAllProgrammes());
            
            do {
                programmeCode = studentUI.inputProgrammeCode();
                for(int i = 1; i <= programmeList.getNumberOfEntries();i++){
                    if(programmeList.getEntry(i).getProgrammeCode().toLowerCase().equals(programmeCode.toLowerCase())){
                        programmeCode = programmeList.getEntry(i).getProgrammeCode();
                        programmeFound = true;
                        break;
                    }
                    else{
                        programmeCode = "";
                    }
                }
                if(programmeFound == false){
                    System.out.println("The entered programme code is not found. Your entry has not been accepted");
                }
                String input = studentUI.confirmStringInput(programmeCode);
                if (input.toUpperCase().equalsIgnoreCase("Y")) {
                    break; // Break the loop if name is confirmed
                }
            } while (true);

            studentUI.scanNextLine();
            Student student = studentUI.inputStudentDetails(name, gender, age, programmeCode);
            studentList.add(student);
        }
    }

    public String getSortedAllStudents() {
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

    public String getSortedAllCourses() {
        String str = "";
        sortedCourseList.clear();
        for (int i = 1; i <= courseList.getNumberOfEntries(); i++) {
            sortedCourseList.add(courseList.getEntry(i));
        }
        sortedCourseList.mergeSort();
        String count;
        for (int i = 1; i <= sortedCourseList.getNumberOfEntries(); i++) {
            count = String.valueOf(i);
            str += count + sortedCourseList.getEntry(i) + "\n";
        }
        return str;
    }

    public String getSortedAllRegistered() {
        String str = "";
        sortedRegisteredList.clear();
        for (int i = 1; i <= registeredList.getNumberOfEntries(); i++) {
            sortedRegisteredList.add(registeredList.getEntry(i));
        }
        sortedRegisteredList.mergeSort();
        String count;
        for (int i = 1; i <= sortedRegisteredList.getNumberOfEntries(); i++) {
            count = String.valueOf(i);
            str += count + sortedRegisteredList.getEntry(i) + "\n";
        }
        return str;
    }

    public Student removeStudent() {
        Student student = new Student();
        for (int i = 1; i <= studentList.getNumberOfEntries(); i++) {
            sortedStudentList.add(studentList.getEntry(i));
        }
        int studID = studentUI.removeAStudent();
        for (int index = 1; index <= sortedStudentList.getNumberOfEntries(); index++) {
            if (String.valueOf(studID).equals(String.valueOf(getStudID(index)))) {
                student = studentList.remove(index);
                return student;
            }
        }
        sortedStudentList.clear();
        return student;
    }

    public void amendStudDetails() {
        String name;
        String gender;
        int age;
        String programmeCode;
        boolean studentFound = false;
        studentUI.listAllStudents(getSortedAllStudents());
        int id;
        do {
            id = studentUI.studToAmend();
            String input = studentUI.confirmIntInput(id);
            if (input.toUpperCase().equalsIgnoreCase("Y")) {
                break;
            }
        } while (true);

        if (id == -999) {
            studentFound = true;
            MessageUI.backToMenu();
        }
        for (int i = 1; i <= studentList.getNumberOfEntries(); i++) {
            if (String.valueOf(getStudID(i)).equals(String.valueOf(id))) {
                studentUI.amendStudDetailsOutput(getStudentName(i), id);

                do {
                    name = studentUI.inputName();
                    if (name.matches(".*\\d.*")) {
                        MessageUI.nameErrorMsg();
                        continue; // Repeat the loop to input name again
                    }
                    String input = studentUI.confirmStringInput(name);
                    if (input.toUpperCase().equalsIgnoreCase("Y")) {
                        break; // Break the loop if name is confirmed
                    }
                } while (true);

                do {
                    gender = studentUI.inputGender();
                    if (!gender.toUpperCase().equals("M") && !gender.toUpperCase().equals("F")) {
                        MessageUI.genderErrorMsg();
                    }
                    break;
                } while (true);

                while (true) {
                    try {
                        age = studentUI.inputAge();
                        break;
                    } catch (InputMismatchException ime) {
                        MessageUI.intErrorMsg();
                        studentUI.getAStringInput();
                    }
                }

                do {
                    programmeCode = studentUI.inputProgrammeCode();
                    String input = studentUI.confirmStringInput(programmeCode);
                    if (input.toUpperCase().equalsIgnoreCase("Y")) {
                        break; // Break the loop if name is confirmed
                    }
                } while (true);

                studentUI.scanNextLine();

                Student student = studentUI.inputStudentDetails(name, gender, age, programmeCode);
                studentList.replace(i, student);
                studentFound = true;
                break;
            }
        }
        if (studentFound == false) {
            MessageUI.displayStudentNotFound();
        }
    }

    private void searchStudentRegistered() {
        studentUI.listAllCourses(getSortedAllCourses());
        String cCourseCode = studentUI.inputCourseCode();
        String name;
        String gender;
        int studID;
        int age;
        String progCode;

        String courseCode;
        String courseTitle;
        String courseType;
        int courseCreditHour;
        double courseFee;
        if (cCourseCode.equals("-999")) {
            MessageUI.backToMenu();
        } else {
            studentUI.searchResultOutput(cCourseCode.toUpperCase());
            studentUI.formatting1("Student Name", "Age", "Gender", "Student ID", "Programme Code", "Course Code", "Course Title", "Course Type", "Credit Hour", "Course Fee");
            for (int i = 1; i <= registeredList.getNumberOfEntries(); i++) {
                if (getRegStudentCourseCode(i).toLowerCase().equals(cCourseCode.toLowerCase())) {
                    name = getRegStudentName(i);
                    gender = getRegStudentGender(i);
                    age = getRegStudentAge(i);
                    studID = getRegStudentID(i);
                    progCode = getRegProgCode(i);

                    courseTitle = getRegStudentCourseTitle(i);
                    courseCode = getRegStudentCourseCode(i);
                    courseType = getRegStudentCourseType(i);
                    courseCreditHour = getRegStudentCourseCreditHour(i);
                    courseFee = getRegStudentCourseFee(i);
                    studentUI.formatting2(name, age, gender, studID, progCode, courseCode, courseTitle, courseType, courseCreditHour, courseFee);
                    studentUI.newLine();
                }
            }
        }
    }

    private Registered addStudentToCourse() {
        int cId;
        String name = "XXX";
        String gender = "X";
        int studID = -1;
        int age = -1;
        String progCode = "";

        String cCourseCode;
        String courseTitle = "XXX";
        String courseType = "Not Exist";
        int courseCreditHour = -1;
        String courseCode = "XXXX";
        double courseFee = -1;

        studentUI.listAllStudents(getSortedAllStudents());
        do {
            cId = studentUI.inputStudentID();
            String input = studentUI.confirmIntInput(cId);
            if (input.toUpperCase().equals("Y")) {
                break; // Break the loop if name is confirmed
            }
        } while (true);
        if (cId == -999) {
            MessageUI.backToMenu();
        } else {
            for (int i = 1; i <= studentList.getNumberOfEntries(); i++) {
                if (String.valueOf(getStudID(i)).equals(String.valueOf(cId))) {
                    name = getStudentName(i);
                    gender = getStudentGender(i);
                    age = getStudentAge(i);
                    studID = getStudID(i);
                    progCode = getProgCode(i);
                }
            }
            studentUI.listAllCourses(getSortedAllCourses());
            do {
                cCourseCode = studentUI.inputCourseCode();
                String input = studentUI.confirmStringInput(cCourseCode);
                if (input.toUpperCase().equals("Y")) {
                    break;
                }
            } while (true);

            for (int i = 1; i <= courseList.getNumberOfEntries(); i++) {
                if (getCourseCode(i).toLowerCase().equals(cCourseCode.toLowerCase())) {
                    courseTitle = getCourseTitle(i);
                    courseCode = getCourseCode(i);
                    courseType = getCourseType(i);
                    courseCreditHour = getCreditHour(i);
                    courseFee = getCourseFee(i);
                }
            }
        }
        for (int i = 1; i <= registeredList.getNumberOfEntries(); i++) {
            if ((getRegStudentID(i) == studID) && (getRegStudentCourseCode(i).equals(courseCode))) {
                MessageUI.studExist();
                return new Registered("", "", -1, -1, "", "", "", "", -1, -1);
            }
        }
        studentUI.newStudAdded(courseTitle);
        return new Registered(name, gender, age, studID, progCode, courseCode, courseTitle, courseType, courseCreditHour, courseFee);
    }

    private Registered removeStudentFromCourse() {
        boolean studentRemoved = false;
        Registered reg = new Registered();
        int regStudID = -1;
        do {
            regStudID = studentUI.removeAStudent();
            studentUI.getAStringInput();
            String input = studentUI.confirmIntInput(regStudID);
            if (input.toUpperCase().equalsIgnoreCase("Y")) {
                break;
            }
        } while (true);

        if (String.valueOf(regStudID).equals(String.valueOf(-999))) {
            MessageUI.backToMenu();
        } else {
            for (int i = 1; i <= registeredList.getNumberOfEntries(); i++) {
                sortedRegisteredList.add(registeredList.getEntry(i));
            }
            for (int index = 1; index <= sortedRegisteredList.getNumberOfEntries(); index++) {
                if (String.valueOf(regStudID).equals(String.valueOf(getRegStudentID(index))) && (getRegStudentCourseType(index).toLowerCase().equals("main") || getCourseType(index).toLowerCase().equals("elective"))) {
                    reg = registeredList.remove(index);
                    studentRemoved = true;
                }

            }
            if (studentRemoved == true) {
                MessageUI.studentSuccessfullyRemoved();
            } else {
                MessageUI.notRemovable();
            }
        }

        sortedStudentList.clear();
        return reg;
    }

    private void calFeePaid() {
        int cId;
        String name = "";
        String gender;
        int studID;
        int age;
        String progCode;

        String courseCode;
        String courseTitle;
        String courseType;
        int courseCreditHour;
        double courseFee;
        double totalCourseFee = 0;

        studentUI.listAllRegistered(getSortedAllRegistered());
        cId = studentUI.inputStudentID();
        studentUI.studBill(cId);
        studentUI.formattingB1("Course Code", "Course Title", "Course Type", "Credit Hour", "Course Fee");
        for (int i = 1; i <= registeredList.getNumberOfEntries(); i++) {
            if (String.valueOf(getRegStudentID(i)).equals(String.valueOf(cId))) {
                name = getRegStudentName(i);
                
                courseTitle = getRegStudentCourseTitle(i);
                courseCode = getRegStudentCourseCode(i);
                courseType = getRegStudentCourseType(i);
                courseCreditHour = getRegStudentCourseCreditHour(i);
                courseFee = getRegStudentCourseFee(i);
                totalCourseFee += courseFee;
                studentUI.formattingB2(courseCode, courseTitle, courseType, courseCreditHour, courseFee);
            }
        }
        studentUI.totalFeeOutput(name, totalCourseFee);
    }

    private void filterStudentForCourses() {
        studentUI.listAllRegistered(getSortedAllRegistered());
        studentUI.selectFilter();
        int ch = studentUI.inputChoice();
        switch (ch) {
            case 0:
                MessageUI.backToMenu();
                break;
            case 1:
                studentUI.filterByCourseTitle();
                filterByCourse();
                break;
            case 2:
                studentUI.filterByGenderTitle();
                filterByGender();
                break;
        }
    }

    public String getCourseTitle(int i) {
        if (i >= 0 && i <= courseList.getNumberOfEntries()) {
            Course course = courseList.getEntry(i);
            return course.getCourseTitle();
        } else {
            return null;
        }
    }

    public String getCourseCode(int i) {
        if (i >= 0 && i <= courseList.getNumberOfEntries()) {
            Course course = courseList.getEntry(i);
            return course.getCourseCode();
        } else {
            return null;
        }
    }

    public String getCourseType(int i) {
        if (i >= 0 && i <= courseList.getNumberOfEntries()) {
            Course course = courseList.getEntry(i);
            return course.getCourseType();
        } else {
            return null;
        }
    }

    public int getCreditHour(int i) {
        if (i >= 0 && i <= courseList.getNumberOfEntries()) {
            Course course = courseList.getEntry(i);
            return course.getCreditHour();
        } else {
            return 0;
        }
    }

    public double getCourseFee(int i) {
        if (i >= 0 && i <= courseList.getNumberOfEntries()) {
            Course course = courseList.getEntry(i);
            return course.getCourseFee();
        } else {
            return 0;
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

    public String getRegStudentName(int i) {
        if (i >= 0 && i <= registeredList.getNumberOfEntries()) {
            Registered regStud = registeredList.getEntry(i);
            return regStud.getStudentName();
        } else {
            return null;
        }
    }

    public String getRegStudentGender(int i) {
        if (i >= 0 && i <= registeredList.getNumberOfEntries()) {
            Registered regStud = registeredList.getEntry(i);
            return regStud.getStudentGender();
        } else {
            return null;
        }
    }

    public int getRegStudentAge(int i) {
        if (i >= 0 && i <= registeredList.getNumberOfEntries()) {
            Registered regStud = registeredList.getEntry(i);
            return regStud.getStudentAge();
        } else {
            return 0;
        }
    }

    public int getRegStudentID(int i) {
        if (i >= 0 && i <= registeredList.getNumberOfEntries()) {
            Registered regStud = registeredList.getEntry(i);
            return regStud.getId();
        } else {
            return 0;
        }
    }

    public String getRegProgCode(int i) {
        if (i >= 0 && i <= registeredList.getNumberOfEntries()) {
            Registered regStud = registeredList.getEntry(i);
            return regStud.getProgrammeCode();
        } else {
            return null;
        }
    }

    public String getRegStudentCourseCode(int i) {
        if (i >= 0 && i <= registeredList.getNumberOfEntries()) {
            Registered regStud = registeredList.getEntry(i);
            return regStud.getCourseCode();
        } else {
            return null;
        }
    }

    public String getRegStudentCourseTitle(int i) {
        if (i >= 0 && i <= registeredList.getNumberOfEntries()) {
            Registered regStud = registeredList.getEntry(i);
            return regStud.getCourseTitle();
        } else {
            return null;
        }
    }

    public String getRegStudentCourseType(int i) {
        if (i >= 0 && i <= registeredList.getNumberOfEntries()) {
            Registered regStud = registeredList.getEntry(i);
            return regStud.getCourseType();
        } else {
            return null;
        }
    }

    public int getRegStudentCourseCreditHour(int i) {
        if (i >= 0 && i <= registeredList.getNumberOfEntries()) {
            Registered regStud = registeredList.getEntry(i);
            return regStud.getCourseCreditHour();
        } else {
            return 0;
        }
    }

    public double getRegStudentCourseFee(int i) {
        if (i >= 0 && i <= registeredList.getNumberOfEntries()) {
            Registered regStud = registeredList.getEntry(i);
            return regStud.getCourseFee();
        } else {
            return 0;
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

    public String getStudentGender(int i) {
        if (i >= 0 && i <= studentList.getNumberOfEntries()) {
            Student student = studentList.getEntry(i);
            return student.getGender();
        } else {
            return null;
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

    public String getProgCode(int i) {
        if (i >= 0 && i <= studentList.getNumberOfEntries()) {
            Student student = studentList.getEntry(i);
            return student.getProgrammeCode();
        } else {
            return null;
        }
    }

    private void filterByCourse() {
        String cCourseCode = studentUI.inputCourseCode();
        String name;
        String gender;
        int studID;
        int age;
        String progCode;

        String courseCode;
        String courseTitle;
        String courseType;
        int courseCreditHour;
        double courseFee;

        studentUI.filterCourseOutput(cCourseCode.toUpperCase());
        studentUI.formatting1("Student Name", "Age", "Gender", "Student ID", "Programme Code", "Course Code", "Course Title", "Course Type", "Credit Hour", "Course Fee");
        for (int i = 1; i <= registeredList.getNumberOfEntries(); i++) {
            if (getRegStudentCourseCode(i).toLowerCase().equals(cCourseCode.toLowerCase())) {
                name = getRegStudentName(i);
                gender = getRegStudentGender(i);
                age = getRegStudentAge(i);
                studID = getRegStudentID(i);
                progCode = getRegProgCode(i);

                courseTitle = getRegStudentCourseTitle(i);
                courseCode = getRegStudentCourseCode(i);
                courseType = getRegStudentCourseType(i);
                courseCreditHour = getRegStudentCourseCreditHour(i);
                courseFee = getRegStudentCourseFee(i);
                studentUI.formatting2(name, age, gender, studID, progCode, courseCode, courseTitle, courseType, courseCreditHour, courseFee);
            }
        }
    }

    private void filterByGender() {
        String cGender = studentUI.inputGender();
        String name;
        String gender;
        int studID;
        int age;
        String progCode;

        String courseCode;
        String courseTitle;
        String courseType;
        int courseCreditHour;
        double courseFee;

        studentUI.filterGenderOutput(cGender);
        studentUI.formatting1("Student Name", "Age", "Gender", "Student ID", "Programme Code", "Course Code", "Course Title", "Course Type", "Credit Hour", "Course Fee");
        for (int i = 1; i <= registeredList.getNumberOfEntries(); i++) {
            if (getRegStudentGender(i).toLowerCase().equals(cGender.toLowerCase())) {
                name = getRegStudentName(i);
                gender = getRegStudentGender(i);
                age = getRegStudentAge(i);
                studID = getRegStudentID(i);
                progCode = getRegProgCode(i);

                courseTitle = getRegStudentCourseTitle(i);
                courseCode = getRegStudentCourseCode(i);
                courseType = getRegStudentCourseType(i);
                courseCreditHour = getRegStudentCourseCreditHour(i);
                courseFee = getRegStudentCourseFee(i);
                studentUI.formatting2(name, age, gender, studID, progCode, courseCode, courseTitle, courseType, courseCreditHour, courseFee);
            }
        }
    }

    private void summaryReport1() {
        studentUI.newLine();
        studentUI.listAllStudents(getSortedAllStudents());
        String cGender;
        String cProgCode;

        do {
            cGender = studentUI.inputGender();
            if (!cGender.toUpperCase().equals("M") && !cGender.toUpperCase().equals("F")) {
                MessageUI.genderErrorMsg();
            } else {
                String input = studentUI.confirmStringInput(cGender);
                if (input.toUpperCase().equals("Y")) {
                    break;
                }
            }
        } while (true);

        do {
            cProgCode = studentUI.inputProgrammeCode();
            String input = studentUI.confirmStringInput(cProgCode);
            if (input.toUpperCase().equals("Y")) {
                break;
            }
        } while (true);

        String name;
        String gender;
        int studID;
        int age = -1;
        int count = 0;
        String progCode;

        studentUI.summaryReport1Title();
        studentUI.formatting3("Student Name", "Age", "Gender", "Student ID", "Programme Code");
        for (int i = 1; i <= studentList.getNumberOfEntries(); i++) {
            if ((getStudentGender(i).toLowerCase().equals(cGender.toLowerCase())) && (getProgCode(i).toLowerCase().equals(cProgCode.toLowerCase()))) {
                name = getStudentName(i);
                gender = getStudentGender(i);
                age = getStudentAge(i);
                studID = getStudID(i);
                progCode = getProgCode(i);

                studentUI.formatting4(name, age, gender, studID, progCode);
                count++;
            }
        }
        studentUI.newLine();
        studentUI.totalStudentwithGenderOutput(cGender, cProgCode, count);
        studentUI.newLine();
        studentUI.newLine();
        studentUI.summaryReportTitle1End();
    }

    private void summaryReport2() {
        studentUI.newLine();
        int cAge;
        String name;
        String gender;
        int studID;
        int age = -1;
        int count = 0;
        String progCode;
        String courseCode;
        double totalFee = 0;

        while (true) {
            try {
                cAge = studentUI.inputAge();
                break;
            } catch (InputMismatchException ime) {
                MessageUI.intErrorMsg();
                studentUI.getAStringInput();
            }
        }

        do {
            studentUI.listAllCourses(getSortedAllCourses());
            courseCode = studentUI.inputCourseCode();
            String input = studentUI.confirmStringInput(courseCode);
            if (input.toUpperCase().equals("Y")) {
                break; // Break the loop if name is confirmed
            }
        } while (true);

        String courseTitle = "";
        String courseType;
        int courseCreditHour;
        double courseFee;

        studentUI.summaryReport2Title();
        studentUI.formatting1("Student Name", "Age", "Gender", "Student ID", "Programme Code", "Course Code", "Course Title", "Course Type", "Credit Hour", "Course Fee");
        for (int i = 1; i <= registeredList.getNumberOfEntries(); i++) {
            if ((String.valueOf(getRegStudentAge(i)).equals(String.valueOf(cAge))) && (getRegStudentCourseCode(i).toLowerCase().equals(courseCode.toLowerCase()))) {
                name = getRegStudentName(i);
                gender = getRegStudentGender(i);
                age = getRegStudentAge(i);
                studID = getRegStudentID(i);
                progCode = getRegProgCode(i);

                courseTitle = getRegStudentCourseTitle(i);
                courseCode = getRegStudentCourseCode(i);
                courseType = getRegStudentCourseType(i);
                courseCreditHour = getRegStudentCourseCreditHour(i);
                courseFee = getRegStudentCourseFee(i);
                totalFee += courseFee;

                studentUI.formatting2(name, age, gender, studID, progCode, courseCode, courseTitle, courseType, courseCreditHour, courseFee);
                count++;
            }
        }
        studentUI.newLine();
        studentUI.totalStudentwithAgeOutput(cAge, courseCode, count);
        System.out.println("Total course fee collected for course " + courseTitle + " : RM " + totalFee);
        studentUI.newLine();
        studentUI.newLine();
        studentUI.summaryReportTitle2End();
    }

    private void generateSummaryReport() {
        int ch;
        studentUI.genSumReport();
        ch = studentUI.selectSumReport();
        switch (ch) {
            case 1:
                summaryReport1();
                studentUI.pressEnterToContinue();
                break;

            case 2:
                summaryReport2();
                studentUI.pressEnterToContinue();
                break;
        }
    }
    
    public String getSortedAllProgrammes() {
        String str = "";
        sortedProgrammeList.clear();

        for (int i = 1; i <= programmeList.getNumberOfEntries(); ++i) {
            sortedProgrammeList.add((Programme)programmeList.getEntry(i));
        }

        sortedProgrammeList.mergeSort();

        for (int i = 1; i <= sortedProgrammeList.getNumberOfEntries(); ++i) {
            String count = String.valueOf(i);
            str = str + count + String.valueOf(sortedProgrammeList.getEntry(i)) + "\n";
        }

        return str;
    }
}
