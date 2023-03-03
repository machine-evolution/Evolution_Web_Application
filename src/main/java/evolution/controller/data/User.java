package evolution.controller.data;

public class User {
    public String id;
    public String password;
    public String name;
    public String gender;
    public Integer age;
    public String education;

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
