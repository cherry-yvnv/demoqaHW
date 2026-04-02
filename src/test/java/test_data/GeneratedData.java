package test_data;


public class GeneratedData {
    public final String firstNameF;
    public final String lastNameF;
    public final String userEmailF;
    public final String sexF;
    public final String userNumberF;
    public final String monthF;
    public final String yearF;
    public final String dayF;
    public final String subjectF;
    public final String hobbyF;
    public final String pictureF;
    public final String currentAddressF;
    public final String stateF;
    public final String cityF;

    public GeneratedData(FakerData fakerData) {
        this.firstNameF = fakerData.generateFirstName();
        this.lastNameF = fakerData.generateLastName();
        this.userEmailF = fakerData.generateUserEmail();
        this.sexF = fakerData.generateSex();
        this.userNumberF = fakerData.generateUserNumber();
        this.monthF = fakerData.generateMonth();
        this.yearF = fakerData.generateYear();
        this.dayF = fakerData.generateDayOfBirth();
        this.subjectF = fakerData.generateSubject();
        this.hobbyF = fakerData.generateHobby();
        this.pictureF = fakerData.generatePicture();
        this.currentAddressF = fakerData.generateCurrentAddress();
        this.stateF = fakerData.generateState();
        this.cityF = fakerData.generateCity(this.stateF);
    }
}