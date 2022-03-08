package Services;

import Modules.LikePost;

public interface ILikeServices<T>{

  public boolean putLikeToPost(int idUser,int idPost);
  public boolean putUnLikeToPost(int idUser,int idPost);
  public long numberOfLikesByPost(long id);
}
