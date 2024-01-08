package models.request;

import lombok.Builder;
import lombok.Data;

import static helper.HelperMethods.getRandomTagsId;
import static helper.HelperMethods.getRandomTagsName;

@Builder
@Data
public class Tags {

    @Builder.Default
    private String name = getRandomTagsName();

    @Builder.Default
    private int id = getRandomTagsId();

}
