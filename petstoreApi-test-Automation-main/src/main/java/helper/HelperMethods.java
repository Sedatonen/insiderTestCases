package helper;

import com.github.javafaker.Faker;

import java.util.Random;


public class HelperMethods {

    public static String getRandomName() {
        Faker faker = new Faker();
        return faker.animal().name();
    }

    public static Long getRandomLong() {
        Faker faker = new Faker();
        return faker.random().nextLong(999999999);
    }

    public static String getRandomCategoryName() {
        Faker faker = new Faker();
        return faker.cat().name();
    }

    public static int getRandomCategoryId() {
        Faker faker = new Faker();
        return faker.random().nextInt(101, 997);
    }

    public static String getRandomTagsName() {
        Faker faker = new Faker();
        return faker.funnyName().name();
    }

    public static int getRandomTagsId() {
        Faker faker = new Faker();
        return faker.random().nextInt(2000, 2999);
    }

    public static String getRandomMetadata() {
        Faker faker = new Faker();
        return faker.lorem().word();
    }

    public static String getRandomStatus() {
        String[] statusValues = {"available", "pending", "sold"};
        Random random = new Random();
        int index = random.nextInt(statusValues.length);
        return statusValues[index];
    }

    public static String getRandomPhotoUrl() {
        Faker faker = new Faker();
        return "www." + faker.cat().name().toLowerCase() + faker.animal().name() + ".com/" + "photos/" + faker.random().nextLong(99999);
    }


}
