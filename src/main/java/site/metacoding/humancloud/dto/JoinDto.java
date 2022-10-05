package site.metacoding.humancloud.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JoinDto {
	private Integer userId;
	private String username;
	private String password;
	private String name;
	private String email;
	private String phoneNumber;
	private List<String> categoryList;
}
