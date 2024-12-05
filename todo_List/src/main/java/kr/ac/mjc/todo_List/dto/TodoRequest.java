package kr.ac.mjc.todo_List.dto;

import jakarta.persistence.Column;

public class TodoRequest {
    private String title;

    private String content;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
