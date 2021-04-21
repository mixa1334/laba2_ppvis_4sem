package laba2Package.Controllers;

import laba2Package.Models.StudentsModel;
import laba2Package.Views.View;

public class Controller {
    private final View view;
    private StudentsModel studentsModel;

    public Controller(final View view, final StudentsModel studentsModel) {
        this.view = view;
        this.studentsModel = studentsModel;
    }
}
