package model;

import java.util.Date;

import Utils.Enums.Categories;
import Utils.Enums.State;

public class Post {
    private int idPost;
    private String content;
    private String mediaURL;
    private int likeNumber;
    private Date createdAt;
    private String createdBy;
    private Categories categories;
    private State state;


    public long getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMediaURL() {
        return mediaURL;
    }

    public void setMediaURL(String mediaURL) {
        this.mediaURL = mediaURL;
    }

    public int getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(int likeNumber) {
        this.likeNumber = likeNumber;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public State getState() {
        return this.state;
    }

    public void setStatus(State status) {
        this.state = status;
    }

    public Post(int idPost, String content, String mediaURL, int likeNumber, Date createdAt, String createdBy, Categories categories) {
        this.idPost = idPost;
        this.content = content;
        this.mediaURL = mediaURL;
        this.likeNumber = likeNumber;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Post{" +
                "idPost=" + idPost +
                ", content='" + content + '\'' +
                ", mediaURL='" + mediaURL + '\'' +
                ", likeNumber=" + likeNumber +
                ", createdAt=" + createdAt +
                ", createdBy=" + createdBy +
                ", categories=" + categories +
                '}';
    }
}
