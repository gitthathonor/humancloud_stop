package site.metacoding.humancloud.domain.user;

import java.util.List;

public interface UserDao {
	public int save(User user);
	public User findById(Integer id);
	public List<User> findAll();
	public int update(User user);
	public int deleteById(Integer id);
}
