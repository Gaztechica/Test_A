package ar.soft.api.Account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenResponce {

    private String token;

//    public TokenResponce() {
//    }

    public TokenResponce(String token) {
        this.token = token;
    }

    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    }
