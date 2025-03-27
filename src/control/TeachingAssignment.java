package control;

import adt.DoublyLinkedList;
import adt.ListInterface;
import boundary.TeachingAssignmentUI;
import dao.TutorInitializer;
import dao.ProgrammeInitializer;
import dao.TutorialGroupInitializer;
import entity.Course;
import entity.Programme;
import entity.StudentTutorial;
import entity.Tutor;
import entity.TutorialGroup;
import entity.TutorCourse;
import entity.TutorTutorialGroupCourse;
import entity.TutorialGroupTutor;
import static java.lang.String.format;
import utility.MessageUI;

/**
 *
 * @author Tang Yi Jun
 */
public class TeachingAssignment {

    private static TeachingAssignment instance = null;

    private ListInterface<Course> courseList;
    private ListInterface<Tutor> tutorList;
    private ListInterface<TutorialGroup> tutorialGroupList;
    private ListInterface<Programme> programmeList;
    private ListInterface<TutorCourse> tutorCourseList;
    private ListInterface<TutorialGroupTutor> tutorialGroupTutorList;
    private ListInterface<TutorTutorialGroupCourse> tutorTutorialGroupCourseList;
    private ListInterface<Course> sortedCourseList;
    private ListInterface<Tutor> sortedTutorList;
    private ListInterface<TutorialGroup> sortedTutorialGroupList;
    private ListInterface<Programme> sortedProgrammeList;
    private ListInterface<TutorCourse> sortedTutorCourseList;
    private ListInterface<TutorialGroupTutor> sortedTutorialGroupTutorList;
    private ListInterface<TutorTutorialGroupCourse> sortedTutorTutorialGroupCourseList;
    private ListInterface<StudentTutorial> studentTutorialList;
    private TeachingAssignmentUI teachingUI;

    private TeachingAssignment() {
        courseList = CourseManagement.getInstance().getCourseList();
        tutorList = new DoublyLinkedList<>();
        tutorialGroupList = TutorialGroupManagement.getInstance().getTutorialGroupList();
        programmeList = new DoublyLinkedList<>();
        tutorCourseList = new DoublyLinkedList<>();
        tutorialGroupTutorList = new DoublyLinkedList<>();
        tutorTutorialGroupCourseList = new DoublyLinkedList<>();
        sortedCourseList = new DoublyLinkedList<>();
        sortedTutorList = new DoublyLinkedList<>();
        sortedTutorialGroupList = new DoublyLinkedList<>();
        sortedProgrammeList = new DoublyLinkedList<>();
        sortedTutorCourseList = new DoublyLinkedList<>();
        sortedTutorialGroupTutorList = new DoublyLinkedList<>();
        sortedTutorTutorialGroupCourseList = new DoublyLinkedList<>();
        studentTutorialList = TutorialGroupManagement.getInstance().getStudentTutorialList();
        teachingUI = new TeachingAssignmentUI();

        TutorInitializer ti = new TutorInitializer();
        TutorialGroupInitializer tgi = new TutorialGroupInitializer();
        ProgrammeInitializer pi = new ProgrammeInitializer();
        tutorList = ti.initializeTutors();
        tutorialGroupList = tgi.initializeTutorialGroup();
        programmeList = pi.initializeProgramme();
    }

    public static TeachingAssignment getInstance() {
        if (instance == null) {
            instance = new TeachingAssignment();
        }
        return instance;
    }

    public void runTeachingAssignment() {
        int choice = 0;
        do {
            choice = teachingUI.getMenuChoice();
            switch (choice) {
                case -999:
                    MessageUI.displayExitMessage();
                    break;
                case 1:
                    TutorCourse tutor = assignTutorToCourses();
                    tutorCourseList.add(tutor);
                    break;
                case 2:
                    TutorialGroupTutor tutorialGroupTutor = assignTutorialGroupsToTutor();
                    tutorialGroupTutorList.add(tutorialGroupTutor);
                    break;
                case 3:

                    TutorTutorialGroupCourse tutorTutorialGroupCourse = addTutorsToATutorialGroupForACourse();
                    tutorTutorialGroupCourseList.add(tutorTutorialGroupCourse);
                    break;
                case 4:
                    searchTutorsForACourse();
                    break;
                case 5:
                    searchCoursesUnderATutor();
                    break;
                case 6:
                    listTutorsAndTutorialGroupsForACourse();
                    break;
                case 7:
                    listCoursesForEachTutor();
                    break;
                case 8:
                    filterTutorForCriteria();
                    break;
                case 9:
                    generateSummaryReport();
                    break;
                default:
                    MessageUI.displayInvalidChoiceMessage();
            }
        } while (choice != -999);
    }

