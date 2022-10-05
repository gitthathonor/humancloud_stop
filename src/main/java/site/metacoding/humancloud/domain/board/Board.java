package site.metacoding.humancloud.domain.board;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
	public Integer boardId;
	public String boardTitle;
	public String boardContent;
	public String boardFile;
	public Integer boardReadCount;
	public Integer boardLikesCount;
	public Timestamp boardCreatedAt;
}
