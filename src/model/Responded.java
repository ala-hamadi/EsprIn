package model;

import java.sql.Timestamp;

public class Responded {
    private int cinUser;
    private int idForum;
    private String content;
    private Timestamp createdAt;

    public Responded() {
    }

    public Responded(int cinUser, int idForum, String content) {
        this.cinUser = cinUser;
        this.idForum = idForum;
        this.content = content;
    }
    public Responded(int cinUser, int idForum, String content, Timestamp createdAt) {
        this.cinUser = cinUser;
        this.idForum = idForum;
        this.content = content;
        this.createdAt = createdAt;
    }

    public int getCinUser() {
        return cinUser;
    }

    public void setCinUser(int cinUser) {
        this.cinUser = cinUser;
    }

    public int getIdForum() {
        return idForum;
    }

    public void setIdForum(int idForum) {
        this.idForum = idForum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Responded" +
                "cinUser=" + cinUser +
                ", idForum=" + idForum +
                ", content='" + content +
                ",createdAt='" + createdAt+
                '\n';
    }
}
