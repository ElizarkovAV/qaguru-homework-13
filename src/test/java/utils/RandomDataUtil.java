package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;

public class RandomDataUtil {

    Faker faker = new Faker();

    public String getRandomFirstName() {
        return faker.name().firstName();
    }

    public String getRandomLastName() {
        return faker.name().lastName();
    }

    public String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public String getRandomMobile() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String getRandomSubject() {
        return faker.options().option("Arts", "Physics", "Computer Science");
    }
    public String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public String getRandomHobby() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public String getRandomGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public String getRandomState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public String getRandomCity (String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> "Unknown";
        };
    }

    public String getRandomDay() {
        return String.format("%02d", faker.number().numberBetween(1, 28));
    }

    public String getRandomMonth() {
        return faker.options().option("January", "February", "March", "April", "May"
                , "June", "July", "August", "September", "October", "November", "December");
    }

    public String getRandomYear() {
        return new SimpleDateFormat("yyyy").format(faker.date().birthday());
    }

    public String getRandomPicture() {
        return faker.options().option("pic.jpg", "pic2.jpg", "pic3.jpg");
    }
}
