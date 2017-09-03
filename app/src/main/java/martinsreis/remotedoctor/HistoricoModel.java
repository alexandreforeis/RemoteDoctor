package martinsreis.remotedoctor;

/**
 * Created by felip on 03/09/2017.
 */

public class HistoricoModel {

    private Boolean status;
    private String message;

    public HistoricoModel(Boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
