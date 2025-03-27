/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Cham Yee
 */
package control;

import adt.DoublyLinkedList;
import adt.ListInterface;
import boundary.CourseManagementUI;
import dao.CourseInitializer;
import dao.CourseProgrammeInitializer;
import dao.FacultyInitializer;
import dao.ProgrammeCourseInitializer;
import dao.ProgrammeInitializer;
import dao.SemesterInitializer;
import entity.Course;
import entity.CourseProgramme;
import entity.Faculty;
import entity.Programme;
import entity.ProgrammeCourse;
import entity.Semester;
import java.util.InputMismatchException;
import utility.MessageUI;

public class CourseManagement {

    private static CourseManagement instance = null;

    private ListInterface<Course> courseList;
    private ListInterface<Course> sortedCourseList;
    private ListInterface<Programme> programmeList;
    private ListInterface<Programme> sortedProgrammeList;
    private ListInterface<Semester> semesterList;
    private ListInterface<Faculty> facultyList;
    private ListInterface<Faculty> sortedFacultyList;
    private ListInterface<CourseProgramme> courseProgrammeList;
    private ListInterface<CourseProgramme> sortedCourseProgrammeList;
    private ListInterface<ProgrammeCourse> programmeCourseList;
    private ListInterface<ProgrammeCourse> sortedProgrammeCourseList;
    private CourseManagementUI courseUI;

    private CourseManagement() {
        courseList = new DoublyLinkedList<>();
        sortedCourseList = new DoublyLinkedList();
        programmeList = new DoublyLinkedList<>();
        sortedProgrammeList = new DoublyLinkedList<>();
        semesterList = new DoublyLinkedList<>();
        facultyList = new DoublyLinkedList<>();
        sortedFacultyList = new DoublyLinkedList<>();
        courseProgrammeList = new DoublyLinkedList<>();
        sortedCourseProgrammeList = new DoublyLinkedList<>();
        programmeCourseList = new DoublyLinkedList<>();
        sortedProgrammeCourseList = new DoublyLinkedList<>();
        courseUI = new CourseManagementUI();

        CourseInitializer ci = new CourseInitializer();
        courseList = ci.initializeCourses();
        SemesterInitializer si = new SemesterInitializer();
        semesterList = si.initializeSemester();
        FacultyInitializer fi = new FacultyInitializer();
        facultyList = fi.initializeFaculty();
        ProgrammeInitializer pi = new ProgrammeInitializer();
        programmeList = pi.initializeProgramme();
        CourseProgrammeInitializer cpi = new CourseProgrammeInitializer();
        courseProgrammeList = cpi.initializeCoursesProgramme();
        ProgrammeCourseInitializer pci = new ProgrammeCourseInitializer();
        programmeCourseList = pci.initializeProgrammeCourse();
    }

    public static CourseManagement getInstance() {
        if (instance == null) {
            instance = new CourseManagement();
        }
        return instance;
    }

    public ListInterface<Course> getCourseList() {
        return courseList;
    }

    public ListInterface<Programme> getProgrammeList() {
        return programmeList;
    }

    public void runCourseManagement() {

        int choice = 0;
        do {
            choice = courseUI.getMenuChoice();
            switch (choice) {
                case -999:
                    MessageUI.displayExitMessage();
                    break;
                case 1:
                    ProgrammeCourse progC = addProgrammeToCourses();
                    programmeCourseList.add(progC);
                    break;
                case 2:
                    removeProgrammeFromCourse();
                    break;
                case 3:
                    addNewCourseToProgrammes();
                    break;
                case 4:
                    removeCourseFromProgramme();
                    break;
                case 5:
                    searchCoursesOfferedInSemester();
                    break;
                case 6:
                    courseUI.amendCourseTitle();
                    int ch = courseUI.inputConfirm2();
                    if (ch == -999) {
                        MessageUI.backToMenu();
                    } else {
                        amendCourseDetails();
                    }
                    break;
                case 7:
                    courseUI.listCourseFacultyTitle();
                    listCoursesByFaculties();
                    break;
                case 8:
                    listAllCoursesForProgramme();
                    break;
                case 9:
                    generateSummaryReports();
                    break;
                default:
                    MessageUI.displayInvalidChoiceMessage();
            }
        } while (choice != -999);
    }

