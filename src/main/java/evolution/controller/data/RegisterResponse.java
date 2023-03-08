package evolution.controller.data;

public class RegisterResponse {
    public Boolean success;
    public String message;

    public RegisterResponse() {

    }

    public RegisterResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
