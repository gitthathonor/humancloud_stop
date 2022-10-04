package site.metacoding.humancloud.domain.user;

public interface UserDao {
    public void save();
    public void findById();
    public void findAll();
    public void update();
    public void delete();
}
