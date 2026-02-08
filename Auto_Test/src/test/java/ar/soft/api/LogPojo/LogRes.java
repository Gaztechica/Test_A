package ar.soft.api.LogPojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LogRes  {

    private String creationDate;
    private String data;
    private String accountId;
    private String accountEmail;
    private Integer id;


    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    @JsonProperty("[\"data\"]-")
        public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LogRes() {
    }

    public LogRes(String creationDate, String data, String accountId, String accountEmail, Integer id) {
        this.creationDate = creationDate;
        this.data = data;
        this.accountId = accountId;
        this.accountEmail = accountEmail;
        this.id = id;
    }
}
