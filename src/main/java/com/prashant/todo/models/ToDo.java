package com.prashant.todo.models;

public class ToDo {

    private int id;
    private String  title;
    private String content;
    private String status;

    public ToDo() {
    }

    public ToDo(int id, String title, String content, String status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
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
                '}';
    }
}
