package Modules;

import Utils.Enums.State;

import java.sql.Date;

public class Forum {
    private int idForum;
    private String title;
    private String content;
    private Date createdAt ;
    private String categoryForum;
    private int idOwner;
    private int nbLikes;
    private State state;

    public Forum(){

    }

    public Forum(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Forum(int idForum, String title, String content, int idOwner, String categoryForum, State state) {
        this.idForum = idForum;
        this.title = title;
        this.content = content;
        this.idOwner = idOwner;
        this.categoryForum = categoryForum;
        this.state=state;
    }

    public Forum(int idForum, String title, String content, Date createdAt, String categoryForum, int idOwner, int nbLikes, State state) {
        this.idForum = idForum;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.categoryForum = categoryForum;
        this.idOwner = idOwner;
        this.nbLikes = nbLikes;
        this.state = state;
    }

    public int getIdForum() {
        return idForum;
    }

    public void setIdForum(int idForum) {
        this.idForum = idForum;
    }

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

    public int getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(int idOwner) {
        this.idOwner = idOwner;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCategoryForum() {
        return categoryForum;
    }

    public void setCategoryForum(String categoryForum) {
        this.categoryForum = categoryForum;
    }

    public int getNbLikes() {
        return nbLikes;
    }

    public void setNbLikes(int nbLikes) {
        this.nbLikes = nbLikes;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Forum{" +
                "idForum=" + idForum +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                ", categoryForum='" + categoryForum + '\'' +
                ", idOwner=" + idOwner +
                ", nbLikes=" + nbLikes +
                ", state=" + state +
                '}';
    }
}
