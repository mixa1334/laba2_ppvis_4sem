package laba2Package.Models;

import java.util.ArrayList;

public class PairOfLoadedAndIncorrectlyStudents {
    private final ArrayList<Student> listOfLoadedStudents;
    private final int incorrectlyEnteredStudents;

    public PairOfLoadedAndIncorrectlyStudents(ArrayList<Student> listOfLoadedStudents, int incorrectlyEnteredStudents) {
        this.listOfLoadedStudents = listOfLoadedStudents;
        this.incorrectlyEnteredStudents = incorrectlyEnteredStudents;
    }

    public ArrayList<Student> getListOfLoadedStudents() {
        return listOfLoadedStudents;
    }

    public int getIncorrectlyEnteredStudents() {
        return incorrectlyEnteredStudents;
    }

}
