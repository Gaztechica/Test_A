package ar.soft.api.Account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountLoginPojo {

    private Integer id;
    private String name;
    private String middleName;
    private String timezone;
    private Integer timezoneOffset;
    private boolean active;
    private boolean approvedByOrganization;
//    private ArrayList<Role> roles;
    private String email;
    private String phoneNumber;
    private String organizationName;
    private Integer organizationId;
//    private License license;
//    private Employment employment;
    private String headRole;
//    private Date lastActivity;
//    private ArrayList<Object> projectsInfos;
    private boolean enable;
//    private ArrayList<Object> links;
    private String last_name;

    public AccountLoginPojo() {
    }

    public AccountLoginPojo(Integer id, String name, String middleName, String timezone, Integer timezoneOffset, boolean active, boolean approvedByOrganization, String email, String phoneNumber, String organizationName, Integer organizationId, String headRole, boolean enable, String last_name) {
        this.id = id;
        this.name = name;
        this.middleName = middleName;
        this.timezone = timezone;
        this.timezoneOffset = timezoneOffset;
        this.active = active;
        this.approvedByOrganization = approvedByOrganization;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.organizationName = organizationName;
        this.organizationId = organizationId;
        this.headRole = headRole;
        this.enable = enable;
        this.last_name = last_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountLoginPojo that = (AccountLoginPojo) o;
        return active == that.active && approvedByOrganization == that.approvedByOrganization && enable == that.enable && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(middleName, that.middleName) && Objects.equals(timezone, that.timezone) && Objects.equals(timezoneOffset, that.timezoneOffset) && Objects.equals(email, that.email) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(organizationName, that.organizationName) && Objects.equals(organizationId, that.organizationId) && Objects.equals(headRole, that.headRole) && Objects.equals(last_name, that.last_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, middleName, timezone, timezoneOffset, active, approvedByOrganization, email, phoneNumber, organizationName, organizationId, headRole, enable, last_name);
    }
}
