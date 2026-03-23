package test_data;

import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FakerData {
    private static final Faker faker = new Faker();

    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String userEmail = faker.internet().emailAddress();
    public static String sex = faker.demographic().sex();
    public static String userNumber = faker.phoneNumber().subscriberNumber(10);
    public static String month = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    public static String year = birthYear();

    public static String birthYear() {
        Date birthDate = faker.date().birthday();
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        return yearFormat.format(birthDate);
    }

    public static String dayOfBirth() {
        Date birthDate = faker.date().birthday();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
        return dateFormat.format(birthDate);
    }
    public static String day = dayOfBirth();
    public static String subject = faker.options().option("Hindi", "Commerce", "Accounting", "English", "Maths", "Physics", "Civics", "Chemistry", "Biology", "Computer Science", "Economics", "Arts", "Social Studies", "History");
    public static String hobby = faker.options().option("Sports", "Reading", "Music");
    public static String picture = faker.options().option("britney.png", "johnny.png");
    public static String currentAddress = faker.address().fullAddress();
    public static String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public static String city = selectCity(state);

    public static String selectCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }
}
