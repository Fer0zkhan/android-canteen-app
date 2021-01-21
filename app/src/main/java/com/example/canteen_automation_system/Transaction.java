package com.example.canteen_automation_system;

public class Transaction {
    String id;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    String order_id;

    public Transaction(String id, String order_id, String transaction_canteen_id, String transaction_canteen_name, String transaction_food_name, String transaction_cost, String transaction_student_id) {
        this.id = id;
        this.transaction_canteen_id = transaction_canteen_id;
        this.transaction_canteen_name = transaction_canteen_name;
        this.transaction_food_name = transaction_food_name;
        this.transaction_cost = transaction_cost;
        this.transaction_student_id = transaction_student_id;
        this.order_id = order_id;
    }

    public Transaction() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTransaction_canteen_id() {
        return transaction_canteen_id;
    }

    public void setTransaction_canteen_id(String transaction_canteen_id) {
        this.transaction_canteen_id = transaction_canteen_id;
    }

    public String getTransaction_canteen_name() {
        return transaction_canteen_name;
    }

    public void setTransaction_canteen_name(String transaction_canteen_name) {
        this.transaction_canteen_name = transaction_canteen_name;
    }

    public String getTransaction_food_name() {
        return transaction_food_name;
    }

    public void setTransaction_food_name(String transaction_food_name) {
        this.transaction_food_name = transaction_food_name;
    }

    public String getTransaction_cost() {
        return transaction_cost;
    }

    public void setTransaction_cost(String transaction_cost) {
        this.transaction_cost = transaction_cost;
    }

    public String getTransaction_student_id() {
        return transaction_student_id;
    }

    public void setTransaction_student_id(String transaction_student_id) {
        this.transaction_student_id = transaction_student_id;
    }

    String transaction_canteen_id;
    String transaction_canteen_name;
    String transaction_food_name;
    String transaction_cost;
    String transaction_student_id;
}
