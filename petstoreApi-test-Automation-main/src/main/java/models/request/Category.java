package models.request;

import lombok.*;

import static helper.HelperMethods.*;

@Builder
public @Data class Category {

    @Builder.Default
    private String name = getRandomCategoryName();

    @Builder.Default
    private int id = getRandomCategoryId();
}