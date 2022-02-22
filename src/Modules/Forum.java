package Modules;

import Utils.Enums.State;

public class Forum {
    private int idForum;
    private String title;
    private String content;
    private int idOwner;
    private State state;

    public Forum(){

    }

    public Forum(int idForum, String title, String content, int idOwner,State state) {
        this.idForum = idForum;
        this.title = title;
        this.content = content;
        this.idOwner = idOwner;
        this.state=state;
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

    @Override
    public String toString() {
        return "Forum" +
                "idForum=" + idForum +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", idOwner=" + idOwner +
                '\n';
    }
}
