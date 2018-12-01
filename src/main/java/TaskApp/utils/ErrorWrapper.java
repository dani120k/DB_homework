package TaskApp.utils;

public class ErrorWrapper {
    private String description;
    private Long errorCode;

    public ErrorWrapper(Long errorCode, String description){
        this.errorCode = errorCode;
        this.description = description;
    }

    public Long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Long errorCode) {
        this.errorCode = errorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
