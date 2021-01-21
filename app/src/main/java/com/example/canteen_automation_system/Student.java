package com.example.canteen_automation_system;

public class Student {
    String id;

    public Student(String id, String student_id, String student_password, String student_balance) {
        this.id = id;
        this.student_id = student_id;
        this.student_password = student_password;
        this.student_balance = student_balance;
    }

    public Student() {
    }

    String student_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_password() {
        return student_password;
    }

    public void setStudent_password(String student_password) {
        this.student_password = student_password;
    }

    public String getStudent_balance() {
        return student_balance;
    }

    public void setStudent_balance(String student_balance) {
        this.student_balance = student_balance;
    }

    String student_password;
    String student_balance;
}
