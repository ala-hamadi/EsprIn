package Modules;

import java.util.Date;

import Utils.Enums.State;

public class CommentPost {
  private int idUser;
  private int idPost;
  private String content;
  private Date createdAt;
  private State state;

  public int getIdUser() {
    return idUser;
  }

  public void setIdUser(int idUser) {
    this.idUser = idUser;
  }

  public int getIdPost() {
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

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }

  public CommentPost(int idUser, int idPost, String content, Date createdAt, State state) {
    this.idUser = idUser;
    this.idPost = idPost;
    this.content = content;
    this.createdAt = createdAt;
    this.state = state;
  }
  public CommentPost(int idUser, int idPost, String content, Date createdAt) {
    this.idUser = idUser;
    this.idPost = idPost;
    this.content = content;
    this.createdAt = createdAt;
  }
  @Override
  public String toString() {
    return "CommentPost{" +
        "idUser=" + idUser +
        ", idPost=" + idPost +
        ", content='" + content + '\'' +
        ", createdAt=" + createdAt +
        '}';
  }
}
