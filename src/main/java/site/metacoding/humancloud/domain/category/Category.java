package site.metacoding.humancloud.domain.category;

import java.sql.Timestamp;

import lombok.Getter;

@Getter
public class Category {
    private Integer categoryId;
    private Integer categoryUserId;
    private Integer categoryCompanyId;
    private Timestamp categoryCreateAt;
}
