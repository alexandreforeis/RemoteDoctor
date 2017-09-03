package martinsreis.remotedoctor;

/**
 * Created by felip on 03/09/2017.
 */

public class LoginRequest {
    final String email;
    final String senha;

    public LoginRequest(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
}
