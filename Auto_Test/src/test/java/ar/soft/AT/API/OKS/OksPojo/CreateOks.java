package ar.soft.AT.API.OKS.OksPojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateOks {

    private String name;
    private String generalPlanNumber;

    public CreateOks() {
    }

    public CreateOks(String name, String generalPlanNumber) {
        this.name = name;
        this.generalPlanNumber = generalPlanNumber;
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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof CreateOks createOks)) return false;
//        return Objects.equals(getName(), createOks.getName()) && Objects.equals(getGeneralPlanNumber(), createOks.getGeneralPlanNumber());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getName(), getGeneralPlanNumber());
//    }
}
