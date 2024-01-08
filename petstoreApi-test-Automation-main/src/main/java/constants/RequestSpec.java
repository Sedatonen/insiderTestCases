package constants;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


public class RequestSpec {

    private RequestSpec() {

    }

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder().build()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .filter(new RequestLoggingFilter(LogDetail.ALL))
                .baseUri(Url.PETSTORE_API_URL)
                .header("api_key","animalsSpecialApiKey");
    }

    public static RequestSpecification requestSpecificationFileUpload() {
        return new RequestSpecBuilder().build()
                .accept(ContentType.JSON)
                .contentType(ContentType.MULTIPART)
                .filter(new RequestLoggingFilter(LogDetail.ALL))
                .baseUri(Url.PETSTORE_API_URL)
                .header("api_key","animalsSpecialApiKey");
    }

    public static RequestSpecification requestSpecificationFormData() {
        return new RequestSpecBuilder().build()
                .accept(ContentType.JSON)
                .contentType(ContentType.URLENC)
                .filter(new RequestLoggingFilter(LogDetail.ALL))
                .baseUri(Url.PETSTORE_API_URL)
                .header("api_key","animalsSpecialApiKey");
    }

}
