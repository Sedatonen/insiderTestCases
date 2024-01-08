package tests.pet;


import models.request.Category;
import models.request.PetRequest;
import models.request.Tags;
import models.response.PetResponse;
import models.response.ApiResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import service.PetStoreService;

import java.io.File;
import java.util.Collections;

import static constants.RequestSpec.*;
import static constants.ResponseSpec.checkStatusCodeOk;
import static helper.HelperMethods.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PetStoreTest {

    PetStoreService petStoreService = new PetStoreService();

    PetRequest request;

    public PetStoreTest() {

        Category category = Category.builder().id(getRandomCategoryId()).name(getRandomCategoryName()).build();

        Tags tags = Tags.builder().id(getRandomTagsId()).name(getRandomTagsName()).build();

        request = PetRequest.builder().id(getRandomLong()).status(getRandomStatus()).name(getRandomName()).category(category).tags(Collections.singletonList(tags)).photoUrls(Collections.singletonList(getRandomPhotoUrl())).build();

    }

    @Test
    public void successCreatePet() {
        PetResponse petResponse = petStoreService.createPet(request, requestSpecification(), checkStatusCodeOk())
                .as(PetResponse.class);

        assertEquals(request.getCategory().getId(), petResponse.getCategory().getId());
        assertEquals(request.getCategory().getName(), petResponse.getCategory().getName());
        assertEquals(request.getTags().get(0).getId(), petResponse.getTags().get(0).getId());
        assertEquals(request.getTags().get(0).getName(), petResponse.getTags().get(0).getName());
        assertEquals(request.getId(), petResponse.getId());
        assertEquals(request.getStatus(), petResponse.getStatus());
        assertEquals(request.getName(), petResponse.getName());
        assertEquals(request.getPhotoUrls(), petResponse.getPhotoUrls());

    }

    @Test
    public void successUploadPetImage() {
        PetResponse petResponse = petStoreService.createPet(request, requestSpecification(), checkStatusCodeOk()).as(PetResponse.class);

        Long petId = petResponse.getId();

        String additionalMetadata = getRandomMetadata();

        File photoFile = new File("src/test/resources/photos/cat.jpeg");

        ApiResponse apiResponse =petStoreService.uploadsImage(petId, additionalMetadata, photoFile, requestSpecificationFileUpload(), checkStatusCodeOk())
                .as(ApiResponse.class);

        assertEquals(apiResponse.getCode(), HttpStatus.SC_OK);
        assertTrue(apiResponse.getMessage().contains(additionalMetadata));

    }

    @Test
    public void successUpdatePet() {
        PetResponse petResponse = petStoreService.createPet(request, requestSpecification(), checkStatusCodeOk()).as(PetResponse.class);

        Long petId = petResponse.getId();

        PetRequest updatePetRequest = PetRequest.builder()
                .id(petId)
                .build();

        PetResponse updatePetResponse = petStoreService.updatePet(updatePetRequest, requestSpecification(), checkStatusCodeOk())
                .as(PetResponse.class);

        assertEquals(updatePetRequest.getId(), updatePetResponse.getId());
        assertEquals(updatePetRequest.getTags().get(0).getId(), updatePetResponse.getTags().get(0).getId());
        assertEquals(updatePetRequest.getTags().get(0).getName(), updatePetResponse.getTags().get(0).getName());
        assertEquals(updatePetRequest.getCategory().getId(), updatePetResponse.getCategory().getId());
        assertEquals(updatePetRequest.getCategory().getName(), updatePetResponse.getCategory().getName());
        assertEquals(updatePetRequest.getName(), updatePetResponse.getName());
        assertEquals(updatePetRequest.getStatus(), updatePetResponse.getStatus());
        assertEquals(updatePetRequest.getPhotoUrls(), updatePetResponse.getPhotoUrls());

    }

    @Test
    public void successFindByStatusPet() {

        String status = getRandomStatus();

        petStoreService.getPetsByStatus(status, requestSpecification(), checkStatusCodeOk());

    }

    @Test
    public void successFindByPetId() {
        PetResponse createPetResponse = petStoreService.createPet(request, requestSpecification(), checkStatusCodeOk()).as(PetResponse.class);

        Long petId = createPetResponse.getId();

        PetResponse getPetResponse = petStoreService.getPetById(petId, requestSpecification(), checkStatusCodeOk())
                .as(PetResponse.class);

        assertEquals(createPetResponse.getId(), getPetResponse.getId());
        assertEquals(createPetResponse.getTags().get(0).getId(), getPetResponse.getTags().get(0).getId());
        assertEquals(createPetResponse.getTags().get(0).getName(), getPetResponse.getTags().get(0).getName());
        assertEquals(createPetResponse.getCategory().getId(), getPetResponse.getCategory().getId());
        assertEquals(createPetResponse.getCategory().getName(), getPetResponse.getCategory().getName());
        assertEquals(createPetResponse.getName(), getPetResponse.getName());
        assertEquals(createPetResponse.getStatus(), getPetResponse.getStatus());
        assertEquals(createPetResponse.getPhotoUrls(), getPetResponse.getPhotoUrls());

    }


    @Test
    public void successUpdatesPetWithFormData() {
        PetResponse createPetResponse = petStoreService.createPet(request, requestSpecification(), checkStatusCodeOk()).as(PetResponse.class);

        Long petId = createPetResponse.getId();

        String name = getRandomName();

        String status = getRandomStatus();

        ApiResponse apiResponse = petStoreService.updatesPetWithFormData(petId, name, status, requestSpecificationFormData(), checkStatusCodeOk())
                .as(ApiResponse.class);

        assertEquals(apiResponse.getMessage(), petId.toString());

    }

    @Test
    public void successDeletePet() {
        PetResponse createPetResponse = petStoreService.createPet(request, requestSpecification(), checkStatusCodeOk()).as(PetResponse.class);

        Long petId = createPetResponse.getId();

        ApiResponse apiResponse = petStoreService.deletePet(petId, requestSpecificationFormData(), checkStatusCodeOk())
                .as(ApiResponse.class);

        assertEquals(apiResponse.getMessage(), petId.toString());

    }


}
