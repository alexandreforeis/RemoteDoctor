package martinsreis.remotedoctor;


import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.samsung.android.sdk.healthdata.HealthConnectionErrorResult;
import com.samsung.android.sdk.healthdata.HealthDataService;
import com.samsung.android.sdk.healthdata.HealthDataStore;
import com.samsung.android.sdk.healthdata.HealthPermissionManager;
import com.samsung.android.sdk.healthdata.HealthConnectionErrorResult;
import com.samsung.android.sdk.healthdata.HealthConstants;
import com.samsung.android.sdk.healthdata.HealthDataService;
import com.samsung.android.sdk.healthdata.HealthDataStore;
import com.samsung.android.sdk.healthdata.HealthPermissionManager;
import com.samsung.android.sdk.healthdata.HealthPermissionManager.PermissionKey;
import com.samsung.android.sdk.healthdata.HealthPermissionManager.PermissionType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;


public class UserAreaActivity extends AppCompatActivity {
    public static final String APP_TAG = "RemoteDoctor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        final TextView tvMsgUserArea = (TextView) findViewById(R.id.tvMsgUserArea);
        final Button bSendData = (Button) findViewById(R.id.bSendData);

        //Get token
        SharedPreferences sharedPref = UserAreaActivity.this.getPreferences(getApplicationContext().MODE_PRIVATE);
        String token = sharedPref.getString(getString(R.string.token),"");

        //Exibe mensagem na tela do usuario
        String messageMedicoes = "Não se esqueça de fazer todas as medições e atualizar o dados no Samsung Health antes de enviar os dados.";
        tvMsgUserArea.setText(messageMedicoes);



        //Enviar dados do Samsung Health
        bSendData.setOnClickListener(new View.OnClickListener() {

            private final HealthDataStore.ConnectionListener mConnectionListener = new HealthDataStore.ConnectionListener() {
                @Override
                public void onConnected() {
                    Log.d(APP_TAG, "Health data service is connected.");
                    HealthPermissionManager pmsManager = new HealthPermissionManager(mStore);
                    try {
                        requestPermission();
                    } catch (Exception e) {
                        Log.e(APP_TAG, e.getClass().getName() + " - " + e.getMessage());
                        Log.e(APP_TAG, "Permission setting fails.");
                    }
                }
                @Override
                public void onConnectionFailed(HealthConnectionErrorResult error) {
                    Log.d(APP_TAG, "Health data service is not available.");
                    showConnectionFailureDialog(error);
                }
                @Override
                public void onDisconnected() {
                    Log.d(APP_TAG, "Health data service is disconnected.");
                }
            };


            HealthDataStore mStore = new HealthDataStore(UserAreaActivity.this, mConnectionListener);
            @Override
            public void onClick(View v) {
                //implementar ação do botão enviar dados
                HealthDataService healthDataService = new HealthDataService();
                try {
                    healthDataService.initialize(UserAreaActivity.this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // Request the connection to the health data store
                mStore.connectService();
            }


            private void showConnectionFailureDialog(final HealthConnectionErrorResult error) {
                Toast.makeText(getApplicationContext(), "Erro ao conectar ao Samsung HEalth",
                        Toast.LENGTH_LONG).show();

            }

            private void requestPermission() {

                HealthPermissionManager pmsManager = new HealthPermissionManager(mStore);
                try {
                    // Show user permission UI for allowing user to change options

                    Set<PermissionKey> pmsKeySet = new HashSet<>();
                    pmsKeySet.add(new PermissionKey(HealthConstants.BloodPressure.HEALTH_DATA_TYPE, PermissionType.READ));
                    pmsKeySet.add(new PermissionKey(HealthConstants.Weight.HEALTH_DATA_TYPE, PermissionType.READ));
                    pmsKeySet.add(new PermissionKey(HealthConstants.OxygenSaturation.HEALTH_DATA_TYPE, PermissionType.READ));
                    pmsKeySet.add(new PermissionKey(HealthConstants.HeartRate.HEALTH_DATA_TYPE, PermissionType.READ));

                    pmsManager.requestPermissions(pmsKeySet, UserAreaActivity.this);





                } catch (Exception e) {
                    Log.e(APP_TAG, "Permission setting fails.", e);
                }
            }

        });



    }


}
