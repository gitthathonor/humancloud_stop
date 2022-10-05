package site.metacoding.humancloud.domain.chatting;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chatting {
	public Integer chattingId;
	public Integer chattingUserId;
	public String chattingContent;
	public Timestamp chattingCreatedAt;
}
