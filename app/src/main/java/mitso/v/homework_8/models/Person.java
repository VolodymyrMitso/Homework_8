package mitso.v.homework_8.models;

import java.io.Serializable;

public class Person implements Serializable {
    private String FirstName;
    private String LastName;
    private String gender;
    private String age;
    private String phoneNumber;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean atLeastOneEmptyField() {
        return
                FirstName.isEmpty() ||
                LastName.isEmpty() ||
                gender.isEmpty() ||
                age.isEmpty() ||
                phoneNumber.isEmpty();
    }
}