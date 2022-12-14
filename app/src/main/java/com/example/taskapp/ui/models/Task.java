package com.example.taskapp.ui.models;

import java.io.Serializable;

public class Task implements Serializable {

    private long id;
    private String title;

    public Task(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
}
