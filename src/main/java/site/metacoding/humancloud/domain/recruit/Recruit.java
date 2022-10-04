package site.metacoding.humancloud.domain.recruit;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Recruit {
	public Integer recruitId;
	public String recruitTitle;
	public String recruitCareer;
	public String recruitPattern;
	public Integer recruitSalary;
	public String recruitLocation;
	public String recruitContent;
	public Integer recruitCompanyId;
	public Integer recruitReadCount;
	public Timestamp recruitCreatedAt;
}