    public String getAllCourses() {
        String str = "";
        String count;
        courseList.mergeSort();
        for (int i = 1; i <= courseList.getNumberOfEntries(); i++) {
            count = String.valueOf(i);
            str += count + courseList.getEntry(i) + "\n";
        }
        return str;
    }

    public String getAllProgramme() {
        String str = "";
        String count;
        courseList.mergeSort();
        for (int i = 1; i <= courseList.getNumberOfEntries(); i++) {
            count = String.valueOf(i);
            str += count + courseList.getEntry(i) + "\n";
        }
        return str;
    }

    public String getSortedAllCourses() {
        String str = "";
        sortedCourseList.clear();

        for (int i = 1; i <= courseList.getNumberOfEntries(); ++i) {
            sortedCourseList.add((Course) courseList.getEntry(i));
        }

        sortedCourseList.mergeSort();

        for (int i = 1; i <= sortedCourseList.getNumberOfEntries(); ++i) {
            String count = String.valueOf(i);
            str = str + count + String.valueOf(sortedCourseList.getEntry(i)) + "\n";
        }

        return str;
    }

    public String getSortedAllProgrammes() {
        String str = "";
        sortedProgrammeList.clear();

        for (int i = 1; i <= programmeList.getNumberOfEntries(); ++i) {
            sortedProgrammeList.add((Programme) programmeList.getEntry(i));
        }

        sortedProgrammeList.mergeSort();

        for (int i = 1; i <= sortedProgrammeList.getNumberOfEntries(); ++i) {
            String count = String.valueOf(i);
            str = str + count + String.valueOf(sortedProgrammeList.getEntry(i)) + "\n";
        }

        return str;
    }

    public String getSortedAllProgrammeCourse() {
        String str = "";
        sortedProgrammeCourseList.clear();

        for (int i = 1; i <= programmeCourseList.getNumberOfEntries(); ++i) {
            sortedProgrammeCourseList.add((ProgrammeCourse) programmeCourseList.getEntry(i));
        }

        sortedProgrammeCourseList.mergeSort();

        for (int i = 1; i <= sortedProgrammeCourseList.getNumberOfEntries(); ++i) {
            String count = String.valueOf(i);
            str = str + count + String.valueOf(sortedProgrammeCourseList.getEntry(i)) + "\n";
        }

        return str;
    }

    public String getSortedAllCourseProgramme() {
        String str = "";
        sortedCourseProgrammeList.clear();

        for (int i = 1; i <= courseProgrammeList.getNumberOfEntries(); ++i) {
            sortedCourseProgrammeList.add((CourseProgramme) courseProgrammeList.getEntry(i));
        }

        sortedCourseProgrammeList.mergeSort();

        for (int i = 1; i <= sortedCourseProgrammeList.getNumberOfEntries(); ++i) {
            String count = String.valueOf(i);
            str = str + count + String.valueOf(sortedCourseProgrammeList.getEntry(i)) + "\n";
        }

        return str;
    }

    public String getSortedAllFacultyCourses() {
        String str = "";
        sortedFacultyList.clear();

        for (int i = 1; i <= facultyList.getNumberOfEntries(); ++i) {
            sortedFacultyList.add((Faculty) facultyList.getEntry(i));
        }

        sortedFacultyList.mergeSort();

        for (int i = 1; i <= sortedFacultyList.getNumberOfEntries(); ++i) {
            String count = String.valueOf(i);
            str = str + count + String.valueOf(sortedFacultyList.getEntry(i)) + "\n";
        }

        return str;
    }

