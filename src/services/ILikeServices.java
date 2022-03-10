package Services;

import Modules.LikePost;

public interface ILikeServices<T>{

  public boolean putLikeToPost(int idUser,int idPost);
  public boolean putUnLikeToPost(int idUser,int idPost);
  public long numberOfLikesByPost(long id);
  public long likeExists(long id1,long id2);
}
