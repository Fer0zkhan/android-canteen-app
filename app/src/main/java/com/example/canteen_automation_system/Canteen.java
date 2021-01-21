package com.example.canteen_automation_system;

public class Canteen {
    String canteen_id;
    String canteen_name;
    String canteen_handler;

    public String getCanteen_password() {
        return canteen_password;
    }

    public void setCanteen_password(String canteen_password) {
        this.canteen_password = canteen_password;
    }

    String canteen_password;

    public Canteen(String canteen_id, String canteen_name, String canteen_handler, String canteen_password, String canteen_phone, String canteen_work, String canteen_address) {
        this.canteen_id = canteen_id;
        this.canteen_name = canteen_name;
        this.canteen_handler = canteen_handler;
        this.canteen_password = canteen_password;
        this.canteen_phone = canteen_phone;
        this.canteen_work = canteen_work;
        this.canteen_address = canteen_address;
    }

    public Canteen() {
    }

    String canteen_phone;

    public String getCanteen_id() {
        return canteen_id;
    }

    public void setCanteen_id(String canteen_id) {
        this.canteen_id = canteen_id;
    }

    public String getCanteen_name() {
        return canteen_name;
    }

    public void setCanteen_name(String canteen_name) {
        this.canteen_name = canteen_name;
    }

    public String getCanteen_handler() {
        return canteen_handler;
    }

    public void setCanteen_handler(String canteen_handler) {
        this.canteen_handler = canteen_handler;
    }

    public String getCanteen_phone() {
        return canteen_phone;
    }

    public void setCanteen_phone(String canteen_phone) {
        this.canteen_phone = canteen_phone;
    }

    public String getCanteen_work() {
        return canteen_work;
    }

    public void setCanteen_work(String canteen_work) {
        this.canteen_work = canteen_work;
    }

    public String getCanteen_address() {
        return canteen_address;
    }

    public void setCanteen_address(String canteen_address) {
        this.canteen_address = canteen_address;
    }

    String canteen_work;
    String canteen_address;
}
