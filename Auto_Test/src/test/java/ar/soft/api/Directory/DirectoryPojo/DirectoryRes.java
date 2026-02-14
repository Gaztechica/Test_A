package ar.soft.api.Directory.DirectoryPojo;

import ar.soft.api.BaseApi.BaseApiTest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DirectoryRes {

    private Integer id;
    private String name;
    private Integer projectId;
    private Integer parentDirectoryId;
    private boolean filesInDirectory;
    private boolean descendantDirectories;

           public DirectoryRes() {
    }

    public DirectoryRes(Integer id, String name, Integer projectId, Integer parentDirectoryId, boolean filesInDirectory, boolean descendantDirectories) {
        this.id = id;
        this.name = name;
        this.projectId = projectId;
        this.parentDirectoryId = parentDirectoryId;
        this.filesInDirectory = filesInDirectory;
        this.descendantDirectories = descendantDirectories;
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

    public boolean isFilesInDirectory() {
        return filesInDirectory;
    }

    public void setFilesInDirectory(boolean filesInDirectory) {
        this.filesInDirectory = filesInDirectory;
    }

    public boolean isDescendantDirectories() {
        return descendantDirectories;
    }

    public void setDescendantDirectories(boolean descendantDirectories) {
        this.descendantDirectories = descendantDirectories;
    }
}