    private ProgrammeCourse addProgrammeToCourses() {
        courseUI.addProgrammeCourseTitle();
        ProgrammeCourse addedProgrammeCourse = new ProgrammeCourse();

        String programmeCode;
        String programmeName = "";

        courseUI.listAllProgramme(getSortedAllProgrammes());
        programmeCode = courseUI.inputProgrammeCode().toUpperCase();
        if (programmeCode.equals("-999")) {
            MessageUI.backToMenu();
        } else {
            for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
                if (getProgrammeCode(i).equalsIgnoreCase(programmeCode)) {
                    programmeName = getProgrammeName(i);
                    break;
                }
            }

            String courseCode = selectCourseForProgramme(programmeName);
            if (courseCode.equals("-999")) {
                MessageUI.backToMenu();
            } else {
                boolean courseExists = false;
                for (int i = 1; i <= programmeCourseList.getNumberOfEntries(); i++) {
                    ProgrammeCourse existingCourse = programmeCourseList.getEntry(i);
                    if (existingCourse.getCourseCode().equalsIgnoreCase(courseCode) && existingCourse.getProgrammeCode().equalsIgnoreCase(programmeCode)) {
                        courseExists = true;
                        break;
                    }
                }
                if (courseExists) {
                    MessageUI.displayCourseExist();
                } else {
                    for (int i = 1; i <= courseList.getNumberOfEntries(); i++) {
                        if (getCourseCode(i).equalsIgnoreCase(courseCode)) {
                            String courseTitle = getCourseTitle(i);
                            String courseType = getCourseType(i);
                            int creditHour = getCreditHour(i);
                            double courseFee = getCourseFee(i);

                            addedProgrammeCourse = new ProgrammeCourse(programmeCode, programmeName, courseCode, courseTitle, courseType, creditHour, courseFee);
                            MessageUI.displaySuccessMessage();
                            break;
                        }
                    }
                }
            }
        }
        return addedProgrammeCourse;
    }

    private String selectCourseForProgramme(String programmeName) {
        courseUI.listAllCourses(getSortedAllCourses());
        String courseCode = "";
        do {
            courseCode = courseUI.inputCourseCode().toUpperCase();
            String input = courseUI.confirmStringInput(courseCode);
            if (input.equalsIgnoreCase("Y")) {
                break;
            }
        } while (true);
        return courseCode;
    }

    private ProgrammeCourse removeProgrammeFromCourse() {
        courseUI.removeProgrammeCourseTitle();
        courseUI.availableCourse();
        courseUI.listAllCourses(getSortedAllCourses());
        String courseCodeToRemove = courseUI.removeProgrammeFromCourse();

        if (courseCodeToRemove.equals("-999")) {
            MessageUI.backToMenu();
            return new ProgrammeCourse();
        }

        boolean courseFound = false;
        for (int i = 1; i <= programmeCourseList.getNumberOfEntries(); i++) {
            ProgrammeCourse programmeCourse = programmeCourseList.getEntry(i);
            if (programmeCourse.getCourseCode() != null && programmeCourse.getCourseCode().equalsIgnoreCase(courseCodeToRemove)) {
                if (!courseFound) {
                    courseUI.listOfProgramme();
                    courseFound = true;
                }
                String programmeCode = programmeCourse.getProgrammeCode();
                String programmeName = programmeCourse.getProgrammeName();
                courseUI.displayProgramme(programmeCode, programmeName);
            }
        }

        if (!courseFound) {
            MessageUI.displayInvalidChoiceMessage();
            return new ProgrammeCourse();
        }

        String programmeCodeToRemove = courseUI.removeAProgramme();
        if (programmeCodeToRemove.equals("-999")) {
            MessageUI.backToMenu();
            return new ProgrammeCourse();
        }

        for (int i = 1; i <= programmeCourseList.getNumberOfEntries(); i++) {
            ProgrammeCourse programmeCourse = programmeCourseList.getEntry(i);
            if (programmeCourse.getCourseCode() != null && programmeCourse.getCourseCode().equalsIgnoreCase(courseCodeToRemove)
                    && programmeCourse.getProgrammeCode().equalsIgnoreCase(programmeCodeToRemove)) {
                ProgrammeCourse removedProgramme = programmeCourseList.remove(i);
                sortedProgrammeCourseList.clear();
                MessageUI.displayRemoveSuccessMessage();
                return removedProgramme;
            }
        }

        sortedProgrammeCourseList.clear();
        return new ProgrammeCourse();
    }

    private void addNewCourseToProgrammes() {
        String courseCode;
        String courseTitle = "";
        String courseType = "";
        int creditHour;
        double courseFee = -1;

        String programmeCode;
        String programmeName = "";
        String semester = "";
        String facultyCode = "";
        String facultyName = "";

        courseUI.addCourseProgrammeTitle();
        int inputConfirm = courseUI.inputConfirm();
        if (inputConfirm == -999) {
            MessageUI.backToMenu();
        } else if (inputConfirm == 1) {
            do {
                courseCode = courseUI.inputCourseCode2().toUpperCase();
                String input = courseUI.confirmStringInput(courseCode);
                if (input.toUpperCase().equalsIgnoreCase("Y")) {
                    break;
                }
            } while (true);

            do {
                courseTitle = courseUI.inputCourseTitle().toUpperCase();
                if (courseTitle.matches(".\\d.")) {
                    MessageUI.courseTitleErrorMsg();
                    continue;
                }
                String input = courseUI.confirmStringInput(courseTitle);
                if (input.toUpperCase().equalsIgnoreCase("Y")) {
                    break;
                }
            } while (true);

            do {
                courseType = courseUI.inputCourseType().toUpperCase();
                if (!courseType.equalsIgnoreCase("Main") && !courseType.equalsIgnoreCase("Repeat") && !courseType.equalsIgnoreCase("Resit") && !courseType.equalsIgnoreCase("Elective")) {
                    MessageUI.courseTypeErrorMsg();
                }
                break;
            } while (true);

            do {
                creditHour = courseUI.inputCourseCreditHour();
                if (!(creditHour >= 1 && creditHour <= 4)) {
                    MessageUI.courseCreditHourErrorMsg();
                    continue;
                }
                break;
            } while (true);

            while (true) {
                try {
                    courseFee = courseUI.inputCourseFee();
                    break;
                } catch (InputMismatchException ime) {
                    MessageUI.courseFeesErrorMsg();
                    courseUI.getAStringInput();
                }
            }

            do {
                programmeCode = courseUI.inputProgrammeCode().toUpperCase();
                String input = courseUI.confirmStringInput2(programmeCode);
                if (input.toUpperCase().equalsIgnoreCase("Y")) {
                    break;
                }
            } while (true);

            do {
                semester = courseUI.inputSemester();
                String input = courseUI.confirmStringInput(semester);
                if (input.toUpperCase().equalsIgnoreCase("Y")) {
                    break;
                }
            } while (true);

            do {
                facultyCode = courseUI.inputFaculty().toUpperCase();
                String input = courseUI.confirmStringInput(facultyCode);
                if (input.toUpperCase().equalsIgnoreCase("Y")) {
                    break;
                }
            } while (true);
            facultyName = getFacultyNameFromCode(facultyCode);

            programmeName = getProgrammeNameFromCode(programmeCode);

            CourseProgramme courseProgramme = courseUI.inputCourseProgrammeDetails(courseCode, courseTitle, courseType, creditHour, courseFee, programmeCode, programmeName);
            Course course = courseUI.inputCourseDetails2(courseCode, courseTitle, courseType, creditHour, courseFee);
            Semester semCourse = courseUI.inputSemCourseDetails(semester, courseCode, courseTitle, courseType, creditHour, courseFee);
            Faculty facCourse = courseUI.inputFacultyCourseDetails(facultyCode.toUpperCase(), facultyName, courseCode, courseTitle, courseType, creditHour, courseFee);

            courseProgrammeList.add(courseProgramme);
            courseList.add(course);
            semesterList.add(semCourse);
            facultyList.add(facCourse);
            MessageUI.displaySuccessMessage();
        }
    }

    private CourseProgramme removeCourseFromProgramme() {
        courseUI.removeCourseProgrammeTitle();
        System.out.println("Available programme:");
        System.out.println("===================================");
        courseUI.listAllProgramme(getSortedAllProgrammes());
        String programmeCodeToRemove = courseUI.removeAProgramme();

        if (programmeCodeToRemove.equals("-999")) {
            MessageUI.backToMenu();
            return new CourseProgramme();
        }
        courseUI.displayCourseHeading();
        for (int i = 1; i <= courseProgrammeList.getNumberOfEntries(); i++) {
            CourseProgramme courseProgramme = courseProgrammeList.getEntry(i);
            if (courseProgramme.getProgrammeCode().equalsIgnoreCase(programmeCodeToRemove)) {
                String courseCode = courseProgramme.getCourseCode();
                String courseTitle = courseProgramme.getCourseTitle();

                courseUI.displayCourse(courseCode, courseTitle);
            }
        }

        String courseCodeToRemove = courseUI.removeACourse();

        if (courseCodeToRemove.equals("-999")) {
            MessageUI.backToMenu();
            return new CourseProgramme();
        }

        for (int i = 1; i <= courseProgrammeList.getNumberOfEntries(); i++) {
            CourseProgramme courseProgramme = courseProgrammeList.getEntry(i);
            if (courseProgramme.getProgrammeCode().equalsIgnoreCase(programmeCodeToRemove)
                    && courseProgramme.getCourseCode().equalsIgnoreCase(courseCodeToRemove)) {
                CourseProgramme removedCourse = courseProgrammeList.remove(i);
                sortedCourseProgrammeList.clear();
                MessageUI.displayRemoveSuccessMessage();
                return removedCourse;
            }
        }

        sortedCourseProgrammeList.clear();
        return new CourseProgramme();
    }

    private void searchCoursesOfferedInSemester() {
        courseUI.searchCourseSemTitle();
        String semesterCode = courseUI.inputSemester();

        if (semesterCode.equals("-999")) {
            MessageUI.backToMenu();
            return;
        }

        courseUI.searchsem(semesterCode);
        courseUI.format1();

        for (int i = 1; i <= semesterList.getNumberOfEntries(); ++i) {
            Semester semester = semesterList.getEntry(i);

            if (semester.getSemesterCode().equalsIgnoreCase(semesterCode)) {
                String courseCode = semester.getCourseCode();
                String courseTitle = semester.getCourseTitle();
                String courseType = semester.getCourseType();
                int creditHour = semester.getCreditHour();
                double courseFee = semester.getCourseFee();

                courseUI.format2(courseCode, courseTitle, courseType, creditHour, courseFee);
            }
        }
    }

    private void amendCourseDetails() {
        boolean courseFound = false;
        String code;
        do {
            courseUI.listAllCourses(getSortedAllCourses());
            code = courseUI.courseToAmend();
            String input = courseUI.confirmStringInput(code);
            if (input.equalsIgnoreCase("Y")) {
                break;
            }
        } while (true);

        if (code.equals("-999")) {
            MessageUI.backToMenu();
            return;
        }

        for (int i = 1; i <= courseList.getNumberOfEntries(); i++) {
            if (getCourseCode(i).equalsIgnoreCase(code)) {
                int amendOption;
                do {
                    courseUI.amendCourseDetailsOutput(getCourseTitle(i), code);
                    amendOption = courseUI.chooseAmendOption();
                    switch (amendOption) {
                        case 1:
                            courseList.getEntry(i).setCourseTitle(courseUI.inputCourseTitle().toUpperCase());
                            updateCourseDetailsInLists(code, courseList.getEntry(i));
                            break;
                        case 2:
                            courseList.getEntry(i).setCourseType(courseUI.inputCourseType().toUpperCase());
                            updateCourseDetailsInLists(code, courseList.getEntry(i));
                            break;
                        case 3:
                            courseList.getEntry(i).setCreditHour(courseUI.inputCourseCreditHour());
                            updateCourseDetailsInLists(code, courseList.getEntry(i));
                            break;
                        case 4:
                            courseList.getEntry(i).setCourseFee(courseUI.inputCourseFee());
                            updateCourseDetailsInLists(code, courseList.getEntry(i));
                            break;
                        case 5:
                            System.out.println("Amendment done.");
                            break; 
                        default:
                            MessageUI.displayInvalidChoiceMessage();
                    }
                } while (amendOption != 5);

                courseFound = true;
                MessageUI.displayAmendSuccessMessage();

                break;
            }
        }

        if (!courseFound) {
            MessageUI.displayCourseNotFound();
        }
    }

    private void updateCourseDetailsInLists(String code, Course newCourse) {
        for (int j = 1; j <= semesterList.getNumberOfEntries(); j++) {
            if (getSemCourseCode(j).equalsIgnoreCase(code)) {
                Semester semester = semesterList.getEntry(j);
                semester.setCourseTitle(newCourse.getCourseTitle());
                semester.setCourseType(newCourse.getCourseType());
                semester.setCreditHour(newCourse.getCreditHour());
                semester.setCourseFee(newCourse.getCourseFee());
                semesterList.replace(j, semester);
            }
        }

        for (int k = 1; k <= facultyList.getNumberOfEntries(); k++) {
            if (getFacCourseCode(k).equalsIgnoreCase(code)) {
                Faculty faculty = facultyList.getEntry(k);
                faculty.setCourseTitle(newCourse.getCourseTitle());
                faculty.setCourseType(newCourse.getCourseType());
                faculty.setCreditHour(newCourse.getCreditHour());
                faculty.setCourseFee(newCourse.getCourseFee());
                facultyList.replace(k, faculty);
            }
        }

        for (int l = 1; l <= courseProgrammeList.getNumberOfEntries(); l++) {
            if (getCCourseCode(l).equalsIgnoreCase(code)) {
                CourseProgramme courseProgramme = courseProgrammeList.getEntry(l);
                courseProgramme.setCourseTitle(newCourse.getCourseTitle());
                courseProgramme.setCourseType(newCourse.getCourseType());
                courseProgramme.setCreditHour(newCourse.getCreditHour());
                courseProgramme.setCourseFee(newCourse.getCourseFee());
                courseProgrammeList.replace(l, courseProgramme);
            }
        }
    }

    private void listCoursesByFaculties() {
        String facultyCode;
        courseUI.availableFaculty();

        int facultyChoice = courseUI.chooseFaculty();

        if (facultyChoice == -999) {
            MessageUI.backToMenu();
            return;
        }

        switch (facultyChoice) {
            case 1:
                facultyCode = "FOCS";
                break;
            case 2:
                facultyCode = "FAFB";
                break;
            default:
                MessageUI.displayFacultyErrorMessage();
                return;
        }

        courseUI.displayFacultyHeader1(facultyCode);
        for (int i = 1; i <= facultyList.getNumberOfEntries(); i++) {
            Faculty faculty = facultyList.getEntry(i);
            if (faculty.getFacultyCode().equals(facultyCode)) {
                courseUI.listFacultyCourses(faculty.getCourseCode(), faculty.getCourseTitle(),
                        faculty.getCourseType(), faculty.getCreditHour(),
                        faculty.getCourseFee());
            }
        }
    }

    private void listAllCoursesForProgramme() {
        courseUI.listCourseProgrammeTitle();
        String programmeCode = courseUI.inputProgrammeCode().toUpperCase();

        if (programmeCode.equals("-999")) {
            MessageUI.backToMenu();
            return;
        }

        boolean found = false;
        courseUI.printCourseHeader(programmeCode);

        for (int i = 1; i <= courseProgrammeList.getNumberOfEntries(); i++) {
            CourseProgramme courseProgramme = courseProgrammeList.getEntry(i);
            if (courseProgramme.getProgrammeCode().equalsIgnoreCase(programmeCode)) {
                courseUI.listProgrammeCourses(programmeCode,
                        courseProgramme.getCourseCode(),
                        courseProgramme.getCourseTitle(),
                        courseProgramme.getCourseType(),
                        courseProgramme.getCreditHour(),
                        courseProgramme.getCourseFee());
                found = true;
            }
        }

        if (!found) {
            MessageUI.displayCourseNotFound();
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

    public String getProgrammeName(int i) {
        if (i >= 0 && i <= programmeList.getNumberOfEntries()) {
            Programme programme = programmeList.getEntry(i);
            return programme.getProgrammeName();
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

    private String getProgrammeNameFromCode(String programmeCode) {
        for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
            Programme programme = programmeList.getEntry(i);
            if (programme.getProgrammeCode().equalsIgnoreCase(programmeCode)) {
                return programme.getProgrammeName();
            }
        }
        return null;
    }

    private String getFacultyNameFromCode(String facCode) {
        for (int i = 1; i <= facultyList.getNumberOfEntries(); i++) {
            Faculty faculty = facultyList.getEntry(i);
            if (faculty.getFacultyCode().equalsIgnoreCase(facCode)) {
                return faculty.getFacultyName();
            }
        }
        return null;
    }

    public String getProgCourseCode(int i) {
        if (i >= 0 && i < programmeCourseList.getNumberOfEntries()) {
            ProgrammeCourse progC = (ProgrammeCourse) programmeCourseList.getEntry(i);
            return progC.getCourseCode();
        } else {
            return null;
        }
    }

    public String getProgProgrammeCode(int i) {
        if (i >= 0 && i <= programmeCourseList.getNumberOfEntries()) {
            ProgrammeCourse progC = (ProgrammeCourse) programmeCourseList.getEntry(i);
            return progC.getProgrammeCode();
        } else {
            return null;
        }
    }

    public String getCCourseCode(int i) {
        if (i >= 0 && i <= courseProgrammeList.getNumberOfEntries()) {
            CourseProgramme Cprog = (CourseProgramme) courseProgrammeList.getEntry(i);
            return Cprog.getCourseCode();
        } else {
            return null;
        }
    }

    public String getCProgrammeCode(int i) {
        if (i >= 0 && i <= courseProgrammeList.getNumberOfEntries()) {
            CourseProgramme Cprog = (CourseProgramme) courseProgrammeList.getEntry(i);
            return Cprog.getProgrammeCode();
        } else {
            return null;
        }
    }

    public String getSemCourseCode(int i) {
        if (i >= 0 && i <= semesterList.getNumberOfEntries()) {
            Semester sem = (Semester) semesterList.getEntry(i);
            return sem.getCourseCode();
        } else {
            return null;
        }
    }

    public String getSemSemesterCode(int i) {
        if (i >= 0 && i <= semesterList.getNumberOfEntries()) {
            Semester sem = (Semester) semesterList.getEntry(i);
            return sem.getSemesterCode();
        } else {
            return null;
        }
    }

    public String getSemCourseTitle(int i) {
        if (i >= 0 && i <= semesterList.getNumberOfEntries()) {
            Semester sem = (Semester) semesterList.getEntry(i);
            return sem.getCourseTitle();
        } else {
            return null;
        }
    }

    public int getSemCourseCreditHour(int i) {
        if (i >= 0 && i <= semesterList.getNumberOfEntries()) {
            Semester sem = (Semester) semesterList.getEntry(i);
            return sem.getCreditHour();
        } else {
            return 0;
        }
    }

    public double getSemCourseFee(int i) {
        if (i >= 0 && i <= semesterList.getNumberOfEntries()) {
            Semester sem = (Semester) semesterList.getEntry(i);
            return sem.getCourseFee();
        } else {
            return 0.0;
        }
    }

    public String getSemCourseType(int i) {
        if (i >= 0 && i <= semesterList.getNumberOfEntries()) {
            Semester sem = (Semester) semesterList.getEntry(i);
            return sem.getCourseType();
        } else {
            return null;
        }
    }

    public String getFacultyCode(int i) {
        if (i >= 0 && i <= facultyList.getNumberOfEntries()) {
            Faculty faculty = (Faculty) facultyList.getEntry(i);
            return faculty.getFacultyCode();
        } else {
            return null;
        }
    }

    public String getFacCourseCode(int i) {
        if (i >= 0 && i <= facultyList.getNumberOfEntries()) {
            Faculty faculty = (Faculty) facultyList.getEntry(i);
            return faculty.getCourseCode();
        } else {
            return null;
        }
    }

    public double getFacultyFee(int i) {
        if (i >= 0 && i <= facultyList.getNumberOfEntries()) {
            Faculty faculty = (Faculty) facultyList.getEntry(i);
            return faculty.getCourseFee();
        } else {
            return 0;
        }
    }

    public void ttlFacultyFees() {
        String selectedFaculty = courseUI.inputFaculty().toUpperCase();

        int totalCourses = 0;
        double totalFees = 0.0;

        courseUI.summaryReport1Title();
        courseUI.displayFacultyHeader1(selectedFaculty);
        for (int i = 1; i <= facultyList.getNumberOfEntries(); i++) {
            Faculty faculty = facultyList.getEntry(i);
            if (faculty.getFacultyCode().equalsIgnoreCase(selectedFaculty)) {
                totalCourses++;
                totalFees += faculty.getCourseFee();
                courseUI.displayCourseDetails(faculty.getCourseCode(), faculty.getCourseTitle(), faculty.getCourseType(), faculty.getCreditHour(), faculty.getCourseFee());
            }
        }
        courseUI.newLine();
        courseUI.displayFinalSentence(selectedFaculty, totalCourses, totalFees);
        courseUI.newLine();
        courseUI.newLine();
        courseUI.summaryReportTitle1End();
    }

    private void generateCourseTypeDistributionReport() {
        String facultyCode = courseUI.inputFaculty().toUpperCase();
        String courseTypeChoice = courseUI.inputCourseType().toUpperCase();

        int totalCourses = 0;
        int chosenCourseTypeCount = 0;

        courseUI.summaryReport2Title();
        courseUI.displayCourseTypeHeader(courseTypeChoice, facultyCode);

        for (int i = 1; i <= facultyList.getNumberOfEntries(); i++) {
            Faculty faculty = facultyList.getEntry(i);
            if (faculty.getFacultyCode().equalsIgnoreCase(facultyCode)) {
                if (faculty.getCourseType().equalsIgnoreCase(courseTypeChoice)) {
                    chosenCourseTypeCount++;
                }
                totalCourses++;
                courseUI.displayCourseDetails(faculty.getCourseCode(), faculty.getCourseTitle(), faculty.getCourseType(), faculty.getCreditHour(), faculty.getCourseFee());
            }
        }

        courseUI.newLine();
        System.out.println("The Distribution of Course Type '" + courseTypeChoice.toUpperCase() + "' in " + facultyCode.toUpperCase() + " is " + chosenCourseTypeCount + ", Percentage = " + calculatePercentage(chosenCourseTypeCount, totalCourses) + "%");
        courseUI.newLine();
        courseUI.newLine();
        courseUI.summaryReportTitle1End();
    }

    private double calculatePercentage(int count, int total) {
        return (double) count / total * 100;
    }

    private void generateSummaryReports() {
        int ch;
        courseUI.getSumReport();
        ch = courseUI.selectSumReport();
        switch (ch) {
            case 1:
                ttlFacultyFees();
                break;
            case 2:
                generateCourseTypeDistributionReport();
                break;
        }
    }
}