package ar.soft.AT.API.OKS.OksPojo;

import java.util.ArrayList;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class GetParam {

    private Integer projectId;
    private Integer page;
    private Integer size;
    private ArrayList<String> sort;

    public GetParam() {
    }

    public GetParam(Integer projectId) {
        this.projectId = projectId;
    }

    public GetParam(Integer projectId, Integer page, Integer size, ArrayList<String> sort) {
        this.projectId = projectId;
        this.page = page;
        this.size = size;
        this.sort = sort;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public ArrayList<String> getSort() {
        return sort;
    }

    public void setSort(ArrayList<String> sort) {
        this.sort = sort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetParam getParam)) return false;
        return Objects.equals(getProjectId(), getParam.getProjectId()) && Objects.equals(getPage(), getParam.getPage()) && Objects.equals(getSize(), getParam.getSize()) && Objects.equals(getSort(), getParam.getSort());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProjectId(), getPage(), getSize(), getSort());
    }
}
