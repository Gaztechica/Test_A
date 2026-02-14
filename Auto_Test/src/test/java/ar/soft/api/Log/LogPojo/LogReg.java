package ar.soft.api.Log.LogPojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LogReg {

    private String creationDate;
    private String data;
    private Integer accountId;


    public LogReg() {
    }

    public LogReg(String creationDate, String data, Integer accountId) {
        this.creationDate = creationDate;
        this.data = data;
        this.accountId = accountId;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
