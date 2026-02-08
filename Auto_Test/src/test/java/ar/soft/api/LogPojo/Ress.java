package ar.soft.api.LogPojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ress {

    private String timestamp;
    private String success;
    @JsonProperty("[\"data\"]-")
    private String data;

    private Integer id;
    private String creationDate;
//    private String data;
    private Integer accountId;
    private String accountEmail;


    public Ress() {
    }

    public Ress(String timestamp, String success, String data, Integer id, String creationDate, Integer accountId, String accountEmail) {
        this.timestamp = timestamp;
        this.success = success;
        this.data = data;
        this.id = id;
        this.creationDate = creationDate;
        this.accountId = accountId;
        this.accountEmail = accountEmail;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }
}
