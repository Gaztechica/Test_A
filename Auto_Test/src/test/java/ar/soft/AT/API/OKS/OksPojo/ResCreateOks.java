package ar.soft.AT.API.OKS.OksPojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResCreateOks {

    private Integer id;
    private String name;
    private String generalPlanNumber;
    private Integer authorId;
    private String authorName;
    private Date created;
    private Date updated;
    private boolean visible;

    public ResCreateOks() {
    }

    public ResCreateOks(Integer id, String name, String generalPlanNumber, Integer authorId, String authorName, Date created, Date updated, boolean visible) {
        this.id = id;
        this.name = name;
        this.generalPlanNumber = generalPlanNumber;
        this.authorId = authorId;
        this.authorName = authorName;
        this.created = created;
        this.updated = updated;
        this.visible = visible;
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

    public String getGeneralPlanNumber() {
        return generalPlanNumber;
    }

    public void setGeneralPlanNumber(String generalPlanNumber) {
        this.generalPlanNumber = generalPlanNumber;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof ResCreateOks that)) return false;
//        return isVisible() == that.isVisible() && Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getGeneralPlanNumber(), that.getGeneralPlanNumber()) && Objects.equals(getAuthorId(), that.getAuthorId()) && Objects.equals(getAuthorName(), that.getAuthorName()) && Objects.equals(getCreated(), that.getCreated()) && Objects.equals(getUpdated(), that.getUpdated());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId(), getName(), getGeneralPlanNumber(), getAuthorId(), getAuthorName(), getCreated(), getUpdated(), isVisible());
//    }
}
