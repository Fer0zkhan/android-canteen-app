package com.example.canteen_automation_system;

public class Order {
    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrder_food_name() {
        return order_food_name;
    }

    public void setOrder_food_name(String order_food_name) {
        this.order_food_name = order_food_name;
    }

    public String getOrder_food_cost() {
        return order_food_cost;
    }

    public void setOrder_food_cost(String order_food_cost) {
        this.order_food_cost = order_food_cost;
    }

    public String getOrder_canteen_name() {
        return order_canteen_name;
    }

    public void setOrder_canteen_name(String order_canteen_name) {
        this.order_canteen_name = order_canteen_name;
    }

    public String getOrder_canteen_id() {
        return order_canteen_id;
    }

    public void setOrder_canteen_id(String order_canteen_id) {
        this.order_canteen_id = order_canteen_id;
    }

    public String getOrder_student_id() {
        return order_student_id;
    }

    public void setOrder_student_id(String order_student_id) {
        this.order_student_id = order_student_id;
    }

    public String getOrder_student_unique_id() {
        return order_student_unique_id;
    }

    public void setOrder_student_unique_id(String order_student_unique_id) {
        this.order_student_unique_id = order_student_unique_id;
    }

    String order_id;
    String order_food_name;

    public Order(String order_id, String order_food_name, String order_food_cost, String order_canteen_name, String order_canteen_id, String order_student_id, String order_student_unique_id) {
        this.order_id = order_id;
        this.order_food_name = order_food_name;
        this.order_food_cost = order_food_cost;
        this.order_canteen_name = order_canteen_name;
        this.order_canteen_id = order_canteen_id;
        this.order_student_id = order_student_id;
        this.order_student_unique_id = order_student_unique_id;
    }

    public Order() {
    }

    String order_food_cost;
    String order_canteen_name;
    String order_canteen_id;
    String order_student_id;
    String order_student_unique_id;
}
