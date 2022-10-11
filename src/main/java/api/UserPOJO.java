package api;

public class UserPOJO {

    private String email;
    private String password;
    private String name;

    public String getEmail() {
        return email;
    }

    public UserPOJO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserPOJO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserPOJO setName(String name) {
        this.name = name;
        return this;
    }
}
