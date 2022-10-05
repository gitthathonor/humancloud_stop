package site.metacoding.humancloud.domain.resume;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Resume {
	public Integer resumeId;
	public String resumeTitle;
	public String resumeEducation;
	public String resumeCareer;
	public String resumePhoto;
	public String resumeJob;
	public String resumeUserId;
	public Integer resumeReadCount;
	public Timestamp resumeCreatedAt;
	
}
