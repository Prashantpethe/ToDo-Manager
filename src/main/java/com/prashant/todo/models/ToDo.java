package com.prashant.todo.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ToDo {

    private int id;
    private String  title;
    private String content;
    private String status;

    private Date addedDate;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date toDoDate;

    public ToDo() {
    }

    public ToDo(int id, String title, String content, String status,Date addedDate,Date  toDoDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.addedDate = addedDate;
        this.toDoDate = toDoDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Date getToDoDate() {
        return toDoDate;
    }

    public void setToDoDate(Date toDoDate) {
        this.toDoDate = toDoDate;
    }

    public String getContent() {
        return content;
    }

    public void setId(int id) {
        this.id = id;
    }



    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", addedDate=" + addedDate +
                ", toDoDate=" + toDoDate +
                '}';
    }
}
