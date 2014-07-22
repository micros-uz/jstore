package uz.micros.jstore.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class RegUserDto {

    @NotEmpty
    @Size(max = 15)
    private String firstName;

    @NotEmpty
    @Size(max = 15)
    private String lastName;

    @NotEmpty
    @Size(max = 10)
    private String userName;

    @NotEmpty
    @Size(max = 10)
    private String password;

    @NotEmpty
    @Size(max = 10)
    private String password2;

    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
