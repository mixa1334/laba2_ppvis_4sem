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
        if (fio == null || group == null || programmingLanguage == null)
            throw new StudentException("Поля не могут быть пустыми!");
        if (numberOfTasks < 0)
            throw new StudentException("Число работ не может быть отрицательным!");
        if (numberOfCompletedTasks < 0 || numberOfCompletedTasks > numberOfTasks)
            throw new StudentException("Число выполненных работ не может превышать число всех работ или быть отрицательным!");
        if (course <= 0 || course > 5)
            throw new StudentException("Курс студента должен быть в промежутке от 1 до 5 включительно!");
        if (!Pattern.compile("\\A([a-zA-Z \\u0400-\\u04FF]+\\s){2}([a-zA-Z\\u0400-\\u04FF]+)\\Z").matcher(fio.trim()).find())
            throw new StudentException("Неверное ФИО: " + fio);
        if (!Pattern.compile("\\A([0-9]{6})\\Z").matcher(group.trim()).find())
            throw new StudentException("Неверная группа: " + group);
        if (!Pattern.compile("\\A(.+)\\Z").matcher(programmingLanguage.trim()).find())
            throw new StudentException("Неверный язык программирования: " + programmingLanguage);

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
        FIO("ФИО", "fio"),
        COURSE("Курс", "course"),
        GROUP("Группа", "group"),
        NUMBER_OF_TASKS("Общее число работ", "numberOfTasks"),
        NUMBER_OF_COMPLETED_TASKS("Количество выполненных работ", "numberOfCompletedTasks"),
        NUMBER_OF_TO_DO_TASKS("Количество невыполненных работ", "numberOfToDoTasks"),
        PROGRAMMING_LANGUAGE("Язык программирования", "programmingLanguage");

        private final String value;
        private final String name;

        AllCriteria(final String name, final String value) {
            this.value = value;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public static String[] getAllName() {
            return new String[]{FIO.name, COURSE.name, GROUP.name, NUMBER_OF_TASKS.name,
                    NUMBER_OF_COMPLETED_TASKS.name, PROGRAMMING_LANGUAGE.name, NUMBER_OF_TO_DO_TASKS.name};
        }

        public String getValue() {
            return value;
        }

        public static String[] getAllValues() {
            return new String[]{FIO.value, COURSE.value, GROUP.value, NUMBER_OF_TASKS.value,
                    NUMBER_OF_COMPLETED_TASKS.value, PROGRAMMING_LANGUAGE.value, NUMBER_OF_TO_DO_TASKS.value};
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