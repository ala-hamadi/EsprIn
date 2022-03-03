package model;

import java.util.Date;

public class CommentPost {
  private String idUser;
  private int idPost;
  private String content;
  private Date createdAt;

  public String getIdUser() {
    return idUser;
  }

  public void setIdUser(String idUser) {
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

  public CommentPost(String idUser, int idPost, String content, Date createdAt) {
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
