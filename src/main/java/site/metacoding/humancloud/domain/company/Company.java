package site.metacoding.humancloud.domain.company;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Company {
	private Integer companyId;
	private String companyUsername;
	private String companyPassword;
	private String companyName;
	private String companyEmail;
	private String companyPhoneNumber;
	private String companyAddress;
	private Integer companyCategory;
	private Timestamp companyCreatedAt;
}
