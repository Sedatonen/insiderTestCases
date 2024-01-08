package service;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.request.PetRequest;

import java.io.File;

import static io.restassured.RestAssured.given;

public class PetStoreService {

    public static final String STORE_BASE_PATH = "/store";

    public static final String PET_BASE_PATH = "/pet";

    public Response getStoreInventory(RequestSpecification requestSpec) {

        return given()
                .spec(requestSpec)
                .basePath(STORE_BASE_PATH)
                .when()
                .get("/inventory")
                .then()
                .assertThat()
                .log().ifValidationFails()
                .extract().response();
    }

    public Response createPet(PetRequest petRequest, RequestSpecification requestSpec, ResponseSpecification responseSpec) {

        return given()
                .spec(requestSpec)
                .basePath(PET_BASE_PATH)
                .body(petRequest)
                .when()
                .post()
                .then()
                .assertThat()
                .spec(responseSpec)
                .log().ifValidationFails()
                .extract().response();
    }
    public Response uploadsImage(Long petId, String additionalMetadata, File file, RequestSpecification requestSpec, ResponseSpecification responseSpec) {

        return given()
                .spec(requestSpec)
                .basePath(PET_BASE_PATH)
                .pathParam("petId", petId)
                .formParam("additionalMetadata", additionalMetadata)
                .multiPart("file", file)
                .when()
                .post("/{petId}/uploadImage")
                .then()
                .assertThat()
                .spec(responseSpec)
                .log().ifValidationFails()
                .extract().response();
    }


    public Response updatePet(PetRequest updatePetRequest, RequestSpecification requestSpec, ResponseSpecification responseSpec){
        return given()
                .spec(requestSpec)
                .basePath(PET_BASE_PATH)
                .body(updatePetRequest)
                .when()
                .put()
                .then()
                .assertThat()
                .spec(responseSpec)
                .log().ifValidationFails()
                .extract().response();

    }

    public Response getPetsByStatus(String status, RequestSpecification requestSpec, ResponseSpecification responseSpec) {

        return given()
                .spec(requestSpec)
                .basePath(PET_BASE_PATH)
                .queryParam("status", status)
                .when()
                .get("/findByStatus")
                .then()
                .assertThat()
                .spec(responseSpec)
                .log().ifValidationFails()
                .extract().response();
    }

    public Response getPetById(Long petId, RequestSpecification requestSpec, ResponseSpecification responseSpec) {

        return given()
                .spec(requestSpec)
                .basePath(PET_BASE_PATH)
                .pathParam("petId", petId)
                .when()
                .get("/{petId}")
                .then()
                .assertThat()
                .spec(responseSpec)
                .log().ifValidationFails()
                .extract().response();
    }

    public Response updatesPetWithFormData(Long petId, String name, String status, RequestSpecification requestSpec, ResponseSpecification responseSpec) {

        return given()
                .spec(requestSpec)
                .basePath(PET_BASE_PATH)
                .pathParam("petId", petId)
                .formParam("name", name)
                .formParam("status", status)
                .when()
                .post("/{petId}")
                .then()
                .assertThat()
                .spec(responseSpec)
                .log().ifValidationFails()
                .extract().response();
    }

    public Response deletePet(Long petId,RequestSpecification requestSpec, ResponseSpecification responseSpec){
        return given()
                .spec(requestSpec)
                .basePath(PET_BASE_PATH)
                .pathParam("petId", petId)
                .when()
                .delete("/{petId}")
                .then()
                .assertThat()
                .spec(responseSpec)
                .log().ifValidationFails()
                .extract().response();

    }
}
