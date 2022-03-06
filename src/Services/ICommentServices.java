package Services;

import java.util.List;

import Modules.CommentPost;

public interface ICommentServices <T>{
  public boolean addCommentToPost(T t);
  public boolean deleteCommentByPost(T t);
  public boolean updateCommentByPost(T t);
  public List<CommentPost> getListCommentByPost(long idPost);
}
