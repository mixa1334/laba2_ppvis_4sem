package laba2Package;

import laba2Package.Controllers.Controller;
import laba2Package.Models.StudentsModel;
import laba2Package.Views.View;

public class App {

    public static void main(String[] args) {
        new Controller(new View(), new StudentsModel());
    }
}
