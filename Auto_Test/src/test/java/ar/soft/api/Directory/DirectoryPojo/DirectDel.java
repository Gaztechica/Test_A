package ar.soft.api.Directory.DirectoryPojo;

public class DirectDel {

    private String timestamp;
    private String success;

    public DirectDel() {
    }

    public DirectDel(String timestamp, String success) {
        this.timestamp = timestamp;
        this.success = success;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
