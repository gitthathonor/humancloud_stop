package site.metacoding.humancloud.domain.comment;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {
	public Integer commentId;
	public String commentContent;
	public String commentUserId;
	public String commentBoardId;
	public Timestamp recruitCreatedAt;
}
