package site.metacoding.humancloud.domain.user;

import java.sql.Timestamp;

import lombok.Getter;

@Getter
public class User {
    private Integer userId;
    private String userUsername;
    private String userPassword;
    private String userName;
    private String userEmail;
    private String userPhoneNumber;
    private String userCategory;
    private Timestamp userCreatedAt;     
}
