package laba2Package;

public class Student {
    private String FIO;
    private int course;
    private String group;
    private int numberOfTasks;
    private int numberOfCompletedTasks;
    private String programmingLanguage;

    public Student() {
    }

    public Student(String FIO, int course, String group, int numberOfTasks, int numberOfCompletedTasks, String programmingLanguage) {
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
        return this.FIO + ", " + this.programmingLanguage + ", "
                + this.course + ", " + this.group + ", "
                + this.numberOfTasks + ", " + this.numberOfCompletedTasks;
    }
}
