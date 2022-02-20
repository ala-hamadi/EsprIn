package Services;

import Modules.User;
import Utils.Enums.Roles;
import Utils.Enums.State;

import java.util.List;

public interface IServices<T> {
    public void add(T t);
    public Boolean delete(T t);
    //public void changeState(User user, State state);
    public Boolean update(T t);
    public List<T> getList();
    public T retrive(long i);

}
