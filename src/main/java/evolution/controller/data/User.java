package evolution.controller.data;

public class User {
    public String id;
    public String password;
    public String name;
    public String gender;
    public Integer age;
    public String education;

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public String getEducation() {
        return education;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", education='" + education + '\'' +
                '}';
    }
}
