package services;

import java.util.List;

public interface IPostServices<T> {

  public boolean addPost(T t);

  public boolean deletePost(int id);

  public boolean updatePost(T t);

  public List<T> getListPosts();

  public T getPost(int i);

}
