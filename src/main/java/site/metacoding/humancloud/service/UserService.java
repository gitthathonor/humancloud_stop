package site.metacoding.humancloud.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.humancloud.domain.category.Category;
import site.metacoding.humancloud.domain.category.CategoryDao;
import site.metacoding.humancloud.domain.user.User;
import site.metacoding.humancloud.domain.user.UserDao;
import site.metacoding.humancloud.dto.JoinDto;
import site.metacoding.humancloud.dto.LoginDto;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserDao userDao;
    private final CategoryDao categoryDao;

    public int 회원가입(JoinDto joinDto){
        boolean checkUsername = 유저네임중복체크(joinDto.getUsername());
        if(checkUsername==true){
            userDao.save(joinDto);
            for(String category : joinDto.getCategoryList()){
                Category categoryElement = new Category(joinDto.getUserId(), category);
                categoryDao.save(categoryElement);
            }
            return 1;
        }
        return 0;
    }
    public boolean 유저네임중복체크(String username){
        User userPS = userDao.findByUsername(username);
        if(userPS==null){
            return true;
        } else{
            return false;
        }
    }

    public boolean 로그인(Integer id, LoginDto loginDto){
        User userPS = userDao.findById(id);
        if(loginDto.getUsername()!=userPS.getUsername()){
            return false;
        } else if (loginDto.getPassword()!=userPS.getPassword()){
            return false;
        }
        return true;
    }
}
