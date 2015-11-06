package jp.freks.cookpadinternship2015summer.model;

import java.util.Date;

/**
 * Created by user on 15/11/06.
 */
public class Comment {

    private int id;

    private String body;

    private Date createdAt;

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}