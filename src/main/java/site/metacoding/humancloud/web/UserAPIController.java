package site.metacoding.humancloud.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.humancloud.dto.JoinDto;
import site.metacoding.humancloud.service.UserService;

@RequiredArgsConstructor
@RestController
public class UserAPIController {
    
    private final UserService userService;

    @PostMapping("/api/user/join")
    public @ResponseBody int apijoin(@RequestBody JoinDto joinDto){
        return userService.회원가입(joinDto);
    }
}
