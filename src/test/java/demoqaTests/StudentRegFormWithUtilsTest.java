package demoqaTests;

import pages.StudentRegistrationFormPage;
import test_data.FakerData;
import test_data.GeneratedData;
import test_data.TestBase;
import org.junit.jupiter.api.Test;


public class StudentRegFormWithUtilsTest extends TestBase {
    StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();
    FakerData fakerData = new FakerData();
    GeneratedData genData = new GeneratedData(fakerData);

    @Test
    void successfulRegistrationFormTest() {
        studentRegistrationFormPage
                .openPage()
                .hideBanners()
                .typeFirstName(genData.firstNameF)
                .typeLastName(genData.firstNameF)
                .typeUserEmail(genData.userEmailF)
                .setGender(genData.sexF)
                .typeUserNumber(genData.userNumberF)
                .setDateOfBirth (genData.dayF,genData.monthF,genData.yearF)
                .setSubjects(genData.subjectF)
                .setHobby(genData.hobbyF)
                .uploadPicture(genData.pictureF)
                .setCurrentAddress(genData.currentAddressF)
                .chooseStateAndCity(genData.stateF,genData.cityF)
                .submitForm()
                .resultWindowAppear()
                .checkForm("Student Name", genData.firstNameF + " " + genData.firstNameF)
                .checkForm("Student Email", genData.userEmailF)
                .checkForm("Gender", genData.sexF)
                .checkForm("Mobile", genData.userNumberF)
                .checkForm("Date of Birth", genData.dayF + " " + genData.monthF + "," + genData.yearF)
                .checkForm("Subjects", genData.subjectF)
                .checkForm("Hobbies", genData.hobbyF)
                .checkForm("Address", genData.currentAddressF)
                .checkForm("Picture", genData.pictureF)
                .checkForm("State and City", genData.stateF + " " + genData.cityF)
                //.closeForm()
        ;

    }
}