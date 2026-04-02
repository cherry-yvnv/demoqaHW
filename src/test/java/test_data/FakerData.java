package test_data;

import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FakerData {
    private final Faker faker = new Faker();

    public String generateFirstName() {
        return faker.name().firstName();
    }

    public String generateLastName() {
        return faker.name().lastName();
    }

    public String generateUserEmail() {
        return faker.internet().emailAddress();
    }

    public String generateSex() {
        return faker.demographic().sex();
    }

    public String generateUserNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String generateMonth() {
        return faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    }

    public String generateYear() {
        Date birthDate = faker.date().birthday();
        return new SimpleDateFormat("yyyy").format(birthDate);
    }

    public String generateDayOfBirth() {
        Date birthDate = faker.date().birthday();
        return new SimpleDateFormat("dd").format(birthDate);
    }

    public String generateSubject() {
        return faker.options().option("Hindi", "Commerce", "Accounting", "English", "Maths", "Physics", "Civics", "Chemistry", "Biology", "Computer Science", "Economics", "Arts", "Social Studies", "History");
    }

    public String generateHobby() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public String generatePicture() {
        return faker.options().option("britney.png", "johnny.png");
    }

    public String generateCurrentAddress() {
        return faker.address().fullAddress();
    }

    public String generateState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public String generateCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }
}