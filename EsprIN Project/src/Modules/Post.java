package Modules;

import java.sql.Timestamp;

public class Post {
    private static int postCount = 0;
    private String postId;
    private String content;
    private Timestamp createdAt;
    private String postCat;
    private long idOwner;

    public Post(String content, Timestamp timeCrea, String postCat, long idOwner) {
        postCount++;
        this.postId = String.valueOf(timeCrea.getDay()) + " " + String.valueOf(timeCrea.getHours()) + " " + String.valueOf(postCount) + " " + String.valueOf(idOwner).substring(0, 3);
        this.content = content;
        this.createdAt = timeCrea;
        this.postCat = postCat;
        this.idOwner = idOwner;
    }

    public static int getPostCount() {
        return postCount;
    }

    public static void setPostCount(int postCount) {
        Post.postCount = postCount;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
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

    public String getPostCat() {
        return postCat;
    }

    public void setPostCat(String postCat) {
        this.postCat = postCat;
    }

    public long getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(long idOwner) {
        this.idOwner = idOwner;
    }
}
