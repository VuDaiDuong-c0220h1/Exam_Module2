public class PersonContact {
    String name;
    int phoneNumber;
    String group;
    String gender;
    String address;
    String email;
    String birthday;

    public PersonContact(){}

    public PersonContact(int phoneNumber, String group, String name, String gender, String address, String birthday, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "PersonContact{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", group='" + group + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
