package ar.soft.api.Directory.DirectoryPojo;

import ar.soft.api.BaseApi.BaseApiTest;

public class DirectoryReg extends BaseApiTest {

    private String name;
    private Integer projectId;
    private Integer parentDirectoryId;

    public DirectoryReg() {
    }

    public DirectoryReg(String name, Integer projectId, Integer parentDirectoryId) {
        this.name = name;
        this.projectId = projectId;
        this.parentDirectoryId = parentDirectoryId;
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
}
