package rlp.control.box.model;

import java.util.ArrayList;
import java.util.List;

public class PrivateClassManager {

    private List<Student> students;
    private List<Class> classes;
    private List<Subject> subjects;
    private List<Teacher> teachers;

    public PrivateClassManager() {
        this.students = new ArrayList<>();
        this.classes = new ArrayList<>();
        this.subjects = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }

    public List<Student> students() {
        return students;
    }
}
