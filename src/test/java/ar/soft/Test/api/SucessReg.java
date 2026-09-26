package ar.soft.Test.api;

public class SucessReg {

    private Integer id;
    private String token;

    public SucessReg(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }
}
