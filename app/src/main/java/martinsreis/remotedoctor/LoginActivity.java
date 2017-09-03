package martinsreis.remotedoctor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final Button bLogin = (Button) findViewById(R.id.bLogin);


        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = etEmail.getText().toString();
                final String password = etPassword.getText().toString();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://52.15.202.161/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                APIService service = retrofit.create(APIService.class);

                Call<PacienteModel> response =  service.login(new LoginRequest(email,password));
                response.enqueue(new Callback<PacienteModel>() {
                    @Override
                    public void onResponse(Call<PacienteModel> call, retrofit2.Response<PacienteModel> response) {
                        if(!response.body().getStatus()){
                            Toast.makeText(getApplicationContext(), (String)response.body().getMessage(),
                                    Toast.LENGTH_LONG).show();
                            return ;
                        }

                        //salvar token usando shared preferences
                        SharedPreferences sharedPref = LoginActivity.this.getPreferences(getApplicationContext().MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString(getString(R.string.token), response.body().getToken());
                        editor.commit();

                        //String token = sharedPref.getString(getString(R.string.token), "");


                        //linkar tela quando logar
                        Intent loginIntent = new Intent(LoginActivity.this, UserAreaActivity.class);
                        LoginActivity.this.startActivity(loginIntent);

                    }

                    @Override
                    public void onFailure(Call<PacienteModel> call, Throwable t) {
                        Log.w("tcc-api", "ERRO");
                    }
                });
            }
        });
    }
}




