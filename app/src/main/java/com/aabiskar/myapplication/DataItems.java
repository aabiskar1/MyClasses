package com.aabiskar.myapplication;

public class DataItems {
    String module_title;
    String module_time;
    String module_block;
    String module_room;
    String module_type;
    String module_teacher;
    String module_group;
    String module_order;
    String module_day;

    public DataItems(){
        //Empty Constructor
    }

    public DataItems(String module_title, String module_time, String module_block, String module_room, String module_type, String module_teacher, String module_group,String module_order,String module_day) {
        this.module_title = module_title;
        this.module_time = module_time;
        this.module_block = module_block;
        this.module_room = module_room;
        this.module_type = module_type;
        this.module_teacher = module_teacher;
        this.module_group = module_group;
        this.module_order = module_order;
        this.module_day = module_day;
    }

    public String getModule_title() {
        return module_title;
    }

    public String getModule_time() {
        return module_time;
    }

    public String getModule_block() {
        return module_block;
    }

    public String getModule_room() {
        return module_room;
    }

    public String getModule_type() {
        return module_type;
    }

    public String getModule_teacher() {
        return module_teacher;
    }

    public String getModule_group() {
        return module_group;
    }
    public String getModule_order() {
        return module_order;
    }
    public String getModule_day() {
        return module_day;
    }
}
