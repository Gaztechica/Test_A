package ar.soft.api.Directory.DirectoryPojo;

import ar.soft.api.BaseApi.BaseApiTest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DirectRename extends BaseApiTest {

    private Integer id;
    private String name;
    private Integer projectId;
    private Integer parentDirectoryId;
    private ArrayList<Object> descendantDirectories;
    private ArrayList<Object> filesInDirectory;

    public DirectRename() {
    }

    public DirectRename(Integer id, String name, Integer projectId, Integer parentDirectoryId, ArrayList<Object> descendantDirectories, ArrayList<Object> filesInDirectory) {
        this.id = id;
        this.name = name;
        this.projectId = projectId;
        this.parentDirectoryId = parentDirectoryId;
        this.descendantDirectories = descendantDirectories;
        this.filesInDirectory = filesInDirectory;
    }

    public DirectRename(Integer id, String name, Integer projectId, Integer parentDirectoryId) {
        this.id = id;
        this.name = name;
        this.projectId = projectId;
        this.parentDirectoryId = parentDirectoryId;
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

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getParentDirectoryId() {
        return parentDirectoryId;
    }

    public void setParentDirectoryId(Integer parentDirectoryId) {
        this.parentDirectoryId = parentDirectoryId;
    }

    public ArrayList<Object> getDescendantDirectories() {
        return descendantDirectories;
    }

    public void setDescendantDirectories(ArrayList<Object> descendantDirectories) {
        this.descendantDirectories = descendantDirectories;
    }

    public ArrayList<Object> getFilesInDirectory() {
        return filesInDirectory;
    }

    public void setFilesInDirectory(ArrayList<Object> filesInDirectory) {
        this.filesInDirectory = filesInDirectory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DirectRename that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getProjectId(), that.getProjectId()) && Objects.equals(getParentDirectoryId(), that.getParentDirectoryId()) && Objects.equals(getDescendantDirectories(), that.getDescendantDirectories()) && Objects.equals(getFilesInDirectory(), that.getFilesInDirectory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getProjectId(), getParentDirectoryId(), getDescendantDirectories(), getFilesInDirectory());
    }
}
