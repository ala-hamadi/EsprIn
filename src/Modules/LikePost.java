package Modules;

import java.util.Date;

public class LikePost {
  private String idUser;
  private int idPost;
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

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public LikePost(String idUser, int idPost, Date createdAt) {
    this.idUser = idUser;
    this.idPost = idPost;
    this.createdAt = createdAt;
  }

  @Override
  public String toString() {
    return "LikePost{" +
        "idUser=" + idUser +
        ", idPost=" + idPost +
        ", createdAt=" + createdAt +
        '}';
  }
}
