package ar.soft.api.Account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class LoginReguest {

    private String token;

    private String password;
    private String email;

    public LoginReguest() {
    }

    public LoginReguest(String password, String email) {
        this.password = password;
        this.email = email;
    }

    @JsonProperty("password")
        public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("email")
        public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginReguest that = (LoginReguest) o;
        return Objects.equals(password, that.password) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password, email);
    }
}
