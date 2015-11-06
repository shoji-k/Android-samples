package jp.freks.cookpadinternship2015summer.model;

import java.util.Date;
import java.util.List;

/**
 * Created by user on 15/11/06.
 */
public class Image {

    private int id;

    private String title;

    private String url;

    private Date createdAt;

    private List<Comment> comments;

    public Image() {
    }

    public Image(int id, String title, String url) {
        this.id = id;
        this.title = title;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
