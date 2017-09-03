package martinsreis.remotedoctor;

/**
 * Created by felip on 03/09/2017.
 */

public class PacienteModel {
    private Boolean status;
    private String token;
    private String message;

    public PacienteModel(Boolean status, String token, String message) {
        this.status = status;
        this.token = token;
        this.message = message;
    }

    public PacienteModel(Boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
