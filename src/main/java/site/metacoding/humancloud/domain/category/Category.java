package site.metacoding.humancloud.domain.category;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Category {
    private Integer categoryId;
    private Integer categoryUserId;
    private Integer categoryCompanyId;
    private String categoryName;

    public Category(Integer categoryUserId, String categoryName){
        this.categoryUserId=categoryUserId;
        this.categoryName=categoryName;
    }
}