    private TutorCourse assignTutorToCourses() {
        String cCourseCode = "";
        int cTutorId = -1;
        int tutorId = -1;
        String tutorName = "xx";
        String gender = "XX";
        String courseCode = "xx";
        String courseTitle = "xx";
        String courseType = "xx";
        int creditHour = -1;
        double courseFee = -1;
        String session = "";

        teachingUI.listAllTutors(getSortedAllTutors());

        do {
            cTutorId = teachingUI.inputTutorID();
            String input = teachingUI.confirmIntInput(cTutorId);
            if (input.toUpperCase().equals("Y")) {
                break; // Break the loop if name is confirmed
            }
        } while (true);
        if (cTutorId == -999) {
            MessageUI.backToMenu();
        } else {

            teachingUI.listAllCourses(getSortedAllCourses());

            do {
                cCourseCode = teachingUI.inputCourseCode();
                String input = teachingUI.confirmStringInput(cCourseCode.toUpperCase());
                if (input.toUpperCase().equals("Y")) {
                    break; // Break the loop if name is confirmed
                }
            } while (true);

            for (int i = 1; i <= tutorList.getNumberOfEntries(); i++) {
                if (String.valueOf(cTutorId).equals(String.valueOf(getTutorID(i)))) {
                    tutorId = getTutorID(i);
                    tutorName = getTutorName(i);
                    gender = getGender(i);
                }
            }

            for (int i = 1; i <= courseList.getNumberOfEntries(); i++) {
                if (cCourseCode.toLowerCase().equals(getCourseCode(i).toLowerCase())) {
                    courseCode = getCourseCode(i);
                    courseTitle = getCourseTitle(i);
                    courseType = getCourseType(i);
                    creditHour = getCreditHour(i);
                    courseFee = getCourseFee(i);
                }
            }
        }
        MessageUI.displaySuccessMessage();
        return new TutorCourse(tutorId, tutorName, gender, courseCode, courseTitle, courseType, creditHour, courseFee, session);

    }

