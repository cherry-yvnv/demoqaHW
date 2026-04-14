package test_data;

public class UserData {public final String name;
    public final String email;
    public final String currentAddress;
    public final String permanentAddress;

    public UserData(String name, String email, String currentAddress, String permanentAddress) {
        this.name = name;
        this.email = email;
        this.currentAddress = currentAddress;
        this.permanentAddress = permanentAddress;
    }

    @Override
    public String toString() {
        return name + " (" + email + ")";
    }
}

