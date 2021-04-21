package laba2Package.Models;

import laba2Package.Exceptions.StudentException;

import java.util.regex.Pattern;

public class Student {
    private String fio;
    private int course;
    private String group;
    private int numberOfTasks;
    private int numberOfCompletedTasks;
    private int numberOfToDoTasks;
    private String programmingLanguage;

    public Student() {
    }

    public Student(Student student) throws StudentException {
        this(student.fio, student.course, student.group, student.numberOfTasks, student.numberOfCompletedTasks, student.programmingLanguage);
    }

    public Student(String fio, int course, String group, int numberOfTasks, int numberOfCompletedTasks, String programmingLanguage) throws StudentException {

        if (course <= 0 || numberOfCompletedTasks <= 0
                || fio == null || group == null || programmingLanguage == null
                || numberOfTasks < numberOfCompletedTasks)
            throw new StudentException("Incorrect parameters");

        if (!Pattern.compile("\\A([a-zA-Z]+\\s){2}([a-zA-Z]+)\\Z").matcher(fio).find())
            throw new StudentException("Incorrect FIO: " + fio);
        if (!Pattern.compile("\\A([a-zA-Z0-9]+)\\Z").matcher(group).find())
            throw new StudentException("Incorrect group: " + group);
        if (!Pattern.compile("\\A(.+)\\Z").matcher(programmingLanguage).find())
            throw new StudentException("Incorrect programming language: " + programmingLanguage);

        this.fio = fio;
        this.course = course;
        this.group = group;
        this.numberOfTasks = numberOfTasks;
        this.numberOfCompletedTasks = numberOfCompletedTasks;
        this.programmingLanguage = programmingLanguage;
        this.numberOfToDoTasks = numberOfTasks - numberOfCompletedTasks;
    }

    public String getFio() {
        return fio;
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

    public int getNumberOfToDoTasks() {
        return numberOfToDoTasks;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public enum AllCriteria {
        FIO("fio"),
        COURSE("course"),
        GROUP("group"),
        NUMBER_OF_TASKS("numberOfTasks"),
        NUMBER_OF_COMPLETED_TASKS("numberOfCompletedTasks"),
        PROGRAMMING_LANGUAGE("programmingLanguage"),
        NUMBER_OF_TO_DO_TASKS("numberOfToDoTasks");

        private final String numValue;

        AllCriteria(String numValue) {
            this.numValue = numValue;
        }

        public String getValue() {
            return numValue;
        }
    }

    @Override
    public String toString() {
        return "[" + this.fio + ", " + this.programmingLanguage + ", "
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
        return fio.equals(guest.fio) && course == guest.course && group.equals(guest.group)
                && numberOfTasks == guest.numberOfTasks && numberOfCompletedTasks == guest.numberOfCompletedTasks
                && programmingLanguage.equals(guest.programmingLanguage);
    }
}
