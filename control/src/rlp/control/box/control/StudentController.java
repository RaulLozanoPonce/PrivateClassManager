package rlp.control.box.control;

import rlp.control.box.model.PrivateClassManager;
import rlp.control.box.model.Student;

public class StudentController {

    private final PrivateClassManager privateClassManager;

    public StudentController(PrivateClassManager privateClassManager) {
        this.privateClassManager = privateClassManager;
    }

    public void createStudent(String surname, String name, double hourPrize, long phone, String email) {
        privateClassManager.students().add(new Student(surname, name, hourPrize, phone, email));
    }
}
