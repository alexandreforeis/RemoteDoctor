package martinsreis.remotedoctor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etAltura = (EditText) findViewById(R.id.etAltura);
        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etNascimento = (EditText) findViewById(R.id.etNascimento);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final EditText etPeso = (EditText) findViewById(R.id.etPeso);
        final EditText etPhone = (EditText) findViewById(R.id.etPhone);
        final EditText etUsername = (EditText) findViewById(R.id.etEmail);
        final Button bRegister = (Button) findViewById(R.id.bRegister);
    }
}
