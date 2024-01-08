package models.request;

import java.util.Collections;
import java.util.List;

import lombok.*;


import static helper.HelperMethods.*;

@Builder
public @Data class PetRequest {

    @Builder.Default
    private List<String> photoUrls = Collections.singletonList(getRandomPhotoUrl());

    @Builder.Default
    private String name = getRandomName();

    @Builder.Default
    private Long id = getRandomLong();

    @Builder.Default
    private Category category = Category.builder().build();

    @Builder.Default
    private List<Tags> tags = Collections.singletonList(Tags.builder().build());

    @Builder.Default
    private String status = getRandomStatus();


}