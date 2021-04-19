package laba2Package.Models;

import laba2Package.Exceptions.StudentException;

public class Student {
    private String FIO;
    private int course;
    private String group;
    private int numberOfTasks;
    private int numberOfCompletedTasks;
    private String programmingLanguage;

    public Student() {
    }

    public Student(String FIO, int course, String group, int numberOfTasks, int numberOfCompletedTasks, String programmingLanguage) throws StudentException {

        if (course <= 0 || numberOfTasks <= 0 || numberOfCompletedTasks <= 0
                || FIO == null || FIO.equals("") || group == null || group.equals("")
                || programmingLanguage == null || programmingLanguage.equals(""))
            throw new StudentException("Incorrect parameters");

        this.FIO = FIO;
        this.course = course;
        this.group = group;
        this.numberOfTasks = numberOfTasks;
        this.numberOfCompletedTasks = numberOfCompletedTasks;
        this.programmingLanguage = programmingLanguage;
    }

    public String getFIO() {
        return FIO;
    }

    public int getCourse() {
        return course;
    }

    public String getGroup() {
        return group;
    }


    public int getNumberOfTasks() {
        return numberOfTasks;
    }

    public int getNumberOfCompletedTasks() {
        return numberOfCompletedTasks;
    }


    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    @Override
    public String toString() {
        return "[" + this.FIO + ", " + this.programmingLanguage + ", "
                + this.course + ", " + this.group + ", "
                + this.numberOfTasks + ", " + this.numberOfCompletedTasks + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Student guest = (Student) obj;
        return FIO.equals(guest.FIO) && course == guest.course && group.equals(guest.group)
                && numberOfTasks == guest.numberOfTasks && numberOfCompletedTasks == guest.numberOfCompletedTasks
                && programmingLanguage.equals(guest.programmingLanguage);
    }
}
