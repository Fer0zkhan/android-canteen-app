package com.example.canteen_automation_system;

public class Item {
    String item_id_list;
    String item_name_list;
    String item_des_list;
    String item_cost_list;
    String item_time_list;

    public String getCanteen_id() {
        return canteen_id;
    }

    public void setCanteen_id(String canteen_id) {
        this.canteen_id = canteen_id;
    }

    String canteen_id;

    public String getItem_can_id() {
        return item_can_id;
    }

    public void setItem_can_id(String item_can_id) {
        this.item_can_id = item_can_id;
    }

    String item_can_id;

    public Item(String item_id_list, String item_name_list, String item_des_list, String item_cost_list, String item_time_list, String item_can_name, String canteen_id) {
        this.item_id_list = item_id_list;
        this.item_name_list = item_name_list;
        this.item_des_list = item_des_list;
        this.item_cost_list = item_cost_list;
        this.item_time_list = item_time_list;
        this.item_can_name = item_can_name;
        this.canteen_id = canteen_id;
    }

    public Item() {
    }

    String item_can_name;

    public String getItem_can_name() {
        return item_can_name;
    }

    public void setItem_can_name(String item_can_name) {
        this.item_can_name = item_can_name;
    }

    public String getItem_id_list() {
        return item_id_list;
    }

    public void setItem_id_list(String item_id_list) {
        this.item_id_list = item_id_list;
    }

    public String getItem_name_list() {
        return item_name_list;
    }

    public void setItem_name_list(String item_name_list) {
        this.item_name_list = item_name_list;
    }

    public String getItem_des_list() {
        return item_des_list;
    }

    public void setItem_des_list(String item_des_list) {
        this.item_des_list = item_des_list;
    }

    public String getItem_cost_list() {
        return item_cost_list;
    }

    public void setItem_cost_list(String item_cost_list) {
        this.item_cost_list = item_cost_list;
    }

    public String getItem_time_list() {
        return item_time_list;
    }

    public void setItem_time_list(String item_time_list) {
        this.item_time_list = item_time_list;
    }

}
