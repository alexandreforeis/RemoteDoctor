package martinsreis.remotedoctor;

/**
 * Created by felip on 24/08/2017.
 */

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "http://remotedoctor.000webhostapp.com/Login.php";
    private Map<String, String> params;

    public LoginRequest(String email, String password, Response.Listener<String> listener) {
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("email", email);
        params.put("pass", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}