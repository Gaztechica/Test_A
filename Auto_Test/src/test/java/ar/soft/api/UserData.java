
package ar.soft.api;

public class UserData {

    private Integer id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;

    public UserData(Integer id, String email, String first_name, String last_name, String avatar) {
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    //    private Integer id;
//    private String name;
//    private String middleName;
//    private String last_name;
//    private String email;
//
//    public UserData(Integer id, String name, String middleName, String last_name, String email) {
//        this.id = id;
//        this.name = name;
//        this.middleName = middleName;
//        this.last_name = last_name;
//        this.email = email;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getMiddleName() {
//        return middleName;
//    }
//
//    public String getLast_name() {
//        return last_name;
//    }
//
//    public String getEmail() {
//        return email;
//    }

    //    public UserData(Integer id, String name, String middleName, String last_name, String email) {
//        this.id = id;
//        this.name = name;
//        this.middleName = middleName;
//        this.last_name = last_name;
//        this.email = email;
//    }

    //    public String position;
//    public String order;
//    public String timezone;
//    public int timezoneOffset;
//    public boolean active;
//    public boolean approvedByOrganization;
//    public ArrayList<Role> roles;
//    public String phoneNumber;
//    public String organizationName;
//    public int organizationId;
//    public License license;
//    public Employment employment;
//    public String headRole;
//    public Date lastActivity;
//    public boolean enable;
//    public ArrayList<Object> links;



}