    private TutorialGroupTutor assignTutorialGroupsToTutor() {
        String tTutorialGroup = "";
        String tutorialGroup = "";
        int capacity = -1;

        String pProgrammeCode;
        String programmeCode = "XXX";

        int tTutorId = -1;
        int tutorId = -1;
        String tutorName = "XXX";
        String gender = "XXX";
        int count = 0;
        int count2 = 0;

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
            tTutorialGroup = teachingUI.inputTutorialGroup();
            String input = teachingUI.confirmStringInput(tTutorialGroup);
            if (input.toUpperCase().equals("Y")) {
                break; // Break the loop if name is confirmed
            }
        } while (true);
        if ("-999".equals(tTutorialGroup)) {
            MessageUI.backToMenu();
        } else {

            teachingUI.listAllProgramme(getSortedAllProgramme());

            do {
                pProgrammeCode = teachingUI.inputProgrammeCode();
                String input = teachingUI.confirmStringInput(pProgrammeCode.toUpperCase());
                if (input.toUpperCase().equals("Y")) {
                    break;
                }
            } while (true);

            for (int i = 1; i < programmeList.getNumberOfEntries(); i++) {
                if (getProgrammeCode(i).toLowerCase().equals(pProgrammeCode.toLowerCase())) {
                    programmeCode = getProgrammeCode(i);
                }
            }

            teachingUI.listAllTutors(getSortedAllTutors());

            do {
                tTutorId = teachingUI.inputTutorID();
                String input = teachingUI.confirmIntInput(tTutorId);
                if (input.toUpperCase().equals("Y")) {
                    break; // Break the loop if name is confirmed
                }
            } while (true);

            for (int i = 1; i <= tutorialGroupList.getNumberOfEntries(); i++) {
                if (tTutorialGroup.toLowerCase().equals(getTutorialGroup(i))) {
                    tutorialGroup = getTutorialGroup(i);
                    capacity = getCapacity(i);
                }
            }

            for (int i = 1; i <= tutorList.getNumberOfEntries(); i++) {
                if (String.valueOf(tTutorId).equals(String.valueOf(getTutorID(i)))) {
                    tutorId = getTutorID(i);
                    tutorName = getTutorName(i);
                    gender = getGender(i);
                }
            }
        }
        MessageUI.displaySuccessMessage2();
        return new TutorialGroupTutor(tutorialGroup, capacity, programmeCode, tutorId, tutorName, gender);
    }

    private TutorTutorialGroupCourse addTutorsToATutorialGroupForACourse() {
        int MAX_ASSIGNMENTS = 1;
        String[] tutorialGroups = new String[MAX_ASSIGNMENTS];
        String[] courseCodes = new String[MAX_ASSIGNMENTS];
        String[] sessions = new String[MAX_ASSIGNMENTS];
        int currentAssignmentCount = 0;

        String cCourseCode = "";
        int cTutorId = -1;
        String cTutorialGroup = "";

        int tutorId = -1;
        String tutorName = "xx";
        String gender = "X";

        String courseCode = "xx";
        String courseTitle = "xx";
        String courseType = "xx";
        int creditHour = -1;
        double courseFee = -1;
        String session = "xx";

        String tutorialGroup = "";
        int capacity = -1;

        String pProgrammeCode;
        String programmeCode = "XXX";

        int count = 0;
        int count2 = 0;
        //String programmeName = "XXXX";

        // Your existing code for input and confirmation...
        teachingUI.listAllCourses(getSortedAllCourses());

        do {
            cCourseCode = teachingUI.inputCourseCode();
            String input = teachingUI.confirmStringInput(cCourseCode.toUpperCase());

            if (input.toUpperCase().equals("Y")) {
                break; // Break the loop if name is confirmed
            }
        } while (true);
        if (String.valueOf(cCourseCode).equals(String.valueOf(-999))) {
            MessageUI.backToMenu();
        } else {

            do {
                session = teachingUI.inputSession();

                if (!session.equals("P") && !session.equals("T") && !session.equals("L")) {
                    MessageUI.displaySessionMsg();
                    session = teachingUI.inputSession();
                }
                String input = teachingUI.confirmStringInput(session.toUpperCase());
                if (input.toUpperCase().equals("Y")) {
                    break; // Break the loop if name is confirmed

                }
            } while (true);

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
                cTutorialGroup = teachingUI.inputTutorialGroup().toUpperCase();
                String input = teachingUI.confirmStringInput(cTutorialGroup);
                if (input.toUpperCase().equals("Y")) {
                    break; // Break the loop if name is confirmed
                }
            } while (true);

            teachingUI.listAllProgramme(getSortedAllProgramme());

            do {
                pProgrammeCode = teachingUI.inputProgrammeCode().toUpperCase();
                String input = teachingUI.confirmStringInput(pProgrammeCode.toUpperCase());
                if (input.toUpperCase().equals("Y")) {
                    break;
                }
            } while (true);
            for (int i = 1; i < programmeList.getNumberOfEntries(); i++) {
                if (getProgrammeCode(i).toLowerCase().equals(pProgrammeCode.toLowerCase())) {
                    programmeCode = getProgrammeCode(i);
                }
            }

            teachingUI.listAllTutors(getSortedAllTutors());

            do {
                cTutorId = teachingUI.inputTutorID();
                String input = teachingUI.confirmIntInput(cTutorId);
                if (input.toUpperCase().equals("Y")) {
                    break; // Break the loop if name is confirmed

                }
            } while (true);

            // Check for existing assignment
            boolean assignmentExists = false;
            for (int i = 0; i < currentAssignmentCount; i++) {
                if (tutorialGroups[i].equals(cTutorialGroup)
                        && courseCodes[i].equalsIgnoreCase(cCourseCode)
                        && sessions[i].equalsIgnoreCase(session)) {
                    assignmentExists = true;
                    break;
                }
            }

            if (assignmentExists) {
                // Display error message - Assignment already exists
                MessageUI.displayErrorMessage();
                // Handle error scenario (e.g., return null, throw exception)
                return null;
            }

            // Continue with your existing logic to fetch details...
            for (int i = 1; i <= tutorList.getNumberOfEntries(); i++) {
                if (String.valueOf(cTutorId).equals(String.valueOf(getTutorID(i)))) {
                    tutorId = getTutorID(i);
                    tutorName = getTutorName(i);
                    gender = getGender(i);
                }
            }

            for (int i = 1; i <= tutorialGroupList.getNumberOfEntries(); i++) {
                if (String.valueOf(cTutorialGroup).equals(String.valueOf(getTutorialGroup(i)))) {
                    tutorialGroup = getTutorialGroup(i);
                    capacity = getCapacity(i);
                }
            }

            for (int i = 1; i <= courseList.getNumberOfEntries(); i++) {
                if (cCourseCode.toLowerCase().equals(getCourseCode(i).toLowerCase())) {
                    courseCode = getCourseCode(i);
                    courseTitle = getCourseTitle(i);
                    courseType = getCourseType(i);
                    creditHour = getCreditHour(i);
                    courseFee = getCourseFee(i);
                }
            }
        }

        // Assuming arrays tutorialGroups, courseCodes, sessions are initialized
        tutorialGroups[currentAssignmentCount] = cTutorialGroup;
        courseCodes[currentAssignmentCount] = cCourseCode.toLowerCase();
        sessions[currentAssignmentCount] = session;
        currentAssignmentCount++; // Increment the counter for the next assignment

        // After fetching details
        MessageUI.displaySuccessMessage3();

        // Create and return the new TutorTutorialGroupCourse instance
        return new TutorTutorialGroupCourse(tutorId, tutorName, gender, tutorialGroup, capacity, programmeCode, courseCode, courseTitle, courseType, creditHour, courseFee, session);
    }

    private void searchCoursesUnderATutor() {
        // Display list of all tutors
        teachingUI.listAllTutors(getSortedAllTutors());

        // Prompt user to input tutor ID
        int tutorID;
        do {
            tutorID = teachingUI.inputTutorID();
            String input = teachingUI.confirmIntInput(tutorID);
            if (input.toUpperCase().equals("Y")) {
                break; // Break the loop if name is confirmed
            }
        } while (true);
        if ("-999".equals(tutorID)) {
            MessageUI.backToMenu();
        } else {

            // Display search result header
            System.out.println("\nSearch result of courses under Tutor ID: " + tutorID);
            teachingUI.displayHeader3();

            // Iterate through TutorCourse list
            for (int i = 1; i <= tutorCourseList.getNumberOfEntries(); i++) {
                if (tutorID == getTutorCourseTutorID(i)) {
                    // Retrieve course details from TutorCourse
                    String courseCode = getTutorCourseCourseCode(i);
                    String courseTitle = getTutorCourseCourseTitle(i);
                    String courseType = getTutorCourseCourseType(i);
                    int creditHour = getTutorCourseCreditHour(i);
                    double courseFee = getTutorCourseCourseFee(i);
                    String session = getSession(i);

                    // Retrieve tutor details from TutorCourse
                    int tutorId = getTutorCourseTutorID(i);
                    String tutorName = getTutorCourseTutorName(i);
                    String gender = getTutorCourseTutorGender(i);

                    // Display course details associated with the tutor from TutorCourse
                    System.out.println(format("%-10d %-20s %-10s %-12s %-30s %-12s %-12d %-12.2f %-12s",
                            tutorId, tutorName, gender, courseCode, courseTitle, courseType,
                            creditHour, courseFee, session));
                }
            }

            // Iterate through TutorTutorialGroupCourse list
            for (int j = 1; j <= tutorTutorialGroupCourseList.getNumberOfEntries(); j++) {
                if (tutorID == getTutorTutorialGroupCourseTutorID(j)) {
                    // Retrieve course details from TutorTutorialGroupCourse
                    String courseCode = getTutorTutorialGroupCourseCourseCode(j);
                    String courseTitle = getTutorTutorialGroupCourseCourseTitle(j);
                    String courseType = getTutorTutorialGroupCourseCourseType(j);
                    int creditHour = getTutorTutorialGroupCourseCreditHour(j);
                    double courseFee = getTutorTutorialGroupCourseCourseFee(j);
                    String session = getTutorTutorialGroupCourseSession(j);

                    // Retrieve tutor details from TutorTutorialGroupCourse
                    int tutorId = getTutorTutorialGroupCourseTutorID(j);
                    String tutorName = getTutorTutorialGroupCourseTutorName(j);
                    String gender = getTutorTutorialGroupCourseTutorGender(j);

                    // Display course details associated with the tutor from TutorTutorialGroupCourse
                    System.out.println(format("%-10d %-20s %-10s %-12s %-30s %-12s %-12d %-12.2f %-12s",
                            tutorId, tutorName, gender, courseCode, courseTitle, courseType,
                            creditHour, courseFee, session));
                }
            }
        }
    }

    private void searchTutorsForACourse() {
        // Display list of all courses
        teachingUI.listAllCourses(getSortedAllCourses());

        // Prompt user to input course code
        String courseCode;
        do {
            courseCode = teachingUI.inputCourseCode();
            String input = teachingUI.confirmStringInput(courseCode.toUpperCase());

            if (input.toUpperCase().equals("Y")) {
                break; // Break the loop if name is confirmed
            }
        } while (true);
        if (String.valueOf(courseCode).equals(String.valueOf(-999))) {
            MessageUI.backToMenu();
        } else {

            // Display search result header
            System.out.println("\nSearch result of tutors for Course Code: " + courseCode.toUpperCase());
            teachingUI.displayHeader2();

            // Iterate through TutorCourse list
            for (int i = 1; i <= tutorCourseList.getNumberOfEntries(); i++) {
                if (courseCode.equalsIgnoreCase(getTutorCourseCourseCode(i))) {
                    // Retrieve tutor details from TutorCourse
                    int tutorId = getTutorCourseTutorID(i);
                    String tutorName = getTutorCourseTutorName(i);
                    String gender = getTutorCourseTutorGender(i);
                    String session = getSession(i);

                    // Display course and tutor details
                    System.out.println(format("%-10d %-20s %-10s", tutorId, tutorName, gender, session));
                }
            }

            // Iterate through TutorTutorialGroupCourse list
            for (int j = 1; j <= tutorTutorialGroupCourseList.getNumberOfEntries(); j++) {
                if (courseCode.equalsIgnoreCase(getTutorTutorialGroupCourseCourseCode(j))) {
                    // Retrieve course details from TutorTutorialGroupCourse
                    int tutorId = getTutorTutorialGroupCourseTutorID(j);
                    String tutorName = getTutorTutorialGroupCourseTutorName(j);
                    String gender = getTutorTutorialGroupCourseTutorGender(j);
                    String session = getTutorTutorialGroupCourseSession(j);

                    // Display course and tutor details
                    System.out.println(format("%-10d %-20s %-10s %-10s", tutorId, tutorName, gender, session));
                }
            }
        }
    }

    private void listTutorsAndTutorialGroupsForACourse() {
        boolean foundTutors = true;

        teachingUI.listAllCourses(getSortedAllCourses());

        // Prompt for Course Code
        String courseCode;
        do {
            courseCode = teachingUI.inputCourseCode();
            String input = teachingUI.confirmStringInput(courseCode);

            if (input.toUpperCase().equals("Y")) {
                break; // Break the loop if name is confirmed
            }
        } while (true);
        if (String.valueOf(courseCode).equals(String.valueOf(-999))) {
            MessageUI.backToMenu();
        } else {

            // Display header for the output
            System.out.println("\nTutors and Assigned Tutorial Groups for Course: " + courseCode.toUpperCase());
            teachingUI.displayHeader4();

            // Iterate through tutorCourseList to find matching entries
            for (int i = 1; i <= tutorCourseList.getNumberOfEntries(); i++) {
                if (courseCode.equalsIgnoreCase(getTutorCourseCourseCode(i))) {
                    int tutorId = getTutorCourseTutorID(i);
                    String tutorName = getTutorCourseTutorName(i);
                    String gender = getTutorCourseTutorGender(i);
                    String tutorialGroup = "Not Assigned"; // Default message if no tutorial group assigned
                    String capacity = "Not Assigned";
                    String programmeCode = "Not Assigned";

                    // Find assigned tutorial group for this tutor
                    for (int j = 1; j <= tutorialGroupTutorList.getNumberOfEntries(); j++) {
                        if (tutorialGroupTutorList.getEntry(j).getId() == tutorId) {
                            tutorialGroup = String.valueOf(tutorialGroupTutorList.getEntry(j).getTutorialGroup());
                            capacity = String.valueOf(tutorialGroupTutorList.getEntry(j).getCapacity());
                            programmeCode = String.valueOf(tutorialGroupTutorList.getEntry(j).getProgrammeCode());
                            break; // Break after finding the assigned tutorial group
                        }
                    }

                    // Display tutor ID, name, and assigned tutorial group
                    System.out.println(format("%-10d %-20s %-10s %-15s %-10s %-20s", tutorId, tutorName, gender, tutorialGroup, capacity, programmeCode));
                }
            }

            // Iterate through TutorTutorialGroupCourse list
            for (int j = 1; j <= tutorTutorialGroupCourseList.getNumberOfEntries(); j++) {
                // Retrieve course details from TutorTutorialGroupCourse
                int tutorId = getTutorTutorialGroupCourseTutorID(j);
                String tutorName = getTutorTutorialGroupCourseTutorName(j);
                String gender = getTutorTutorialGroupCourseTutorGender(j);
                String tutorialGroup = String.valueOf(tutorTutorialGroupCourseList.getEntry(j).getTutorialGroup());
                String capacity = String.valueOf(tutorTutorialGroupCourseList.getEntry(j).getCapacity());
                String programmeCode = String.valueOf(tutorTutorialGroupCourseList.getEntry(j).getProgrammeCode());

                // Display course and tutor details
                System.out.println(format("%-10d %-20s %-10s %-15s %-10s %-20s", tutorId, tutorName, gender, tutorialGroup, capacity, programmeCode));
            }

            // Display message if no tutors found for the specified course
            if (!foundTutors) {
                System.out.println("\nNo tutors assigned to the course with code: " + courseCode);
            }
        }
    }

    private void listCoursesForEachTutor() {
        teachingUI.displayHeader5();

        // Iterate through tutorCourseList
        for (int i = 1; i <= tutorCourseList.getNumberOfEntries(); i++) {
            int tutorId = getTutorCourseTutorID(i);
            String tutorName = getTutorCourseTutorName(i);
            String gender = getTutorCourseTutorGender(i);
            String courseCode = getTutorCourseCourseCode(i);
            String courseTitle = getTutorCourseCourseTitle(i);

            // Display tutor information and assigned course details
            System.out.println(format("%-10s %-20s %-10s %-12s %-30s", tutorId, tutorName, gender, courseCode, courseTitle));
        }

        // Iterate through tutorTutorialGroupCourseList
        for (int j = 1; j <= tutorTutorialGroupCourseList.getNumberOfEntries(); j++) {
            String courseCode = getTutorTutorialGroupCourseCourseCode(j);
            String courseTitle = getTutorTutorialGroupCourseCourseTitle(j);
            int tutorId = getTutorTutorialGroupCourseTutorID(j);
            String tutorName = getTutorTutorialGroupCourseTutorName(j);
            String gender = getTutorTutorialGroupCourseTutorGender(j);

            // Display tutor information and assigned course details
            System.out.println(format("%-10d %-20s %-10s %-12s %-30s", tutorId, tutorName, gender, courseCode, courseTitle));
        }
    }

    private void filterTutorForCriteria() {
        int filterOption = teachingUI.selectFilterOption();

        switch (filterOption) {
            case 1:
                // Filter by Gender
                String gender = teachingUI.inputGender();
                displayFilteredTutorsByGender(gender);
                break;
            case 2:
                int count = 0;
                int count2 = 0;
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
                // Filter by Assigned Tutorial Group
                String tutorialGroup = teachingUI.inputTutorialGroup();
                displayFilteredTutorsByTutorialGroup(tutorialGroup);
                break;
            default:
                MessageUI.displayInvalidChoiceMessage();
                break;
        }
    }

    private void displayFilteredTutorsByTutorialGroup(String tutorialGroup) {
        System.out.println("\nTutors assigned to Tutorial Group " + tutorialGroup);
        teachingUI.displayHeader();

        for (int i = 1; i <= tutorialGroupTutorList.getNumberOfEntries(); i++) {
            if (getTutorialGroupTutorTutorialGroup(i).toLowerCase().equals(tutorialGroup.toLowerCase())) {
                int tutorId = getTutorialGroupTutorTutorID(i);
                String tutorName = getTutorialGroupTutorTutorName(i);
                System.out.println(String.format("%-10d %-20s", tutorId, tutorName));
            }
        }

        // Iterate through tutor-tutorial group assignments
        for (int i = 1; i <= tutorTutorialGroupCourseList.getNumberOfEntries(); i++) {
            if (getTutorTutorialGroupCourseTutorialGroup(i).toLowerCase().equals(tutorialGroup.toLowerCase())) {
                int tutorId = getTutorTutorialGroupCourseTutorID(i);
                String tutorName = getTutorTutorialGroupCourseTutorName(i);
                System.out.println(String.format("%-10d %-20s", tutorId, tutorName));
            }
        }
    }

    private void displayFilteredTutorsByGender(String gender) {
        System.out.println("\nTutors with Gender: " + gender.toUpperCase());
        teachingUI.displayHeader();

        // Iterate through tutor assignments (assuming tutorCourseList)
        for (int i = 1; i <= tutorList.getNumberOfEntries(); i++) {
            // Assuming getTutorGender(i) retrieves gender of tutor for the course
            if (getGender(i).equalsIgnoreCase(gender)) {
                int tutorId = getTutorID(i);
                String tutorName = getTutorName(i);
                System.out.println(String.format("%-10d %-20s", tutorId, tutorName));
            }
        }
    }

    private void generateSummaryReport() {
        int ch;
        teachingUI.genSumReport();
        ch = teachingUI.selectSumReport();
        switch (ch) {
            case 1:
                summaryReport1();
                System.out.println("");
                break;

            case 2:
                summaryReport2();
                System.out.println("");
                break;
        }
    }

    private void summaryReport1() {
        teachingUI.displayReportHeader();

        int count = 0;

        // Iterate through the list of tutor course assignments
        for (int i = 1; i <= tutorCourseList.getNumberOfEntries(); i++) {
            int tutorId = getTutorCourseTutorID(i);
            String tutorName = getTutorCourseTutorName(i);
            String courseCode = getTutorCourseCourseCode(i);
            String courseTitle = getTutorCourseCourseTitle(i);

            // Check if this tutor has already been processed
            boolean isNewTutor = true;

            // Iterate over the already processed tutors to avoid duplicates
            for (int j = 1; j < i; j++) {
                int existingTutorId = getTutorCourseTutorID(j);

                // If the tutor is already processed, skip the current tutor
                if (existingTutorId == tutorId) {
                    isNewTutor = false;
                    break;
                }
            }

            // If the tutor is new, display their information
            if (isNewTutor) {
                System.out.println(String.format("%-10d %-20s %-12s %-30s", tutorId, tutorName, "", "")); // Output tutor info
                count++;
            }

            // Output the assigned course details for the current tutor
            System.out.println(String.format("%-10s %-20s %-12s %-30s", "", "", courseCode, courseTitle));
        }

        for (int i = 1; i <= tutorTutorialGroupCourseList.getNumberOfEntries(); i++) {
            int tutorId = getTutorTutorialGroupCourseTutorID(i);
            String tutorName = getTutorTutorialGroupCourseTutorName(i);
            String courseCode = getTutorTutorialGroupCourseCourseCode(i);
            String courseTitle = getTutorTutorialGroupCourseCourseTitle(i);

            // Check if this tutor has already been processed
            boolean isNewTutor = true;

            // Iterate over the already processed tutors to avoid duplicates
            for (int j = 1; j < i; j++) {
                int existingTutorId = getTutorTutorialGroupCourseTutorID(j);

                // If the tutor is already processed, skip the current tutor
                if (existingTutorId == tutorId) {
                    isNewTutor = false;
                    break;
                }
            }

            // If the tutor is new, display their information
            if (isNewTutor) {
                System.out.println(String.format("%-10d %-20s %-12s %-30s", tutorId, tutorName, "", "")); // Output tutor info
                count++;
            }

            // Output the assigned course details for the current tutor
            System.out.println(String.format("%-10s %-20s %-12s %-30s", "", "", courseCode, courseTitle));
        }

        System.out.println("");
        // Output total count of tutors with assigned courses
        System.out.println("Total assigned courses with tutor: " + count);

        teachingUI.displayReportBottom();
        teachingUI.scanNextLine();
    }

    private void summaryReport2() {
        teachingUI.displayReportHeader2();

        int count = 0;

        // Iterate through the list of tutor tutorial group course assignments
        for (int i = 1; i <= tutorTutorialGroupCourseList.getNumberOfEntries(); i++) {
            int tutorId = getTutorTutorialGroupCourseTutorID(i);
            String tutorName = getTutorTutorialGroupCourseTutorName(i);
            String tutorialGroup = getTutorTutorialGroupCourseTutorialGroup(i);
            String courseCode = getTutorTutorialGroupCourseCourseCode(i);
            String courseTitle = getTutorCourseCourseTitle(i);

            // Check if this tutor has already been counted
            boolean isNewTutor = true;

            // Iterate over the already processed tutors
            for (int j = 1; j < i; j++) {
                int existingTutorId = getTutorTutorialGroupCourseTutorID(j);

                // If the tutor is already counted, skip the current tutor
                if (existingTutorId == tutorId) {
                    isNewTutor = false;
                    break;
                }
            }
            // If the tutor is new, display their information along with course details
            if (isNewTutor) {
                System.out.println(String.format("%-10d %-20s %-20s %-15s %-30s", tutorId, tutorName, tutorialGroup, courseCode, courseTitle)); // Output tutor info with tutorial group and course details
                count++;
            }
        }

        // Output total count of tutors with assigned tutorial groups
        System.out.println("Total tutors with assigned tutorial groups for courses: " + count);

        teachingUI.displayReportBottom();
        teachingUI.scanNextLine();
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

    public String getAllTutor() {
        String str = "";
        String count;
        tutorList.mergeSort();
        for (int i = 1; i <= tutorList.getNumberOfEntries(); i++) {
            count = String.valueOf(i);
            str += count + tutorList.getEntry(i) + "\n";
        }
        return str;
    }

    public String getAllCourse() {
        String str = "";
        String count;
        courseList.mergeSort();
        for (int i = 1; i <= courseList.getNumberOfEntries(); i++) {
            count = String.valueOf(i);
            str += count + courseList.getEntry(i) + "\n";
        }
        return str;
    }

    public String getAllTutorCourse() {
        String str = "";
        String count;
        tutorCourseList.mergeSort();
        for (int i = 1; i <= tutorCourseList.getNumberOfEntries(); i++) {
            count = String.valueOf(i);
            str += count + tutorCourseList.getEntry(i) + "\n";
        }
        return str;
    }

    public String getAllTutorialGroupTutor() {
        String str = "";
        String count;
        tutorialGroupTutorList.mergeSort();
        for (int i = 1; i <= tutorialGroupTutorList.getNumberOfEntries(); i++) {
            count = String.valueOf(i);
            str += count + tutorialGroupTutorList.getEntry(i) + "\n";
        }
        return str;
    }

    public String getAllTutorTutorialGroupCourse() {
        String str = "";
        String count;
        tutorTutorialGroupCourseList.mergeSort();
        for (int i = 1; i <= tutorTutorialGroupCourseList.getNumberOfEntries(); i++) {
            count = String.valueOf(i);
            str += count + tutorTutorialGroupCourseList.getEntry(i) + "\n";
        }
        return str;
    }

    public String getSortedAllTutorialGroup() {
        String str = "";
        sortedTutorialGroupList.clear();
        for (int i = 1; i <= tutorialGroupList.getNumberOfEntries(); i++) {
            sortedTutorialGroupList.add(tutorialGroupList.getEntry(i));
        }
        sortedTutorialGroupList.mergeSort();

        for (int i = 1; i <= sortedTutorialGroupList.getNumberOfEntries(); i++) {
            str += String.valueOf(i) + sortedTutorialGroupList.getEntry(i) + "\n";
        }
        return str;
    }

    public String getSortedAllTutors() {
        String str = "";
        sortedTutorList.clear();
        for (int i = 1; i <= tutorList.getNumberOfEntries(); i++) {
            sortedTutorList.add(tutorList.getEntry(i));
        }
        sortedTutorList.mergeSort();

        for (int i = 1; i <= sortedTutorList.getNumberOfEntries(); i++) {
            str += String.valueOf(i) + sortedTutorList.getEntry(i) + "\n";
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

    public String getSortedAllTutorCourse() {
        String str = "";
        sortedTutorCourseList.clear();
        for (int i = 1; i <= tutorCourseList.getNumberOfEntries(); i++) {
            sortedTutorCourseList.add(tutorCourseList.getEntry(i));
        }
        sortedTutorCourseList.mergeSort();
        String count;
        for (int i = 1; i <= sortedTutorCourseList.getNumberOfEntries(); i++) {
            count = String.valueOf(i);
            str += count + sortedTutorCourseList.getEntry(i) + "\n";
        }
        return str;
    }

    public String getSortedAllTutorialGroupTutor() {
        String str = "";
        sortedTutorialGroupTutorList.clear();
        for (int i = 1; i <= tutorialGroupTutorList.getNumberOfEntries(); i++) {
            sortedTutorialGroupTutorList.add(tutorialGroupTutorList.getEntry(i));
        }
        sortedTutorialGroupTutorList.mergeSort();

        for (int i = 1; i <= sortedTutorialGroupTutorList.getNumberOfEntries(); i++) {
            str += String.valueOf(i) + sortedTutorialGroupTutorList.getEntry(i) + "\n";
        }
        return str;
    }

    public String getSortedAllTutorTutorialGroupCourse() {
        String str = "";
        sortedTutorTutorialGroupCourseList.clear();
        for (int i = 1; i <= tutorTutorialGroupCourseList.getNumberOfEntries(); i++) {
            sortedTutorTutorialGroupCourseList.add(tutorTutorialGroupCourseList.getEntry(i));
        }
        sortedTutorTutorialGroupCourseList.mergeSort();

        for (int i = 1; i <= sortedTutorTutorialGroupCourseList.getNumberOfEntries(); i++) {
            str += String.valueOf(i) + sortedTutorTutorialGroupCourseList.getEntry(i) + "\n";
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

    public int getTutorID(int i) {
        if (i >= 0 && i <= tutorList.getNumberOfEntries()) {
            Tutor tutor = tutorList.getEntry(i);
            return tutor.getId();
        } else {
            return 0;
        }
    }

    public int getTutorCourseTutorID(int i) {
        if (i >= 0 && i <= tutorCourseList.getNumberOfEntries()) {
            TutorCourse tc = tutorCourseList.getEntry(i);
            return tc.getId();
        } else {
            return 0;
        }
    }

    public int getTutorialGroupTutorTutorID(int i) {
        if (i >= 0 && i <= tutorialGroupTutorList.getNumberOfEntries()) {
            TutorialGroupTutor tgt = tutorialGroupTutorList.getEntry(i);
            return tgt.getId();
        } else {
            return 0;
        }
    }

    public int getTutorTutorialGroupCourseTutorID(int i) {
        if (i >= 0 && i <= tutorTutorialGroupCourseList.getNumberOfEntries()) {
            TutorTutorialGroupCourse ttgc = tutorTutorialGroupCourseList.getEntry(i);
            return ttgc.getId();
        } else {
            return 0;
        }
    }

    public String getTutorName(int i) {
        if (i >= 0 && i <= tutorList.getNumberOfEntries()) {
            Tutor tutor = tutorList.getEntry(i);
            return tutor.getName();
        } else {
            return null;
        }
    }

    public String getTutorCourseTutorName(int i) {
        if (i >= 0 && i <= tutorCourseList.getNumberOfEntries()) {
            TutorCourse tc = tutorCourseList.getEntry(i);
            return tc.getName();
        } else {
            return null;
        }
    }

    public String getTutorialGroupTutorTutorName(int i) {
        if (i >= 0 && i <= tutorialGroupTutorList.getNumberOfEntries()) {
            TutorialGroupTutor tgt = tutorialGroupTutorList.getEntry(i);
            return tgt.getName();
        } else {
            return null;
        }
    }

    public String getTutorTutorialGroupCourseTutorName(int i) {
        if (i >= 0 && i <= tutorTutorialGroupCourseList.getNumberOfEntries()) {
            TutorTutorialGroupCourse ttgc = tutorTutorialGroupCourseList.getEntry(i);
            return ttgc.getName();
        } else {
            return null;
        }
    }

    public String getGender(int i) {
        if (i >= 0 && i <= tutorList.getNumberOfEntries()) {
            Tutor tutor = tutorList.getEntry(i);
            return tutor.getGender();
        } else {
            return null;
        }
    }

    public String getTutorCourseTutorGender(int i) {
        if (i >= 0 && i <= tutorCourseList.getNumberOfEntries()) {
            TutorCourse tc = tutorCourseList.getEntry(i);
            return tc.getGender();
        } else {
            return null;
        }
    }

    public String getTutorTutorialGroupCourseTutorGender(int i) {
        if (i >= 0 && i <= tutorTutorialGroupCourseList.getNumberOfEntries()) {
            TutorTutorialGroupCourse ttgc = tutorTutorialGroupCourseList.getEntry(i);
            return ttgc.getGender();
        } else {
            return null;
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

    public String getTutorCourseCourseTitle(int i) {
        if (i >= 0 && i <= tutorCourseList.getNumberOfEntries()) {
            TutorCourse tc = tutorCourseList.getEntry(i);
            return tc.getCourseTitle();
        } else {
            return null;
        }
    }

    public String getTutorTutorialGroupCourseCourseTitle(int i) {
        if (i >= 0 && i <= tutorTutorialGroupCourseList.getNumberOfEntries()) {
            TutorTutorialGroupCourse ttgc = tutorTutorialGroupCourseList.getEntry(i);
            return ttgc.getCourseTitle();
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

    public String getTutorCourseCourseCode(int i) {
        if (i >= 0 && i <= tutorCourseList.getNumberOfEntries()) {
            TutorCourse tc = tutorCourseList.getEntry(i);
            return tc.getCourseCode();
        } else {
            return null;
        }
    }

    public String getTutorTutorialGroupCourseCourseCode(int i) {
        if (i >= 0 && i <= tutorTutorialGroupCourseList.getNumberOfEntries()) {
            TutorTutorialGroupCourse ttgc = tutorTutorialGroupCourseList.getEntry(i);
            return ttgc.getCourseCode();
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

    public String getTutorCourseCourseType(int i) {
        if (i >= 0 && i <= tutorCourseList.getNumberOfEntries()) {
            TutorCourse tc = tutorCourseList.getEntry(i);
            return tc.getCourseType();
        } else {
            return null;
        }
    }

    public String getTutorTutorialGroupCourseCourseType(int i) {
        if (i >= 0 && i <= tutorTutorialGroupCourseList.getNumberOfEntries()) {
            TutorTutorialGroupCourse ttgc = tutorTutorialGroupCourseList.getEntry(i);
            return ttgc.getCourseType();
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

    public int getTutorCourseCreditHour(int i) {
        if (i >= 0 && i <= tutorCourseList.getNumberOfEntries()) {
            TutorCourse tc = tutorCourseList.getEntry(i);
            return tc.getCourseCreditHour();
        } else {
            return 0;
        }
    }

    public int getTutorTutorialGroupCourseCreditHour(int i) {
        if (i >= 0 && i <= tutorTutorialGroupCourseList.getNumberOfEntries()) {
            TutorTutorialGroupCourse ttgc = tutorTutorialGroupCourseList.getEntry(i);
            return ttgc.getCourseCreditHour();
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

    public double getTutorCourseCourseFee(int i) {
        if (i >= 0 && i <= tutorCourseList.getNumberOfEntries()) {
            TutorCourse tc = tutorCourseList.getEntry(i);
            return tc.getCourseFee();
        } else {
            return 0;
        }
    }

    public double getTutorTutorialGroupCourseCourseFee(int i) {
        if (i >= 0 && i <= tutorTutorialGroupCourseList.getNumberOfEntries()) {
            TutorTutorialGroupCourse ttgc = tutorTutorialGroupCourseList.getEntry(i);
            return ttgc.getCourseFee();
        } else {
            return 0;
        }
    }

    public String getSession(int i) {
        if (i >= 0 && i <= tutorCourseList.getNumberOfEntries()) {
            TutorCourse tc = tutorCourseList.getEntry(i);
            return tc.getSession();
        } else {
            return null;
        }
    }

    public String getTutorTutorialGroupCourseSession(int i) {
        if (i >= 0 && i <= tutorTutorialGroupCourseList.getNumberOfEntries()) {
            TutorTutorialGroupCourse ttgc = tutorTutorialGroupCourseList.getEntry(i);
            return ttgc.getSession();
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

    public String getTutorialGroupTutorTutorialGroup(int i) {
        if (i >= 0 && i <= tutorialGroupTutorList.getNumberOfEntries()) {
            TutorialGroupTutor tgt = tutorialGroupTutorList.getEntry(i);
            return tgt.getTutorialGroup();
        } else {
            return null;
        }
    }

    public String getTutorTutorialGroupCourseTutorialGroup(int i) {
        if (i >= 0 && i <= tutorTutorialGroupCourseList.getNumberOfEntries()) {
            TutorTutorialGroupCourse ttgc = tutorTutorialGroupCourseList.getEntry(i);
            return ttgc.getTutorialGroup();
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

    public int getTutorTutorialGroupCourseCapacity(int i) {
        if (i >= 0 && i <= tutorTutorialGroupCourseList.getNumberOfEntries()) {
            TutorTutorialGroupCourse ttgc = tutorTutorialGroupCourseList.getEntry(i);
            return ttgc.getCapacity();
        } else {
            return 0;
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

    public String getProgrammeName(int i) {
        if (i >= 0 && i <= programmeList.getNumberOfEntries()) {
            Programme programme = programmeList.getEntry(i);
            return programme.getProgrammeName();
        } else {
            return null;
        }
    }

    public int getTotalTutorsAssigned(int[] courseTutorCounts) {
        int total = 0;
        for (int count : courseTutorCounts) {
            total += count;
        }
        return total;
    }
}
