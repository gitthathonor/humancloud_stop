package site.metacoding.humancloud.domain.user;

import java.util.List;

import site.metacoding.humancloud.dto.JoinDto;

public interface UserDao {
    public int save( JoinDto joinDto);
    public User findById(Integer id);
    public List<User> findAll();
    public int update(User user);
    public int deleteById(Integer userId);

	public User findByUsername(String username);
}
