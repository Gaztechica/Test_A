package ar.soft.api.Сhecklist.ChecklisPojo;

import ar.soft.api.BaseApi.BaseApiTest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChecklistRes extends BaseApiTest {

    private Integer id;
    private String name;
    private Integer authorId;
    private String authorFirstName;
    private String authorLastName;
    private String creationDate;
    private String editDate;
    private boolean active;
    private String flat;


    public ChecklistRes() {
    }

    public ChecklistRes(Integer id, String name, Integer authorId, String authorFirstName, String authorLastName, String creationDate, String editDate, boolean active, String flat) {
        this.id = id;
        this.name = name;
        this.authorId = authorId;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.creationDate = creationDate;
        this.editDate = editDate;
        this.active = active;
        this.flat = flat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getEditDate() {
        return editDate;
    }

    public void setEditDate(String editDate) {
        this.editDate = editDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }
}
