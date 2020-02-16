package om.metamorph.envelopes;

public class ErrorEnvelopeModel {

    private int httpCode;
    private String errorMessage;

    public ErrorEnvelopeModel() {
    }

    public ErrorEnvelopeModel(int httpCode, String errorMessage) {
        this.httpCode = httpCode;
        this.errorMessage = errorMessage;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
